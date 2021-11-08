//import java.util.*;
//
//public class SubwayGraph {
//    //private List<StationNode> nodes = new ArrayList<>();
//    List<StationNode> nodes = new ArrayList<>();
//    Map<SubwaySystem.Station, StationNode> map = new HashMap<>();
//
//    public List<StationNode> getNodes() {
//        return nodes;
//    }
////
////    public SubwayGraph(SubwaySystem system)
////    {
////        for(SubwaySystem.Station station: system.features)
////        {
////            StationNode node = null;
////            if(!map.containsKey(station))
////            {
////                node = new StationNode(station);
////                map.put(station, node);
////                //nodes.add(node);
////            }
////            for(SubwaySystem.Station connection: station.connections)
////            {
////                if(!map.containsKey(connection))
////                {
////                    StationNode connectionNode = new StationNode(connection);
////                    nodes.add(connectionNode);
////                    node.addAdjacent(connectionNode,1);
////                    connectionNode.addAdjacent(node,1);
////                    map.put(connection, connectionNode);
////                }
////            }
////        }
////    }
//
//    public void addNode(StationNode node) {
//        nodes.add(node);
//    }
//
//    public Map<SubwaySystem.Station, StationNode> getMap() {
//        return map;
//    }
//}
