import com.google.gson.Gson;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CoordinatesTest {


    @Test
    public void getDistance() throws IOException {

        //given
        Coordinates coordinates1 = new Coordinates(-73.99106999861966,40.73005400028978);
        Coordinates coordinates2 = new Coordinates(-74.00019299927328,40.71880300107709);

        //when
        double distance = coordinates1.getDistance(coordinates2);

        //then
        assertEquals(distance, 0.014484962002362, 3);
    }
}