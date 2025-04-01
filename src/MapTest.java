import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class MapTest {

    Map map;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        map = new Map("MapFile");
    }


    @org.junit.jupiter.api.Test
    public void testLoadMap() {
        assertNotNull(map.getLocations() );
        assertTrue(map.getLocations().size() > 0);
    }

    @org.junit.jupiter.api.Test
    public void testGetLocationById() {
        ArrayList<Location> locations = map.getLocations();
        assertNotNull(locations.get(3));
        assertEquals("Tavern", locations.get(3).getName(), "Název první lokace není správný");
    }


}
