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

            public List getCoordinates() {
                return coordinates;
            }

        }
//        public List getConnections() {
//            List<Station> Connections;// (List of Stations that this station is connected to)
//        }
    }

    public String getNameFromID(int id) {
        for (int i = 0; i < features.size(); i++) {
            if (features.get(i).properties.objectid == id) {
                return features.get(i).properties.name;
            }
        }
        return null;
    }



}




