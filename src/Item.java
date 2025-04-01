/**
 * Represents an item in the game.
 */
public class Item {

    private String name;
    private String description;
    private int amount;
    private int id;

    /**
     * Creates an item.
     */
    public Item(int id, String itemName, String itemDescription, int amount) {
        this.id = id;
        name = itemName;
        description = itemDescription;
        this.amount = amount;
    }


    /**
     * Returns the name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the description of the item.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns a string representing the item name, description and amount of the item in inventory.
     */
    @Override
    public String toString() {
        if (amount > 0) {
            return name + " x" + amount + "\n   " + description;
        }
        return "";
    }
}
