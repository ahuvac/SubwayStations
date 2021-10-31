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

        public List<Station> getConnections(Map<Integer, Station> stations, SubwayLines lines) {
            for (String line : lines.keySet()) {
                int[] stationsOfLine = lines.get(line);
                for (int i = 0; i < stationsOfLine.length - 1; i++) {
                    stations.get(stationsOfLine[i]).connect(stations.get(stationsOfLine[i + 1]));
                }
            }
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

    public Map<Integer, Station> getStationMap(){
        Map<Integer, SubwaySystem.Station> stationMap = new HashMap<>();
        for(SubwaySystem.Station station : this.features){
            stationMap.put(station.properties.objectid, station);
        }
        return stationMap;
    }


}





