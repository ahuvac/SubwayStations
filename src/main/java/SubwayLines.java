import java.util.*;

public class SubwayLines extends HashMap<String, int[]> {


}


//    public void connectStations(SubwaySystem system) {
//        Map<Integer, SubwaySystem.Station> stationMap = system.getStations(system);
//
//        for(Map.Entry<Integer, SubwaySystem.Station> entry : stationMap.entrySet()) {
//            int stationId = entry.getKey();
//            String[] linesAtStation = system.getLines(stationId);
//
//            for (String line : linesAtStation) {
//                int[] stationsOfLine = this.get(line);
//
//                for (int i = 0; i < stationsOfLine.length; i++) {
//                    if (i != stationsOfLine.length - 1) { //if its not the last station in the list
//                        if (stationsOfLine[i] == stationId) {
//                            system.features.get(i).connect(system.features.get(i + 1));
//                        }
//                    }
//                }
//            }
//        }
//    }
//}



//
//    public void connectStations(SubwaySystem system) {
//        Map<Integer, SubwaySystem.Station> stationMap = system.getStations(system);
//        for(var entry : stationMap.entrySet()) {
//            int station = entry.getKey();
//            String[] linesAtStation = system.getLines(station);
//
//            for (String line : linesAtStation) {
//                List<Integer> stations = this.get(line);
//                for (Iterator<Integer> it = stations.iterator(); it.hasNext();) {
//                    int current = it.next();
//                    if (it.hasNext()) {
//                        if (current == station) {
//                            system.features.get(current).connect(system.features.get(current + 1));//current should be index in the features
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
//go through line list and connect every 2 lines