import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Location {


    public Location(String name, int id, ArrayList<Integer> neighborIds) {
        this.name = name;
        this.id = id;
        this.neighborIds = neighborIds;
    }

    private String name;
    private int id;
    private ArrayList<Integer> neighborIds;

    public boolean locked() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Mapfile"));
            String text;
            while ((text = reader.readLine()) != null) {
                if (text.equals(id)) {
                    for (int i = 0; i < 2; i++) {
                        text = reader.readLine();
                    }
                    if (text.equals(true)) {
                        return true;
                    } else {
                        return false;
                    }
                }

            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }


    public ArrayList<Integer> getNeighborIds() {
        return neighborIds;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
