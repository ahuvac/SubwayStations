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
        //System.out.println(lineList.get("1").length);
        assertNotNull(lineList);
    }

    @Test
    public void getConnectedLines() throws IOException {
        //given
        Gson gson = new Gson();
        Reader lineReader = Files.newBufferedReader(Paths.get("src/main/resources/SubwayLines.json"));
        Reader stationReader = Files.newBufferedReader(Paths.get("src/main/resources/SubwayStations.json"));

        //when
        SubwayLines lineList = gson.fromJson(lineReader, SubwayLines.class);
        SubwaySystem stationList = gson.fromJson(stationReader, SubwaySystem.class);

        Parser parser = new Parser();
        lineReader.close();
        stationReader.close();

        //then

//        ArrayList connections = lineList.getConnectedLines(lineList, stationList, "Astor Pl");
//        assertEquals(connections.get(0), "1");
    }




}
