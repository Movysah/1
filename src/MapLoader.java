import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Loads map data from a file and provides methods to access map related information.
 */
public class MapLoader {

    private ArrayList<String> stringsOfData;

    /**
     * Initializes the map loader and loads map data from the given file.
     */
    public MapLoader(String fileName) {
        stringsOfData = getfiletext(fileName);
    }

    /**
     * Reads the content of the given file and returns it as a list of strings.
     */
    public ArrayList<String> getfiletext(String filename) {
        ArrayList<String> ret = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String text;
            while ((text = reader.readLine()) != null) {
                ret.add(text);
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ret;
    }

    /**
     * Returns the number of locations in the map data.
     */
    public int getNumOfLocs() {
        return stringsOfData.size();
    }

    /**
     * Returns the name of a location at specified index.
     */
    public String getName(int index) {
        return stringsOfData.get(index * 4);
    }

    /**
     * Returns ID of a location .
     */
    public int getId(int index) {
        return Integer.parseInt(stringsOfData.get(index * 4 + 1));
    }

    /**
     * Returns the list of neighboring location IDs .
     */
    public ArrayList<Integer> getNeighbor(int index) {
        ArrayList<Integer> ret = new ArrayList<>();
        String[] neighbors = stringsOfData.get(index * 4 + 2).split(",");
        for (String s : neighbors) {
            ret.add(Integer.valueOf(s));
        }
        return ret;
    }
}
