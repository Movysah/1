public class Exit implements Command {
    @Override
    public String execute() {
        System.exit(0);
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
