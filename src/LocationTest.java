import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class LocationTest {

    Location location;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        ArrayList<Integer> neighbors = new ArrayList<>();
        neighbors.add(2);
        location = new Location("Tavern", 3, neighbors);
    }

    @org.junit.jupiter.api.Test
    public void testLocationName() {
        assertEquals("StartLocation", location.getName(), "Wrong loc name");
    }

    @org.junit.jupiter.api.Test
    public void testLocationId() {
        assertEquals(2, location.getId(), "Wrong ID");
    }

    @org.junit.jupiter.api.Test
    public void testLocationNeighbors() {
        ArrayList<Integer> neighbors = location.getNeighborIds();
        assertNotNull(neighbors);
        assertTrue(neighbors.contains(2));
    }

    @org.junit.jupiter.api.Test
    public void testLocationLockedStatus() {
        assertFalse(location.locked() );
    }
}
