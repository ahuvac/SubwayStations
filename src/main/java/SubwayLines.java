import java.util.*;

public class SubwayLines extends HashMap<String, int[]> {



    public Map<Integer, SubwaySystem.Station> getStations(SubwaySystem system){
        Map<Integer, SubwaySystem.Station> stationMap= new HashMap<>();
        for(int i = 0; i < system.features.size(); i++){
            stationMap.put(system.features.get(i).properties.objectid, system.features.get(i));
        }
        return stationMap;
    }

    public ArrayList<SubwaySystem.Station> getConnectedStations(SubwaySystem system, int station) {
        ArrayList<SubwaySystem.Station> connections = new ArrayList<>();
        String[] linesAtStation = system.getLines(station);

        Map<Integer, SubwaySystem.Station> stationMap = this.getStations(system);

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
                        if(stations.length > i+2) {
                            connections.add(stationMap.get(stations[i + 2]));
                        }
                    }
                }
           }
        }
        return connections;
    }
}
