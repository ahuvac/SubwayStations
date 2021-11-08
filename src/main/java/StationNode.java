//import java.util.*;
//
//
//public class StationNode {
//    public SubwaySystem.Station station;
//    Map<StationNode, Integer> adjacentNodes = new HashMap<>();
//    private List<StationNode> shortestPath = new LinkedList<>();
//    private double distance = Integer.MAX_VALUE;
//
//
//    public StationNode(SubwaySystem.Station station){
//        this.station = station;
//    }
//
//    public void addDestination(StationNode destination, int distance) {
//        adjacentNodes.put(destination, distance);
//    }
//
//    public void setDistance(double distance) {
//        this.distance = distance;
//    }
//
//    public void addAdjacent(StationNode adjacent, int distance)
//    {
//        adjacentNodes.put(adjacent, distance);
//    }
//
//    public double getDistance() {
//        return distance;
//    }
//
//    public Map<StationNode, Integer> getAdjacentNodes() {
//        return adjacentNodes;
//    }
//
//    public void setShortestPath(List<StationNode> shortestPath)
//    {
//        this.shortestPath = shortestPath;
//    }
//
//    public List<StationNode> getShortestPath()
//    {
//        return shortestPath;
//    }
//}
