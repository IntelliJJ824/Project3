import java.util.HashMap;

public class assimilator extends typeOfConstruction {

    public assimilator(HashMap<Integer, Integer> totalmap, int newId, int initialId,
                       int constructTime, int currTime,
                       int totalMinerals, int totalGas) {
        super(totalmap, newId, initialId, constructTime, currTime, totalMinerals, totalGas);

    }

    public void processActionInput(String amount) { // only selection for building.
        numberOfAction = Integer.parseInt(amount);
        if (assimilatorConstructionJudgement()) {
            totalMinerals = totalMinerals - 70 * numberOfAction;
            setBuilding();
            System.out.println("Constructing the number of new assimilator " + numberOfAction + "...");
        } else {
            System.out.println("Invalid construction, Minerals are not enough!!!");
        }
    }

    /**
     * This is to judge whether the total minerals are enough for constructing the assimilator.
     * @return true presents it is valid.
     */
    public boolean assimilatorConstructionJudgement() {
        return (numberOfAction * 75 <= totalMinerals);
    }
}
