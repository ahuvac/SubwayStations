import java.util.*;

public class SubwaySystem {

    List<Station> features;

    static class Station {
        Properties properties;
        Geometry geometry;
        List<Station> connections;

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

    public int getIDFromName(String name) {
        for (Station station : features) {
            if (station.properties.name.equals(name)) {
                return station.properties.objectid;
            }
        }
        return -1;
    }

    public void connectStations(SubwayLines lines, Map<Integer, Station> stations) {
        for (String line : lines.keySet()) {
            int[] stationsOfLine = lines.get(line);
            for (int i = 0; i < stationsOfLine.length - 1; i++) {
                stations.get(stationsOfLine[i]).connect(stations.get(stationsOfLine[i + 1]));
            }
        }
    }

//    public List<Integer> findShortestPath(Coordinates start, Coordinates end){
//
//    }
//    public class Node {
//
//        private String name;
//
//        private List<Node> shortestPath = new LinkedList<>();
//
//        private Integer distance = Integer.MAX_VALUE;
//
//        Map<Node, Integer> adjacentNodes = new HashMap<>();
//
//        public void addDestination(Node destination, int distance) {
//            adjacentNodes.put(destination, distance);
//        }
//
//        public Node(String name) {
//            this.name = name;
//        }
//
//        // getters and setters
//    }

//    public  List<Integer> findShortestPath(List<Integer> connections, Coordinates start, Coordinates end) {
//        source.setDistance(0);
//
//        Set<Node> settledNodes = new HashSet<>();
//        Set<Node> unsettledNodes = new HashSet<>();
//
//        unsettledNodes.add(source);
//
//        while (unsettledNodes.size() != 0) {
//            Node currentNode = getLowestDistanceNode(unsettledNodes);
//            unsettledNodes.remove(currentNode);
//            for (Entry < Node, Integer> adjacencyPair:
//                    currentNode.getAdjacentNodes().entrySet()) {
//                Node adjacentNode = adjacencyPair.getKey();
//                Integer edgeWeight = adjacencyPair.getValue();
//                if (!settledNodes.contains(adjacentNode)) {
//                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
//                    unsettledNodes.add(adjacentNode);
//                }
//            }
//            settledNodes.add(currentNode);
//        }
//        return graph;
//    }
}





