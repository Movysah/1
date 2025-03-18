public class Help implements Command{
    @Override
    public String execute() {
        System.out.println("Dostupné commandy :" +
                "move - enables to explore more of the map" +
                "inventory - look what interesting things you may have in your pockets" +
                "quests - if you forget what to do know this should help");
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
