import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MapLoader {

    public MapLoader(String fileName) {

       // stringsOfData = new ArrayList<>();
        stringsOfData = getfiletext(fileName);
    }

    private ArrayList<String> stringsOfData;

    public ArrayList<String> getfiletext(String filename) {

        ArrayList<String> ret = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String text ;
            while ((text = reader.readLine()) != null) {
                ret.add(text);

            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ret;
    }

    public int getNumOfLocs(){
        return stringsOfData.size();
    }

    public String getName(int index) {
        return stringsOfData.get(index*4);
    }

    public int getId(int index) {
        return  Integer.parseInt(stringsOfData.get(index*4+1));

    }

    public ArrayList<Integer> getNeighbor(int index) {
        ArrayList<Integer> ret = new ArrayList<>();
        String[] neighbours = stringsOfData.get(index*4+2).split(",");
        for(String s : neighbours) {
            ret.add(Integer.valueOf(s));
        }
        return ret;
    }



}
