import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MapReader {


    public MapReader() {

        stringsOfData = new ArrayList<>();
        stringsOfData = getfiletext();
    }


    public ArrayList<String> stringsOfData;


    public ArrayList<String> getfiletext() {

        ArrayList<String> ret = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Text"));
            String text = "";
            while ((text = reader.readLine()) != null) {
                ret.add(text);

            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ret;
    }

    public int getNumOfLoc(){
        return stringsOfData.size();
    }

    public String getName(int index) {
        return stringsOfData.get(index*3+1);
    }

    public int getId(int index) {
        char ch = stringsOfData.get(index*3+2).charAt(0);
        return Integer.parseInt(String.valueOf(ch));
    }




}
