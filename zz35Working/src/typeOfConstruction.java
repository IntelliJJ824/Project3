import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class typeOfConstruction {

    protected HashMap<Integer, Integer> totalMap = new HashMap<>();
    protected int newId, initialId, constructTime, currTime, totalMinerals, totalGas, available, constructing;

    /**
     * This method is to pass the value from the situation.
     * @param totalmap the whole map for current game.
     * @param newId the newest Id for the user's selection to control.
     * @param initialId the setting id for the user's selection to control.
     * @param constructTime the required constructing time for the user's selection.
     * @param currTime the entire time for this game.
     */
    public typeOfConstruction (HashMap<Integer, Integer> totalmap, int newId, int initialId, int constructTime,
                               int currTime,
                               int totalMinerals, int totalGas) {
        totalMap.putAll(totalmap);
        this.newId = newId;
        this.initialId = initialId;
        this.constructTime = constructTime;
        this.currTime = currTime;
        this.totalMinerals = totalMinerals;
        this.totalGas = totalGas;
    }

    /**
     * This method is to print out the situation of user's selection.
     */
    public void printIndivadualSituation() {
        available = 0;
        constructing = 0;
        Set set = totalMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            int id = (int) pair.getKey();
            if (id > initialId && id < initialId + 1000) {  //find out the type of u/b user select.

                int secondBegin = (int) pair.getValue();
                if (currTime - secondBegin >= constructTime || takeoutBasicFacility(id)) {
                    //if the u/b finish constructing, including basic facility at the beginning
                    available++;
                } else {
                    constructing++;
                }
            }
        }
        System.out.print(available + " Available to be used, " + constructing + " Under constructing.\n");
    }


    /**
     * This method is to judge whether it is based facility, because time is different.
     * @param id the buildings or units
     * @return true presents it is a basic building or unit.
     */
    public boolean takeoutBasicFacility(int id) {
        return ((id > 2000 && id <= 2006) || (id == 1001));
    }


    /**
     * This method is used for testing whether the map is passed to the user.
     */
    public void printMap() {
        System.out.println(newId - initialId);
        Set set = totalMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            System.out.println("key is: " + pair.getKey());
        }
    }

    //The following code is for getter.

    /**
     * This method is to return the current hash map.
     * @return total hash map.
     */
    public HashMap<Integer, Integer> getTotalMap() {
        return totalMap;
    }

    /**
     * This method is to return the current minerals after controlling.
     */
    public int getTotalMinerals() {
        return totalMinerals;
    }
}
