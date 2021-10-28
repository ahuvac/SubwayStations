import java.util.*;

public class SubwayLines extends HashMap<String, int[]> {





    public ArrayList<SubwaySystem.Station> getConnectedStations(SubwaySystem system, int station) {
        ArrayList<SubwaySystem.Station> connections = new ArrayList<>();
        String[] linesAtStation = system.getLines(station);

        Map<Integer, SubwaySystem.Station> stationMap = system.getStations(system);

        Iterator<Entry<Integer, SubwaySystem.Station>> it = stationMap.entrySet().iterator();

        for (String line : linesAtStation){

            int[] stations = this.get(line);

            if (it.hasNext()) {
                Entry<Integer, SubwaySystem.Station> previous = it.next();

                if (it.hasNext()) {
                    Entry<Integer, SubwaySystem.Station> current = it.next();
                    if (previous.getValue().properties.objectid == station) {
                        connections.add(stationMap.get(current));
                    } else if (current.getValue().properties.objectid == station) {
                        connections.add(stationMap.get(previous));
                        if(it.hasNext()){
                            connections.add(stationMap.get(it.next()));
                        }
                    }
                }
           }
        }

        return connections;
    }
}
