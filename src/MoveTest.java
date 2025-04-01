import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

public class MoveTest {

    Move move;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        move = new Move();
    }

    @org.junit.jupiter.api.Test
    public void testTravelTo() {
        boolean result = move.travelTo();
        assertTrue(result);
    }

    @org.junit.jupiter.api.Test
    public void testUpdateLocInFile() {
        move.updateLocInFile();
        File file = new File("PlayerInfo");
        assertTrue(file.exists());
    }
}
