import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Command to display the player's inventory.
 */
public class Inventory implements Command {

    /**
     * Displays the player's inventory.
     */
    @Override
    public String execute() {
        ArrayList<String> inventory = getFileData("InventoryText");

        for (int i = 0; i < inventory.size()-1; i += 4) {
            if (!inventory.get(i + 3).equals("0")) {
                System.out.println(inventory.get(i + 3) + "x " + inventory.get(i + 1));

            }
        }
        return "";
    }

    /**
     * Reads the data from the specified file.
     *
     * @return A list of strings representing the data in the file.
     */
    public ArrayList<String> getFileData(String filename) {
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

    @Override
    public boolean exit() {
        return false;
    }
}
