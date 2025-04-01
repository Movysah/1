/**
 * Command to exit the game.
 */
public class Exit implements Command {

    /**
     * Exits the program.
     */
    @Override
    public String execute() {
        System.exit(0);
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
