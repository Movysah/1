import java.io.*;
import java.util.ArrayList;


public class Inventory implements Command {


    public Inventory() {
        inventory = new ArrayList();


    }


    private ArrayList<Item> inventory;

    public void changeAmountBy(Item item, int amount) {

    }

    public void changeAmountTo(int itemID, int newAmount) throws IOException {

        ArrayList<String> strings = getInventoryData("InventoryText");
        System.out.println(strings.size());
        int lineNumber = 0;

        for (int i = 0; i < strings.size(); i += 4) {
            if (strings.get(i).equals(itemID + "")) {
                lineNumber = i+3;
            }
        }
        strings.set(lineNumber, newAmount + "");

        BufferedWriter writer = new BufferedWriter(new FileWriter("InventoryText", false));

        for (String s : strings) {
            writer.write(s);
            writer.newLine();
        }
        writer.flush();

    }


    public String getInventory() {
        String ret = "";
        for (Item item : inventory) {
            ret += item.toString() + "\n";
        }
        return ret;
    }

    public ArrayList<String> getInventoryData(String filename) {

        ArrayList<String> ret = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String text;
            while ((text = reader.readLine()) != null) {

                ret.add(text);

            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ret;
    }

    private void loadInventory(ArrayList<String> stringsOfData) {
        for (int i = 0; i < stringsOfData.size(); i += 4) {
            Item item = new Item(Integer.parseInt(stringsOfData.get(i)), stringsOfData.get(i + 1), stringsOfData.get(i + 2), Integer.parseInt(stringsOfData.get(i + 3)));
            inventory.add(item);

        }
    }


    @Override
    public String execute() {
        loadInventory(getInventoryData("InventoryText"));
        System.out.println(getInventory());

        try {
            changeAmountTo(0, 3);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
