import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Interact implements Command {


    public Interact() {

    }

    public String showgetNPCs() {
        String ret = "";
        for (NPC npc : NPCs) {
            if (npc.getLocationId() == playerPosition()) {
                ret += npc.toString() + "\n";
            }
        }
        return ret;
    }

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


    public void createNPCs(ArrayList<String> string){
        for (int i = 0; i < string.size(); i += 3) {
            NPC npc = new NPC(Integer.parseInt(string.get(i)), string.get(i + 1), Integer.parseInt(string.get(i + 2)));
            NPCs.add(npc);

        }
    }


    private int playerPosition() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("PlayerInfo"));
            String text;
            int ret = Integer.parseInt(reader.readLine());

            return ret;

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }


    public ArrayList<NPC> NPCs = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);



    public void typeOfInteraction(NPC npc) {
        System.out.println("would you like to (see) the quest or (complete) it ?");
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("see")){
            npc.showQuests();
        }else if(input.equalsIgnoreCase("complete")){
            npc.completeQuest();
        }
    }


    @Override
    public String execute() {
        System.out.println("choose someone/something you would like to interact with");
        showgetNPCs();
        String string = scanner.nextLine();
        for(NPC npc : NPCs){
            if(string.equalsIgnoreCase(npc.getName())){
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
