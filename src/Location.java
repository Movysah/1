import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Represents a location in the game.
 */
public class Location {

    private String name;
    private int id;
    private ArrayList<Integer> neighborIds;

    /**
     * Creates a new location.
     */
    public Location(String name, int id, ArrayList<Integer> neighborIds) {
        this.name = name;
        this.id = id;
        this.neighborIds = neighborIds;
    }

    /**
     * Checks if the location is locked by reading from a map file.
     */
    public boolean locked() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Mapfile"));
            String text;
            while ((text = reader.readLine()) != null) {
                if (text.equalsIgnoreCase(name)) {
                    for (int i = 0; i < 3; i++) {
                        text = reader.readLine();
                    }
                    return text.equals("true");
                }
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    /**
     * Returns the list of neighboring location IDs.
     */
    public ArrayList<Integer> getNeighborIds() {
        return neighborIds;
    }

    /**
     * Returns the name of the location.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the ID of the location.

     */
    public int getId() {
        return id;
    }
}
