import java.util.ArrayList;

/**
 * The Map class represents the map in the game.
 * It loads the locations and their neighbors from a file and allows access to these locations.
 */
public class Map {

    private ArrayList<Location> locations;
    private MapLoader mapReader;

    /**
     * The constructor initializes the map and loads the locations from the given map file.
     *
     * @param mapFile The name of the file that contains the map data.
     */
    public Map(String mapFile) {
        locations = new ArrayList<>();
        mapReader = new MapLoader(mapFile);
        loadMap();
    }

    /**
     * Loads the map locations from the file using the MapLoader.
     * Each location is created and added to the list of locations.
     */
    public void loadMap() {
        for (int i = 0; i < mapReader.getNumOfLocs() / 4; i++) {
            Location location = new Location(mapReader.getName(i), mapReader.getId(i), mapReader.getNeighbor(i));
            locations.add(location);
        }
    }

    /**
     * Gets the list of all locations in the game.
     *
     * @return The list of all Location objects in the map.
     */
    public ArrayList<Location> getLocations() {
        return locations;
    }
}

