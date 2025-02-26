import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MapReader {


    public MapReader() {

        stringsOfData = new ArrayList<>();
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
    //    } catch (FileNotFoundException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ret;
    }


}
