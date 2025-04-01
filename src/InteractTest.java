import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class InteractTest {

    Interact interact;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        interact = new Interact();
    }

    @org.junit.jupiter.api.Test
    public void testShowgetNPCs() {
        String npcList = interact.showgetNPCs();
        assertNotNull(npcList);
        assertTrue(npcList.length() > 0);
    }

    @org.junit.jupiter.api.Test
    public void testGetNPCsData() {
        ArrayList<String> npcData = interact.getNPCsData();
        assertNotNull(npcData);
        assertTrue(npcData.size() > 0);
    }


    @org.junit.jupiter.api.Test
    public void testPlayerPosition() {
        int position = interact.playerPosition();
        assertTrue(position == 2);
    }




}
