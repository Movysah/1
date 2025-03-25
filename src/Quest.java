public class Quest {

    public Quest(String questText, String reqItemName, int reqItemAmount, String giveItemName, int giveItemAmount) {
        this.questText = questText;
        this.reqItemName = reqItemName;
        this.reqItemAmount = reqItemAmount;
        this.giveItemName = giveItemName;
        this.giveItemAmount = giveItemAmount;
    }

    private String questText;
    private String reqItemName;
    private int reqItemAmount;
    private String giveItemName;
    private int giveItemAmount;


    @Override
    public String toString() {
        return questText + "\n" +
                reqItemAmount + "x " + reqItemName + " -> " + giveItemAmount + "x " + questText;
    }

    public String getQuestText() {
        return questText;
    }

    public String getReqItemName() {
        return reqItemName;
    }

    public int getReqItemAmount() {
        return reqItemAmount;
    }

    public String getGiveItemName() {
        return giveItemName;
    }

    public int getGiveItemAmount() {
        return giveItemAmount;
    }
}
