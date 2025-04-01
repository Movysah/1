import java.util.HashMap;
import java.util.Scanner;

/**
 * Takes care of  user's input and executes commands entered in the console.
 */
public class Console {

    private HashMap<String, Command> commands;
    private Scanner scanner;

    /**
     * Initializes the console and commands.
     */
    public void initialize() {
        scanner = new Scanner(System.in);
        commands = new HashMap<>();

        commands.put("move", new Move());
        commands.put("inventory", new Inventory());
        commands.put("help", new Help());
        commands.put("interact", new Interact());
        commands.put("exit", new Exit());
    }

    /**
     * Executes the entered command.
     * Displays an error message if the command is not found.
     */
    public void executeCommand() {
        System.out.print("//");
        String command = scanner.nextLine();
        command = command.toLowerCase();
        command = command.replace(" ", "");
        if (commands.containsKey(command)) {
            commands.get(command).execute();
        } else {
            System.out.println("404 Not Found");
        }
    }
}
