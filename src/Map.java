import java.util.ArrayList;

public class Map {


    public Map() {

        locations = new ArrayList<>();
        MapReader mapReader = new MapReader();
        System.out.println(mapReader.getfiletext());

    }


    public ArrayList<Location> locations;
    MapReader mapReader;
}
