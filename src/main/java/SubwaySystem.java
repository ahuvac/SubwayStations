import java.util.List;

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

    public int getIDFromName(String name) {
        for (int i = 0; i < features.size(); i++) {
            if (features.get(i).properties.name.equals(name)) {
                return features.get(i).properties.objectid;
            }
        }
        return -1;
    }

    public List<Double> getCoordinates(String name) {
        for (int i = 0; i < features.size(); i++) {
            if (features.get(i).properties.name.equals(name)) {
                return features.get(i).geometry.coordinates;
            }
        }
        return null;
    }

    public String[] getLines(String name) {
        String lines = null;
        for (int i = 0; i < features.size(); i++) {
            if (features.get(i).properties.name.equals(name)) {
                lines = features.get(i).properties.line;
                return lines.split("-");
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

//    public Double getDistance(int stationId1, int stationId2) {
//        int index1 = 0;
//        int index2 = 0;
//
//        for (int i = 0; i < features.size(); i++) {
//
//            if (features.get(i).properties.objectid == stationId1) {
//                index1 = i;
//            } else if (features.get(i).properties.objectid == stationId2) {
//                index2 = i;
//            }
//            return (Math.sqrt(
//                    Math.pow(features.get(index2).geometry.coordinates.get(0)
//                            - features.get(index1).geometry.coordinates.get(0), 2)
//                            +
//                            Math.pow(features.get(index2).geometry.coordinates.get(1)
//                                    - features.get(index1).geometry.coordinates.get(1), 2)));
//        }
//
//        return 0.0;
//    }
}





