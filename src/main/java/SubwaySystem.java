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

//        public Map<Object, Object> getAdjacentStations() {
//
//        }

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

//
    public List<StationNode> findShortestPath(SubwayGraph graph, Station start, Station end) {

        List<StationNode> unvisitedStations = graph.getNodes();
        List<StationNode> visitedStations = new ArrayList<>();
        StationNode sourceStation = graph.map.get(start);
        sourceStation.setDistance(0);
        //StationNode finalStation = map.get(end);
        visitedStations.add(sourceStation);
        while (unvisitedStations.size() != 0) {
            StationNode currentStation = unvisitedStations.get(unvisitedStations.size() - 1); //gets the last unvisited station
            unvisitedStations.remove(currentStation);
            for (Map.Entry< StationNode, Integer> adjacencyPair:
                    currentStation.getAdjacentNodes().entrySet()) {
                StationNode adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!visitedStations.contains(adjacentNode)) {
                    calculateMinimumDistance(currentStation, adjacentNode, edgeWeight);
                    unvisitedStations.add(adjacentNode);
                }
            }
            visitedStations.add(currentStation);
        }
        return visitedStations;
    }

    private static void calculateMinimumDistance( StationNode sourceNode, StationNode evaluationNode, double edgeWeight)
    {
        double sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeight < evaluationNode.getDistance())
        {
            evaluationNode.setDistance(sourceDistance + edgeWeight);
            LinkedList<StationNode> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

}





