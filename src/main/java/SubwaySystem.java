import java.util.List;

public class SubwaySystem {
    List<Features> features;

    static class Features {
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

        static class Geometry{

             List<Double> coordinates;

             public List getCoordinates() {
                return coordinates;
              }

        }
//        public List getConnections() {
//            List<Station> Connections;// (List of Stations that this station is connected to)
//        }
    }
}
