import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class probe extends typeOfConstruction{
    private int numberOfPatchWorking;
    private final int PROBE = 1;
    private List<Integer> mineralPatchList = new ArrayList<>();

    public probe (HashMap<Integer, Integer>  totalmap, int newId, int initialId,
                  int constructTime, int currTime,
                  int totalMinerals, int totalGas,
                  List<Integer> mineralPatchList, int numberOfPatchWorking) {

        super(totalmap, newId, initialId, constructTime, currTime, totalMinerals, totalGas);

        //given the information for current mineral patch using situation.
        this.mineralPatchList.addAll(mineralPatchList);
        this.numberOfPatchWorking = numberOfPatchWorking;
    }

    /**
     * This method is to print out the action that user might select.
     */
    public void printActionSelection() {
        System.out.println(
                "Select one of the options you want probe to do: \n"
                + "a. Build new probe, "
                + "b.Assign to gather minerals c. Assign to gather gas. d. Nothing/Esc");
    }

    /**
     * This method is to process the user specific action.
     * @param actionInput the task to be assigned.
     * @param amount the number of more workers to be assigned.
     */
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

            case("b")://assign to gather minerals
                if (assignPatchJudgement()) { //not excess patches limitation.
                    if (constructingUnitJudgement()) { //enough available probes go to this work.
                        System.out.println("Assign to gather minerals...");
                        setGatherMinerals();
                        //TO DO: remove the mineral to gas.
                    } else { //not enough available.
                        System.out.println("Not enough available probes for you to this assignment. "
                                + "(building or waiting probes to be constructed firstly.)");
                    }
                } else {    //excess
                    System.out.println("Invalid: Adding too much probes to gather minerals "
                            + "(excess limitation for all the patches).");
                }
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
     * This is to judge whether the probes assigned to work excess the limitation of the patches.
     * @return true presents not excess.
     */
    public boolean assignPatchJudgement() { //there are 8 mineral patches, and up to 3 probes for each patch.
        return (numberOfAction + numberOfPatchWorking <= 24);
    }

    /**
     * This method is to judge whether there are enough available probes to be assigned to gather minerals.
     * @return true represent it is enough available.
     */
    public boolean constructingUnitJudgement() {
        return (numberOfPatchWorking + numberOfAction <= available);
    }

    /**
     * This method is to set the probes to gather the minerals.
     */
    public void setGatherMinerals() {
        //find the minimum value for the array list.
        for (int i = 0; i < numberOfAction; i++) {
            Object obj = Collections.min(mineralPatchList);
            int minimum = (int) obj;
            int position = mineralPatchList.indexOf(minimum);   //get the position of the minimum value.
            minimum ++;
            mineralPatchList.set(position, minimum);
        }
//        System.out.println(mineralPatchList);
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
     * This method is to get the Mineral Patch list.
     * @return Mineral Patch List.
     */
    public List<Integer> getMineralPatchList() {
        return mineralPatchList;
    }
}
