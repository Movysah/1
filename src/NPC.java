import java.io.*;
import java.util.ArrayList;

/**
 * Represents a NPC in the game.
 * NPCs  have quests that the player can interact with.
 */
public class NPC {

    /**
     * Creates an NPC.
     */
    public NPC(int id, String name, int locationId) {
        this.quests = quests;
        this.locationId = locationId;
        this.name = name;
    }

    private String name;
    private int locationId;
    private ArrayList<Quest> quests;

    /**
     * returns the name of the NPC.
     */
    public String getName() {
        return name;
    }

    /**
     * Displays the NPC's current quest.
     */
    public void showQuests() {
        System.out.println(quests.get(0));
    }

    /**
     * Completes the NPC's quest if the player has the required items.
     */
    public boolean completeQuest() {
        String itemName = quests.get(0).getReqItemName();
        int itemAmount = quests.get(0).getReqItemAmount();
        int itemInInventory = 0;

        String giveItemName = quests.get(0).getGiveItemName();
        int giveItemInInventory = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("NPCFile"));
            String text;
            while ((text = reader.readLine()) != null) {
                if (text.equals(itemName)) {
                    itemInInventory = Integer.parseInt(reader.readLine());
                } else if (text.equals(giveItemName)) {
                    giveItemInInventory = Integer.parseInt(reader.readLine());
                }
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (itemInInventory >= itemAmount) {
            completedQuest(itemInInventory, giveItemInInventory);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Unlocks a new location based on the NPC's interaction.
     */
    public void unlockLocation(String LocationName) {
        ArrayList<String> data = getFileData("MapFile");

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).equalsIgnoreCase(LocationName)) {
                data.set(i + 3, "false");
            }
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("PlayerInfo", false));

            for (String s : data) {
                writer.write(s);
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gives reward to player after completing a quest.
     */
    public void completedQuest(int reqItemInInventory, int giveItemInInventory) {
        ArrayList<String> strings = getFileData("InventoryText");
        int lineNumber1 = 0;
        int lineNumber2 = 0;
        for (int i = 0; i < strings.size(); i += 4) {
            if (strings.get(i + 1).equals(quests.get(0).getReqItemName() + "")) {
                lineNumber1 = i + 3;
            } else if (strings.get(i + 1).equals(quests.get(0).getGiveItemName() + "")) {
                lineNumber2 = i + 3;
            }
        }
        strings.set(lineNumber1, (quests.get(0).getReqItemAmount() - reqItemInInventory) + "");
        strings.set(lineNumber2, (quests.get(0).getGiveItemAmount() + giveItemInInventory) + "");
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("PlayerInfo", false));

            for (String s : strings) {
                writer.write(s);
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (quests.size() == 1) {
            locationId = 150;
        }
        quests.remove(0);
    }

    /**
     * Reads the data from the specified file.
     */
    public ArrayList<String> getFileData(String filename) {
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

    /**
     * returns the NPC's location ID.
     */
    public int getLocationId() {
        return locationId;
    }

    /**
     * Returns the NPC's name.
     */
    @Override
    public String toString() {
        return name;
    }
}
