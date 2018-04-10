import java.util.HashMap;

public class probe extends typeOfConstruction{
    private int numberOfAction;
    private final int PROBE = 1;
    public probe (HashMap<Integer, Integer>  totalmap, int newId, int initialId,
                  int constructTime, int currTime,
                  int totalMinerals, int totalGas) {
        super(totalmap, newId, initialId, constructTime, currTime, totalMinerals, totalGas);
    }

    /**
     * This method is to print out the action that user might select.
     */
    public void printActionSelection() {
        System.out.println("Select one of the options you want probe to do: \n"
                + "a. Build new probe, "
                + "b.Assign to gather minerals c. Assign to gather gas. d. Nothing/Esc");
    }

    public void processActionInput(String actionInput, String amount) {
        numberOfAction = Integer.parseInt(amount);

        switch (actionInput.toLowerCase()) {
            case("a"):
                if (constructionJudgement()) {
                    totalMinerals = totalMinerals - 50 * numberOfAction;
                    System.out.println("Constructing the number of new probe " + numberOfAction + "...");
                    setProbes();
                } else {
                    System.out.println("Invalid construction, Minerals are not enough!!!");
                }
                break;
            case("b"):
                System.out.println("gather minerals");
                break;
            case("c"):
                System.out.println("gather gas");
                break;
            default:
                break;
        }
    }

    /**
     * This method  is to judge whether the total minerals are enough for constructing the probes
     * @return true presents it is valid construction.
     */
    public boolean constructionJudgement() {
        return (numberOfAction * 50 <= totalMinerals);
    }

    /**
     * This method is to add the new building probes to the hash map.
     */
    public void setProbes() {
        for (int i = 0; i < numberOfAction; i++) {
            newId ++;
            totalMap.put(newId, currTime);
        }
    }

    /**
     * This method is to get the newest Id for probes.
     * @return the current newest Id after the building order.
     */
    public int getNewId() {
        return newId;
    }
}
