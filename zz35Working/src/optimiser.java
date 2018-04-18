
public class optimiser extends process {
    //This is the goal at the early stage.
    static final int PROBES_GOAL = 22;
    static final int PYLON_GOAL = 1;
    static final int GATEWAY_GOAL = 1;
    static final int ASSIMIKATOR_GOAL = 2;

    //number of buildings currently.
    private int probes = 6;
    private int pylon = 0, gateWay, assimilator = 0;
    typeOfConstruction judgement;

    /**
     * provide the basic facility.
     */
    public void optimizerPrepare() {
        judgement = new typeOfConstruction();   //use the method in the model gaming.
        setIdList();
        buildBase();
        numberMaxVelocity = probes;
        totalNumberGasWorking = 0;
    }

    public void processGoal(String userInput) {
        optimizerPrepare();
        switch(userInput) {
            case ("1"):
                System.out.println("first goal.");
                generateThePossibility();
                break;

            case ("2"):
                System.out.println("second goal.");
                break;

            case ("3"):
                System.out.println("third goal.");
                break;

            case ("4"):
                System.out.println("forth goal.");
                break;

            case ("5"):
                System.out.println("fifth goal.");
                break;

                default:
                System.out.println("Enter to the game model.");
        }
    }

    /**
     * This is to print out  the five goals in the specification.
     */
    public void printGoalSelection() {
        System.out.println("--Enter the number to select your goal.");
        System.out.println("1. 1 Zealot, 4 Stalkers, 2 Immortals, and 2 Colossi.");
        System.out.println("2. 6 Zealot, 2 Stalkers, 3 Sentries, 4 Void Rays.");
        System.out.println("3. 2 Zealot, 2 Stalkers, 1 Sentry, 2 Colossi, 5.Phoenix.");
        System.out.println("4. 10 Zealots, 7 Stalkers, 2 Sentries, 3 High Templar.");
        System.out.println("5. 8 Zealots, 10 Stalkers, 2 Sentries, 1 Immortal, 1 Observer, 3 Carriers,"
                + " 2 Dark Templar.");
        System.out.println("6. Skip this part! Play by myself.");
    }
    
    public void generateThePossibility() {

        while (secondsTotal < 197) {    //if the goal is achieved, while loop stops.
            secondsTotal++;//time increase.
            probesJudgeAvailable();

            if (probesConditionJudge(PROBE, PROBES_GOAL, probes)
                    && judgeNexusAvailable(secondsTotal)) { //whether the nexus available to produce probe.
                probes++;
                setBuilding(PROBE, secondsTotal);

                totalmap.put(1001, secondsTotal);   //set the situation of Nexus.
                deduceCurrency(mineralsCostList[PROBE], gasCostList[PROBE]);
                System.out.print("Build 1 PROBE ---- ");
                printTotalTime();
            } else if (probesConditionJudge(PYLON, PYLON_GOAL, pylon)) {
                pylon++;
                setBuilding(PYLON, secondsTotal);
                deduceCurrency(mineralsCostList[PYLON], gasCostList[PYLON]);
                System.out.print("Build 1 Pylon ---- ");
                printTotalTime();
            } else if (probesConditionJudge(ASSIMILATOR, ASSIMIKATOR_GOAL, assimilator)) {
                assimilator++;
                setBuilding(ASSIMILATOR, secondsTotal);
                deduceCurrency(mineralsCostList[ASSIMILATOR], gasCostList[ASSIMILATOR]);
                System.out.print("Build 1 Assimilator --- ");
                printTotalTime();
            }

            //This is to print out the time.

            totalMinerals += mineralCalculatorGoal();
            totalGas += gasCalculatorGoal();
//            System.out.println(totalMinerals + " " +totalGas);
//            printTotalTime();
        }
        System.out.println("Your suggestion is shown above.");
    }

    /**
     * assign probe to work for minerals or gas. (full push for gathering gas.)
     */
    public void probesJudgeAvailable() {
        if (secondsTotal - totalmap.get(idList.get(PROBE)) == timeList[PROBE]) { //The probe is available.
            if (totalmap.containsKey(4001)
                    && secondsTotal - totalmap.get(4001) >= timeList[ASSIMILATOR] //assimilator has finished.
                    && totalNumberGasWorking <= assimilator * 3) { //to get the limit of the assimilator.
                System.out.print(">>> Assign three to gas working, two of them are from minerals patches.");
                numberMaxVelocity -= 2;
                totalNumberGasWorking = totalNumberGasWorking + 3;
//                System.out.println("gas working " + totalNumberGasWorking + "and " + numberMaxVelocity);
            } else {
                System.out.print("*** Assign one probe to minerals patch working, and " );
                numberMaxVelocity++;
            }
        }
    }

    /**
     * This is to put the building and units to the hash map and update the id List.
     * @param type units or building.
     * @param currentTime the time they are built.
     */
    public void setBuilding(int type, int currentTime) {
        int id = idList.get(type);
        id ++;
        idList.set(type, id);
        totalmap.put(id, currentTime);
    }

    /**
     * basic condition judgement apply to all the units and buildings.
     * @param type unit/building.
     * @param goal goal of building them.
     * @param currAmount current number of the units or buildings.
     * @return true goal not achieved and enough currency.
     */
    public boolean probesConditionJudge(int type, int goal, int currAmount) {
        return ((!achievementJudge(goal, currAmount))// goal achievement
                && (currencyJudgement(mineralsCostList[type], gasCostList[type])) //enough currency.
        );
    }

    public boolean judgeNexusAvailable(int currTime) {
        if (totalmap.get(1001) == 0) {
            return true;
        } else {
            return (currTime - totalmap.get(1001) >= 17);
        }
    }
    /**
     * deduce the minerals and gas.
     * @param spendingMiners minerals need to be spent.
     * @param spendingGas gas need to be spent.
     */
    public void deduceCurrency(int spendingMiners, int spendingGas) {
        totalMinerals = totalMinerals - spendingMiners;
        totalGas = totalGas - spendingGas;
    }

    /**
     * make a judgment whether minerals and cost are enough for building the units or buildings.
     * @param achievement The aim of building such a units or buildings.
     * @param currAmount  The current number of them user has.
     * @return true small goal has achieved.
     */
    public boolean achievementJudge(int achievement, int currAmount) {
        return (currAmount == achievement);
    }

    /**
     * whether it is enough currency to build this units or building.
     * @param mineralsCost minerals cost of the units.
     * @param gasCost gas cost of the buildings.
     * @return true presents enough.
     */
    public boolean currencyJudgement(int mineralsCost, int gasCost) {
        return (mineralsCost <= totalMinerals && gasCost <= totalGas);
    }


    //This is the calculator.
    public int mineralCalculatorGoal() {
        double minerals = (41.0 / 60.0 * numberMaxVelocity);
        int addMinerals = (int) minerals;
        return addMinerals;
    }

    public int gasCalculatorGoal() {
        double gas = (38.0 / 60.0 * totalNumberGasWorking);
        int addGas = (int) gas;
        return addGas;
    }
}
