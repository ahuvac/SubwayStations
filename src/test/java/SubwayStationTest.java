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
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("/Users/ahuvacheifetz/Downloads/SubwayStationApplication/src/main/resources/stations.json"));

            // convert JSON string to station object
            stations = gson.fromJson(reader,SubwayStations.class);

            // print user object
            System.out.println(stations);

            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

         assertEquals("Astor Pl", stations.features.get(0).properties.getName());

    }
}
