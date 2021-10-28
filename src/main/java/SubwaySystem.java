import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubwaySystem {

    List<Station> features;

    static class Station {
        Properties properties;
        Geometry geometry;

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

            public List<Double> getCoordinates() {
                return coordinates;
            }

        }
    }

    public Map<Integer, Station> getStations(SubwaySystem system){
        Map<Integer, SubwaySystem.Station> stationMap = new HashMap<>();
        for(SubwaySystem.Station station : system.features){
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





