import com.google.gson.Gson;
import org.junit.Test;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SubwayStationTest {



    @Test
    public void getName() {
        SubwayStations stations = new SubwayStations();

        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("/Users/ahuvacheifetz/Downloads/SubwayStationApplication/src/main/resources/stations.json"));
            stations = gson.fromJson(reader,SubwayStations.class);
            System.out.println(stations);
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

         assertEquals("Astor Pl", stations.features.get(0).properties.getName());
    }
}
