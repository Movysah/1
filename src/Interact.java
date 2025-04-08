import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class allows interactions between the player and NPCs.
 */
public class Interact implements Command {

    /**
     * Creates an Interact object.
     */
    public Interact() {
        createNPCs(getNPCsData());
    }

    /**
     * returns a list of NPCs that are in the same location as the player.
     */
    public String showgetNPCs() {
        String ret = "";
        for (NPC npc : NPCs) {

            if (npc.getLocationId() == playerPosition()) {
                ret += (npc + "\n");
            }
        }
        return ret;
    }

    /**
     * Reads NPC data from the file and returns it as an ArrayList of strings.
     */
    public ArrayList<String> getNPCsData() {

        ArrayList<String> ret = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("NPCFile"));
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
     * Creates NPCs from a list of strings and adds them to the NPC list.
     */
    public void createNPCs(ArrayList<String> string) {
        for (int i = 0; i < string.size(); i += 3) {
                NPC npc = new NPC(Integer.parseInt(string.get(i)), string.get(i + 1), Integer.parseInt(string.get(i + 2)));
                NPCs.add(npc);
        }
    }

    /**
     * returns the player's current location from the "PlayerInfo" file.
     */
    public int playerPosition() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("PlayerInfo"));
            int ret = Integer.parseInt(reader.readLine());
            return ret;
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

    /**
     * A list of NPCs that the player can interact with.
     */
    public ArrayList<NPC> NPCs = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    /**
     * Allows the interaction between the player and a selected NPC.
     */
    public void typeOfInteraction(NPC npc) {
        System.out.println("Would you like to (see) the quest or (complete) it?");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("see")) {
            npc.showQuests();
        } else if (input.equalsIgnoreCase("complete")) {
            npc.completeQuest();
        }
    }

    /**
     * The player chooses an NPC to interact with.
     * If an NPC is selected, the player can either view or complete quest.
     */
    @Override
    public String execute() {
        System.out.println("Choose someone/something you would like to interact with.");
        System.out.println(showgetNPCs());
        String string = scanner.nextLine();
        for (NPC npc : NPCs) {
            if (string.equalsIgnoreCase(npc.getName())) {
                typeOfInteraction(npc);
            }
        }

        return "";
    }


    @Override
    public boolean exit() {
        return false;
    }
}
