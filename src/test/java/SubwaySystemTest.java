import com.google.gson.Gson;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

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

        Map<Integer, SubwaySystem.Station> stations = stationList.getStationMap();


        //when
        stationList.connectStations(lineList, stations);
        List<SubwaySystem.Station> connections = stationList.features.get(56).connections;
        List<SubwaySystem.Station> connections59 = stationList.features.get(93).connections;

        //then
        assertNotNull(connections);
        assertEquals(165, connections.get(0).properties.objectid);

        assertNotNull(connections59.get(0));
        assertEquals(3,connections59.get(0).properties.objectid);

    }


    @Test
    public void findClosestStation() throws IOException {
        //given
        Gson gson = new Gson();
        Reader stationReader = Files.newBufferedReader(Paths.get("src/main/resources/SubwayStations.json"));
        SubwaySystem stationList = gson.fromJson(stationReader, SubwaySystem.class);
        stationReader.close();

        //when
        Coordinates coordinates = new Coordinates( -73.90087000018523, 40.88466700064976);

        //then
        assertEquals(6, stationList.findClosestStation(coordinates).properties.objectid);
    }


    @Test
    public void findShortestPath() throws IOException {
        //given
        Gson gson = new Gson();
        Reader stationReader = Files.newBufferedReader(Paths.get("src/main/resources/SubwayStations.json"));
        SubwaySystem stationList = gson.fromJson(stationReader, SubwaySystem.class);
        stationReader.close();
        SubwayGraph graph = new SubwayGraph(stationList);

        //when
        List<StationNode> connects = stationList.findShortestPath(graph, stationList.features.get(93), stationList.features.get(79));

        //then
        //assertEquals(3,connects.get(0).station.properties.objectid);
    }
}
