import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubwayLines extends HashMap<String, String[]> {
    public ArrayList<String> getConnectedLines(SubwayLines lines, SubwaySystem system, String station) {

        ArrayList<String> connectedLines = new ArrayList<>();

        for (String line : lines.get(station)){
            connectedLines.add(system.getNameFromID(Integer.parseInt(line.toString())));
        }

        return connectedLines;
    }
}

