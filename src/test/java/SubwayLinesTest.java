import com.google.gson.Gson;
import org.junit.Test;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class SubwayLinesTest {

    @Test
    public void jsonToLines() throws IOException {
        //given
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/SubwayLines.json"));

        //when
        SubwayLines lineList = gson.fromJson(reader, SubwayLines.class);
        reader.close();

        //then
        assertNotNull(lineList);
    }

    @Test
    public void getLines() throws IOException {
        //given
        Gson gson = new Gson();
        Reader lineReader = Files.newBufferedReader(Paths.get("src/main/resources/SubwayLines.json"));
        Reader stationReader = Files.newBufferedReader(Paths.get("src/main/resources/SubwayStations.json"));

        //when
        SubwayLines lineList = gson.fromJson(lineReader, SubwayLines.class);
        SubwaySystem stationList = gson.fromJson(stationReader, SubwaySystem.class);

        lineReader.close();
        stationReader.close();

        //then

        ArrayList<String> connectionsBeach = lineList.getConnectedStations(lineList, stationList, "Far Rockaway - Mott Ave");

        assertNotNull(connectionsBeach);
        assertEquals(1, connectionsBeach.size());
        assertEquals("Beach 25th St",stationList.getNameFromID(Integer.parseInt(connectionsBeach.get(0))));



        ArrayList<String> connections59 = lineList.getConnectedStations(lineList, stationList, "Beach 25th St");
        assertNotNull(connections59.get(0));
        assertEquals("Far Rockaway - Mott Ave", stationList.getNameFromID(Integer.parseInt(connections59.get(0))));


        ArrayList<String> connectionsAstor = lineList.getConnectedStations(lineList, stationList,"Astor Pl");
        assertTrue(connectionsAstor.contains("457"));
    }
}
