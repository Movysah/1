/**
 * Represents a quest in the game, which can be completed by the player.
 */
public class Quest {

    private String reqItemName;
    private int reqItemAmount;
    private String giveItemName;
    private int giveItemAmount;
    private int unlockLocationId;

    /**
     * creates a new quest.
     */
    public Quest(String reqItemName, int reqItemAmount, String giveItemName, int giveItemAmount,int unlock) {
        this.reqItemName = reqItemName;
        this.reqItemAmount = reqItemAmount;
        this.giveItemName = giveItemName;
        this.giveItemAmount = giveItemAmount;
        this.unlockLocationId = unlock;
    }

    /**
     * returns the name of the required item for the quest.
     */
    public String getReqItemName() {
        return reqItemName;
    }

    /**
     * returns the amount of the required item for the quest.
     */
    public int getReqItemAmount() {
        return reqItemAmount;
    }

    /**
     * returns the name of the item the player will receive after completing the quest.
     */
    public String getGiveItemName() {
        return giveItemName;
    }

    /**
     * returns the amount of the item the player will receive after completing the quest.
     */
    public int getGiveItemAmount() {
        return giveItemAmount;
    }

    /**
     * return an id of the location this quest will unlock
     */
    public int getUnlockLocationId() {
        return unlockLocationId;
    }

    /**
     * returns a string representation of the quest.
     */
    @Override
    public String toString() {
        return "Quest: " + reqItemName + " x" + reqItemAmount + " -> " + giveItemName + " x" + giveItemAmount;
    }
}
