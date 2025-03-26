public class Help implements Command{
    @Override
    public String execute() {
        System.out.println("Available commands :\n" +
                "move - enables to explore more of the map\n" +
                "inventory - look what interesting things you may have in your pockets\n" +
                "quests - if you forget what to do know this should help\n"+
                "interat allows you to interact with people and thing in your current location");
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
