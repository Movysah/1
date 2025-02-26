import java.util.ArrayList;

public class Location {


    public Location(String namme, int id, ArrayList<Integer> neighborIds) {
        this.namme = namme;
        this.id = id;
        this.neighborIds = neighborIds;
    }

    private String namme;
    private int id;
    private ArrayList<Integer> neighborIds;

}
