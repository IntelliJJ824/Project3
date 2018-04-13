import java.util.*;

public class zealot extends typeOfConstruction {
    HashMap<Integer, Boolean> gateMap = new HashMap<>();
    List<Integer> changeList = new ArrayList<>();

    public zealot(HashMap<Integer, Integer> totalmap, int newId, int initialId, int constructTime,
                  int currTime,
                  int totalMinerals, int totalGas,
                  int spendingCost, int spendingGas,
                  HashMap<Integer, Boolean> gateWayMap) {
        super(totalmap, newId, initialId, constructTime, currTime, totalMinerals, totalGas);
        this.spendingCost = spendingCost;
        this.spendingGas = spendingGas;
        gateMap.putAll(gateWayMap);
    }

    public void processActionInput(String amount) {
        numberOfAction = Integer.parseInt(amount);
        if (judgementDependentBuilding()) {             //dependent building exists
            if (checkGateWayAvailable()) {              // if the gateWay is available.
                if (constructionCurrencyJudgement()) {  //if currency is enough.
                    deduceCurrency();
                    setBuilding();
                    System.out.println("Constructing the number of new unit(s) " + numberOfAction + "...");
                } else {
                    System.out.println("Invalid: The minerals or gas is not enough.");
                }
            } else {
                System.out.println("Invalid: The gate way has been used or not enough to build other unit.");
            }
        } else {
            System.out.println("Invalid: firstly construct the DEPENDENT building.");
        }
    }

    /**
     * This method is to build the unit.
     * At the same time, set the gate way situation.
     */
    @Override
    public void setBuilding() {
        for (int i = 0; i < numberOfAction; i++) {
            newId ++; //this is to update the id.
            totalMap.put(newId, currTime);

            //remove the value and insert the new one.
            System.out.println(changeList.get(i));
            int position = changeList.get(i);
            gateMap.remove(position);
            gateMap.put(newId, false);
        }
    }

    /**
     * test whether there exist gate Way.
     * @return true presents exist.
     */
    public boolean judgementDependentBuilding() {
        return (totalMap.containsKey(5001) && (currTime - totalMap.get(5001) >= 65));
    }

    /**
     * This method is to check whether there is enough gate way to build the unit.
     * @return true present enough.
     */
    public boolean checkGateWayAvailable() {
        int theNumberOfTrue = 0;
        Set set = gateMap.entrySet();
        Iterator iterator = set.iterator();

        //Found out all the available gate way, and the key is stored in an array list.
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            boolean available = (boolean) pair.getValue();
            if(available) {
                theNumberOfTrue++;
                changeList.add((int)pair.getKey()); //store the id to the available list.
            }
        }

        //Make a Judgement whether there is available gate Way.
        if (theNumberOfTrue < numberOfAction) {
            return false;
        } else {
            return true;
        }
    }

    //getter method.
    /**
     * This method is to get the hash map.
     * @return the renewed hash map.
     */
    public HashMap<Integer, Boolean> getGateMap() {
        return gateMap;
    }
}
