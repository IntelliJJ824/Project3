import java.util.HashMap;

public class gateWay extends typeOfConstruction {
    int spendingCost;
    public gateWay(HashMap<Integer, Integer> totalmap, int newId, int initialId,
                   int constructTime, int currTime,
                   int totalMinerals, int totalGas,
                   int spendingCost) {
        super(totalmap, newId, initialId, constructTime, currTime, totalMinerals, totalGas);
        this.spendingCost = spendingCost;
    }

    /**
     * This method is to process user's input for establishing gateway.
     * @param amount the total amount that user want to add.
     */
    public void processActionInput(String amount) {
        numberOfAction = Integer.parseInt(amount);

        if (judgementPylonExist()) { //exist pylon, and reach the building time.
            if (gateWayConstructionJudgement()) { //enough minerals for it.
                totalMinerals = totalMinerals - spendingCost * numberOfAction;//deduce the minerals
                setBuilding();
                System.out.println("Constructing the number of new gateway " + numberOfAction + "...");
            } else {
                System.out.println("Invalid: Minerals are not enough!!!");
            }
        } else {
            System.out.println("Invalid: firstly construct the PYLON.");
        }
    }


    /**
     * This method is to whether there is enough minerals to build this building.
     * @return true presents it is enough.
     */
    public boolean gateWayConstructionJudgement() {
        return (numberOfAction * spendingCost <= totalMinerals);
    }

    /**
     * This method is to judge whether it exists pylon, and reach the building time.
     * @return true presents exist
     */
    public boolean judgementPylonExist() {
        return (totalMap.containsKey(3001) && (currTime - totalMap.get(3001) >= 25));
    }
}
