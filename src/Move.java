import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Move implements Command {


    public Move() {
        location_index = 2;
    }

    private int location_index;
    private Map map;


    public String getCurrentLocation() {
        return map.getLocations().get(location_index).getName() + "   ";

    }

    Scanner scan = new Scanner(System.in);

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
                        System.out.println("succesful move");
                        return true;
                    } else {
                        System.out.println("the place is locked");
                        return false;
                    }
                }
            }
        }
        System.out.println("move failed");
        return false;
    }


    public void updateLocInFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("PlayerInfo", false))) {

            writer.write(String.valueOf(location_index));
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


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
