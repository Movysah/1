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
                    location_index = location.getId();
                    System.out.println("succesful move");
                    return true;
                }
            }
        }
        System.out.println("move failed");
        return false;
    }


    @Override
    public String execute() {
        map = new Map("MapFile");
        travelTo();
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }


}
