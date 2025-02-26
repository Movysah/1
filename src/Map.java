import java.util.ArrayList;

public class Map {


    public Map() {

        locations = new ArrayList<>();
        mapReader = new MapReader();
        System.out.println(mapReader.getfiletext());
        loadMap();

    }


    public ArrayList<Location> locations;
    MapReader mapReader;

    public void loadMap() {

        for (int i = 0; i < mapReader.getNumOfLoc()/3; i++) {
            Location location = new Location(mapReader.getName(i), mapReader.getId(i));
            locations.add(location);
        }
    }

}
