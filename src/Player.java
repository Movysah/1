public class Player {


    public Player(int location_index, String file_name) {
        this.location_index = location_index;
        map = new Map(file_name);
    }

    private int location_index;
    private Map map;

    public boolean travelTo(String locationName) {
        for (Location location : map.getLocations()) {
            if (locationName.equalsIgnoreCase(location.getName())) {
                if (location.getNeighborIds().contains(location_index)) {
                    location_index = location.getId();
                    return true;
                }
            }
        }
        return false;
    }

    public String getCurrentLocation() {
        return map.getLocations().get(location_index).getName()+"   "+location_index;

    }

}
