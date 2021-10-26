import java.util.*;

public class SubwayLines extends HashMap<String, String[]> {

    public ArrayList<String> getConnectedStations(SubwayLines lines, SubwaySystem system, String stationName) {
        ArrayList<String> connections = new ArrayList<>();
        String[] linesAtStation = system.getLines(stationName);

        for (String line : linesAtStation){
            String[] stations = lines.get(line);
            for(int i = 0; i< stations.length; i++){
                String previous = stations[i];
                if(stations.length > i + 1) {
                    String current = stations[i + 1];
                    if (previous.equals(system.getIDFromName(stationName) + "")) {
                        connections.add(current);
                    } else if (current.equals(system.getIDFromName(stationName) + "")) {
                        connections.add(previous);
                        if(stations.length > i+2) {
                            connections.add(stations[i + 2]);
                        }
                    }
                }
           }
        }
        return connections;
    }
}
