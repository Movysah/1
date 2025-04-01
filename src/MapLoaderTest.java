import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class MapLoaderTest {

    MapLoader mapLoader;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        mapLoader = new MapLoader("MapFile");
    }

    @org.junit.jupiter.api.Test
    public void testGetFileText() {
        ArrayList<String> data = mapLoader.getfiletext("MapFile");
        assertNotNull(data);
        assertTrue(data.size() > 0);
    }

    @org.junit.jupiter.api.Test
    public void testGetNumOfLocs() {
        int numOfLocations = mapLoader.getNumOfLocs();
        assertTrue(numOfLocations > 0 );
    }
}
