import com.google.gson.Gson;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

public class SubwaySystemTest {

    @Test
    public void jsonToStations() throws IOException {
        //given
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/SubwayStations.json"));

        //when
        SubwaySystem stations = gson.fromJson(reader, SubwaySystem.class);
        reader.close();

        //then
        assertEquals("Astor Pl", stations.features.get(0).properties.name);
        assertEquals("4-6-6 Express", stations.features.get(0).properties.line);
        assertNotNull(stations.features.get(0).geometry.coordinates);
        assertEquals(1, stations.getIDFromName("Astor Pl"));

    }
    @Test
    public void getLines() throws IOException {
        //given
        Gson gson = new Gson();
        Reader lineReader = Files.newBufferedReader(Paths.get("src/main/resources/SubwayLines.json"));
        Reader stationReader = Files.newBufferedReader(Paths.get("src/main/resources/SubwayStations.json"));

        SubwayLines lineList = gson.fromJson(lineReader, SubwayLines.class);
        SubwaySystem stationList = gson.fromJson(stationReader, SubwaySystem.class);

        lineReader.close();
        stationReader.close();

        //when
        stationList.connectStations(lineList);

        //then
        List<SubwaySystem.Station> connections = stationList.features.get(56).getConnections();
        assertNotNull(connections);
        assertEquals(165, connections.get(0).properties.objectid);

        List<SubwaySystem.Station> connections59 = stationList.features.get(93).connections;
        assertNotNull(connections59.get(0));
        assertEquals(3,connections59.get(0).properties.objectid);

    }

}