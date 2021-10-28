import java.util.*;

public class SubwayLines extends HashMap<String, int[]> {





    public ArrayList<SubwaySystem.Station> getConnectedStations(SubwaySystem system, int station) {
        ArrayList<SubwaySystem.Station> connections = new ArrayList<>();
        String[] linesAtStation = system.getLines(station);

        Map<Integer, SubwaySystem.Station> stationMap = system.getStations(system);

        for (String line : linesAtStation){
            int[] stations = this.get(line);
            for(int i = 0; i < stations.length; i++){
                int previous = stations[i];
                if(stations.length > i + 1) {
                    int current = stations[i + 1];
                    if (previous == station) {
                        connections.add(stationMap.get(current));
                    } else if (current == station) {
                        connections.add(stationMap.get(previous));
                        if(i + 1 != stations.length - 1) { //checking that its not the last station in the list
                            connections.add(stationMap.get(stations[i + 2]));
                        }
                    }
                }
           }
        }
        return connections;
    }
}
