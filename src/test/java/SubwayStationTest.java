import com.google.gson.Gson;
import org.junit.Test;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class SubwayStationTest {



    @Test
    public void getName() {
        SubwayStations station = new SubwayStations();
        System.out.println(station.features);

        Map<?, ?> stations = new HashMap<>();

        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("../resources/stations.json"));

            // convert JSON file to map
            stations = gson.fromJson(reader, Map.class);

            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // assertEquals("Astor Pl", stations.get('name'));

    }
}
