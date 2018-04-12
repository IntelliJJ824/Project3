import java.util.HashMap;

public class assimilator extends typeOfConstruction {
    //This is the spending cost for assimilator or pylon.
    int spendingCost;
    public assimilator(HashMap<Integer, Integer> totalmap, int newId, int initialId,
                       int constructTime, int currTime,
                       int totalMinerals, int totalGas,
                       int spendingCost) {
        super(totalmap, newId, initialId, constructTime, currTime, totalMinerals, totalGas);
        this.spendingCost = spendingCost;
    }

    /**
     * This method is to set the assimilator for the program.
     * @param amount the number of assimilator or pylon need to be added.
     */
    public void processActionInput(String amount) { // only selection for building.
        numberOfAction = Integer.parseInt(amount);
        if (assimilatorConstructionJudgement()) {
            totalMinerals = totalMinerals - spendingCost * numberOfAction;
            setBuilding();
            System.out.println("Constructing the number of new building " + numberOfAction + "...");
        } else {
            System.out.println("Invalid construction, Minerals are not enough!!!");
        }
    }

    /**
     * This is to judge whether the total minerals are enough for constructing the assimilator.
     * @return true presents it is valid.
     */
    public boolean assimilatorConstructionJudgement() {
        return (numberOfAction * spendingCost <= totalMinerals);
    }
}
