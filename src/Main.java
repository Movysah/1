public class Main {
    public static void main(String[] args) {

        Player player = new Player(4, "text");
        System.out.println(player.getCurrentLocation());
        System.out.println(player.travelTo("mafie"));
        System.out.println(player.travelTo("namesti"));
        System.out.println(player.getCurrentLocation());


    }
}