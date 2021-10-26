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

        ArrayList<SubwaySystem.Station> connectionsBeach = lineList.getConnectedStations(stationList, 55);

        assertNotNull(connectionsBeach);
        assertEquals(1, connectionsBeach.size());
        assertEquals(186, connectionsBeach.get(0).properties.objectid);



        ArrayList<SubwaySystem.Station> connections59 = lineList.getConnectedStations(stationList, 186);
        assertNotNull(connections59.get(0));
        assertEquals(55,connections59.get(0).properties.objectid);

    }
}
