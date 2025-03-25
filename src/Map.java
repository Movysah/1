import java.util.ArrayList;

public class Map {


    public Map(String mapFile) {

        locations = new ArrayList<>();
        mapReader = new MapLoader(mapFile);
        loadMap();
    }


    private ArrayList<Location> locations;
    private MapLoader mapReader;

    public void loadMap() {

        for (int i = 0; i < mapReader.getNumOfLocs() / 4; i++) {
            Location location = new Location(mapReader.getName(i), mapReader.getId(i), mapReader.getNeighbor(i));
            locations.add(location);
        }
    }



    public ArrayList<Location> getLocations() {
        return locations;
    }


}
