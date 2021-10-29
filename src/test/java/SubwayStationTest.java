import com.google.gson.Gson;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class SubwayStationTest {

    @Test
    public void jsonToStations() throws IOException {
        //given
        jsonParser parser = new jsonParser();

        //when
        SubwaySystem stations = parser.parseStationsJSON();

        //then
        assertEquals("Astor Pl", stations.features.get(0).properties.getName());
        assertEquals("4-6-6 Express", stations.features.get(0).properties.line);
        assertNotNull(stations.features.get(0).geometry.coordinates);

    }
}
