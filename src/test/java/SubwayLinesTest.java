import com.google.gson.Gson;
import org.junit.Test;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        System.out.println(lineList.SubwayLines.get("1").length);
        assertNotNull(lineList.SubwayLines);
    }

}
