import com.google.gson.Gson;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SubwayStationTest {



    @Test
    public void getName() throws IOException {
        //given
        Gson gson = new Gson();
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get("src/main/resources/stations.json"));
        } catch (Exception ex) {
            //ex.printStackTrace();
            fail("file not found");
        }

        //when
        SubwayStations stations = gson.fromJson(reader,SubwayStations.class);
        String name = stations.features.get(0).properties.getName();
        reader.close();

        //then
        assertEquals("Astor Pl", name);
    }
}
