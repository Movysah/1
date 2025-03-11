import java.util.HashMap;
import java.util.Scanner;

public class Console {


    private HashMap<String, Command> commands;


    public void initialize() {
        scanner = new Scanner(System.in);
        commands= new HashMap<>();

        commands.put("move", new Move());



    }


    private Scanner scanner;


    public void executeCommand() {
        String command = scanner.nextLine();
        command = command.toLowerCase();
        command = command.replace(" ", "");
        if(commands.containsKey(command)) {
            commands.get(command).execute();
        }else {
            System.out.println("404 Not Found");
        }
    }









}

