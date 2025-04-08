/**
 * Command to display the help menu with available commands.
 */
public class Help implements Command {

    /**
     * Displays available commands to the user.
     */
    @Override
    public String execute() {
        System.out.println("Available commands :\n" +
                "move - enables to explore more of the map\n" +
                "inventory - look what interesting things you may have in your pockets\n" +
                "interact - allows you to interact with people and things in your current location\n" +
                "exit - exits the program");
        return "";
    }

    /**
     * Returns if the command is an exit command.
     */
    @Override
    public boolean exit() {
        return false;
    }
}
