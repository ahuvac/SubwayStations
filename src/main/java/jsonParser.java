import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class jsonParser {

    public SubwaySystem parseStationsJSON() throws IOException {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/stations.json"));
        return gson.fromJson(reader, SubwaySystem.class);
    }

//    public SubwayLines parseStationsJSON() throws IOException {
//        Gson gson = new Gson();
//        Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/lines.json"));
//        return gson.fromJson(reader, SubwayLines.class);
//    }
}
