import java.util.ArrayList;

public class Location {


    public Location(String name, int id, ArrayList<Integer> neighborIds) {
        this.name = name;
        this.id = id;
         this.neighborIds = neighborIds;
    }

    private String name;
    private int id;
    private ArrayList<Integer> neighborIds;



    public ArrayList<Integer> getNeighborIds() {
        return neighborIds;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
