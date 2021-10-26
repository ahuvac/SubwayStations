import java.util.*;

public class SubwayLines extends HashMap<String, String[]> {


    public ArrayList<String> getConnectedStations(SubwaySystem system, String stationName) {

        ArrayList<String> connections = new ArrayList<>();
        String[] linesAtStation = system.getLines(stationName);

        for (String line : linesAtStation){
            String[] stations = this.get(line);
            for(int i = 0; i< stations.length; i++){
                String previous = stations[i];
                if(stations.length > i + 1) {
                    String current = stations[i + 1];
                    String stationId = system.getIDFromName(stationName) + "";
                    if (previous.equals( stationId)) {
                        connections.add(current);
                    } else if (current.equals(stationId)) {
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
