import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubwaySystem {

    List<Station> features;

    static class Station {
        Properties properties;
        Geometry geometry;
        List<Station> connections;

        public List<Station> getConnections() {
            return connections;
        }

        public Station() {
            this.connections = new ArrayList<>();
        }

        public void connect(Station station) {
            this.connections.add(station);
            station.connections.add(this);
        }


        static class Properties {
            int objectid;
            String name;
            String line;

            public int getObjectid() {
                return objectid;
            }

            public String getName() {
                return name;
            }

            public String getLine() {
                return line;
            }
        }

        static class Geometry {
            List<Double> coordinates;
            Coordinates coords;

            public Coordinates getCoords(){
                this.coords = new Coordinates(coordinates.get(0), coordinates.get(1));
                return coords;
            }

            public List<Double> getCoordinates() {
                return coordinates;
            }

        }
    }

    public Station findClosestStation(Coordinates coords){
        Station closest = this.features.get(0);

        for(Station station : this.features){
            if(station.geometry.getCoords().getDistance(coords) < closest.geometry.getCoords().getDistance(coords)){
                closest = station;
            }
        }
        return closest;
    }
    public void connectStations(SubwayLines lines) {
        Map<Integer, Station> map = this.getStations();
        for (String line : lines.keySet()) {
            int[] stationsOfLine = lines.get(line);
            for (int i = 0; i < stationsOfLine.length - 1; i++) {
                map.get(stationsOfLine[i]).connect(map.get(stationsOfLine[i + 1]));;
            }
        }
    }

    public Map<Integer, Station> getStations(){
        Map<Integer, SubwaySystem.Station> stationMap = new HashMap<>();
        for(SubwaySystem.Station station : this.features){
            stationMap.put(station.properties.objectid, station);
        }
        return stationMap;
    }

    public int getIDFromName(String name) {
        for (Station station : features) {
            if (station.properties.name.equals(name)) {
                return station.properties.objectid;
            }
        }
        return -1;
    }

    public List<Double> getCoordinates(String name) {
        for (Station station : features) {
            if (station.properties.name.equals(name)) {
                return station.geometry.coordinates;
            }
        }
        return null;
    }

    public String[] getLines(int id) {
        String lines = null;
        for (Station station : features) {
            if (station.properties.objectid == id) {
                return station.properties.line.split("-");
            }
        }
        return null;
    }

    public String getNameFromID(int id) {
        for (Station station : features) {
            if (station.properties.objectid == id) {
                return station.properties.name;
            }
        }
        return null;
    }

}





