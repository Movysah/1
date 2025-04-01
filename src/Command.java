/**
 * Interface for all commands in the game.
 */
public interface Command {

    /**
     * Executes the command.
     */
    String execute();

    /**
     * decides if the command should terminate the game.
     */
    boolean exit();
}
