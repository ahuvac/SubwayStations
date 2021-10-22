import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubwayLines {

    public Map<String, String[]> SubwayLines;

    public ArrayList<String> getConnectedLines() {
        SubwaySystem system = new SubwaySystem();
        ArrayList<String> connectedLines = new ArrayList<>();
        for(String line: SubwayLines.keySet()){
            for (String connection: SubwayLines.get(line)){
                connectedLines.add(system.getNameFromID(Integer.parseInt(connection)));
            }
        }
        return connectedLines;
    }
}
