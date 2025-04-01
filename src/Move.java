import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Move class allows the player to move between locations in the game.
 */
public class Move implements Command {

    private int location_index;
    private Map map;

    /**
     * The constructor sets the player's initial location.
     */
    public Move() {
        location_index = 2;
    }

    /**
     * Returns the name of the current player's location .
     */
    public String getCurrentLocation() {
        return map.getLocations().get(location_index).getName() + "   ";
    }

    Scanner scan = new Scanner(System.in);

    /**
     * This method allows the player to travel to a new location.
     */
    public boolean travelTo() {
        System.out.println("Your current location is " + getCurrentLocation());

        ArrayList<Integer> neighbours = map.getLocations().get(location_index).getNeighborIds();

        for (int id : neighbours) {
            System.out.println(map.getLocations().get(id).getName());
        }

        String locationName = scan.nextLine();

        for (Location location : map.getLocations()) {
            if (locationName.equalsIgnoreCase(location.getName())) {
                if (map.getLocations().get(location_index).getNeighborIds().contains(location.getId())) {
                    if (!map.getLocations().get(location.getId()).locked()) {
                        location_index = location.getId();
                        System.out.println(location.getName());
                        System.out.println("Successful move");
                        return true;
                    } else {
                        System.out.println("The place is locked.");
                        return false;
                    }
                }
            }
        }

        System.out.println("Move failed.");
        return false;
    }

    /**
     * Updates the player's location in the "PlayerInfo" file.
     */
    public void updateLocInFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("PlayerInfo", false))) {
            writer.write(String.valueOf(location_index));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Moves the player and updates their location in the file if the move is successful.
     */
    @Override
    public String execute() {
        map = new Map("MapFile");
        if (travelTo()) {
            updateLocInFile();
        }
        return "";
    }


    @Override
    public boolean exit() {
        return false;
    }
}
