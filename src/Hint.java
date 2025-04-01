/**
 * A command that provides hints.
 */
public class Hint implements Command {

    /**
     * Executes the hint command, providing additional information or hints.
     */
    @Override
    public String execute() {
        return "";
    }


    @Override
    public boolean exit() {
        return false;
    }
}
