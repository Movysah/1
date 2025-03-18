public class Item {

    private String name;

    private String description;

    private int amount;

    private int id;


    public Item(int id,String itemName, String itemDescription, int amount) {
        this.id = id;
        name = itemName;
        description = itemDescription;
        this.amount = amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        if(amount > 0) {
            return name + " x" + amount + "\n   " + description;
        }
        return "";
    }
}
