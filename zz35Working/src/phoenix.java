import java.util.HashMap;

public class phoenix  extends typeOfConstruction {


    private HashMap<Integer, Boolean> starGateMap = new HashMap<>();
    public phoenix(HashMap<Integer, Integer> totalmap, int newId, int initialId,
                   int constructTime, int currTime,
                   int totalMinerals, int totalGas,
                   int spendingCost, int spendingGas,
                   HashMap<Integer, Boolean> starGateMap) {
        super(totalmap, newId, initialId, constructTime, currTime, totalMinerals, totalGas);
        this.spendingCost = spendingCost;
        this.spendingGas = spendingGas;
        this.starGateMap.putAll(starGateMap);
    }

    /**
     * This method is to process the user's input.
     * @param amount the number of units need to be constructed.
     */
    public void processActionIput(String amount) {
        numberOfAction = Integer.parseInt(amount);
        if (judgementDependentBuilding()) {
            if (checkFacilityAvailable(starGateMap)) {
                if (constructionCurrencyJudgement()) {
                    deduceCurrency();
                    setComplexBuilding(starGateMap);
                    System.out.println("");
                    System.out.println("Constructing the number of new unit(s)" + numberOfAction + "...");
                } else {
                    System.out.println("Invalid: The minerals or gas is not enough.");
                }
            } else {
                System.out.println("Invalid: The Stargate has been used or not enough to build other unit.");
            }
        } else {
            System.out.println("Invalid: firstly construct the DEPENDENT building.");
        }
    }

    /**
     * make a judgement whether there exist star gate.
     * @return yes presents exist.
     */
    public boolean judgementDependentBuilding() {
        return (totalMap.containsKey(8001) && (currTime - totalMap.get(8001) >= 60));
    }

    /**
     * Process the situation of the star gate
     * @return the sta gate situation.
     */
    public HashMap<Integer, Boolean> getStarGateMap() {
        return starGateMap;
    }
}