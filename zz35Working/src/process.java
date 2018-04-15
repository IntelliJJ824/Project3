import java.io.InputStreamReader;
import java.util.*;

/**
 * Design: instead of using the real name of every units or building,
 * in this program, an id which is began with 1000 is given.
 * The id is increased with every 1000 values.
 * The initial list is to compare with the idList in order to find out the number of units and buildings.
 * hash map is to store the key for id, and value for time, which is individual list.
 * The id list is the type list.
 */
public class process {
    private Timer totalTimer;
    private int secondsTotal = 0;
    private final int PERIOD = 1000;
    private int totalMinerals;
    private int totalGas;

    //The speed of gathering minerals.
    private int numberMaxVelocity, numberMinVelocity, totalNumberPatchWorking;

    //The speed of gathering gas.
    private int totalNumberGasWorking;


    //This is buildings.
    static final int NEXUS = 0;
    static final int PROBE = 1;
    static final int PYLON = 2;
    static final int ASSIMILATOR = 3;
    static final int GATEWAY = 4;
    static final int CYBERNETIC = 5;
    static final int ROBOTIC = 6;
    static final int STARGATE = 7;
    //This is unit.
    static final int ZEALOT = 8;
    static final int STALKER = 9;
    static final int SENTRY = 10;
    static final int OBSERVER = 11;
    static final int IMMORTAL = 12;
    static final int PHOENIX = 13;
    static final int VOID_RAY = 14;

    //This is for Mineral patch.
    static final int mineralPatch1 = 0;
    static final int mineralPatch2 = 1;
    static final int mineralPatch3 = 2;
    static final int mineralPatch4 = 3;
    static final int mineralpatch5 = 4;

    //this is to store the type of the unit, and its newest ID.
    private ArrayList<Integer> idList = new ArrayList<>();
    private ArrayList<Integer> initialList = new ArrayList<>();

    // this is to store all the units and building.
    private HashMap<Integer, Integer> totalmap = new HashMap<>();

    //total gate way with the situation.
    private HashMap<Integer, Boolean> gateWayMap = new HashMap<>();

    //total robotics facility with the situation.
    private HashMap<Integer, Boolean> roboticsMap = new HashMap<>();

    //total stargate facility with the situation.
    private HashMap<Integer, Boolean> starGateMap = new HashMap<>();

    //total nexus facility with the situation.
    private HashMap<Integer, Boolean> nexusMap = new HashMap<>();


    //This is the list to convert from number to specific name.
    private String[] convertList = {
            "NEXUS", "PROBE", "PYLON", "ASSIMILATOR", "GATEWAY", "CYBERNETICS CORE", "ROBOTICS FACILITY", "STARGATE",
            "ZEALOT", "STALKER", "SENTRY", "OBSERVER", "IMMORTAL", "PHOENIX", "VOID RAY"};

    private int[] timeList = {
            100, 17, 25, 30, 65, 50, 65, 60, //This is for buildings and probe.
            38, 42, 37, 40, 55, 35, 60 //This is for units
    };

    private int[] gasCostList = {
            0, 0, 0, 0, 0, 0, 100, 150, //This is for building and probe.
            0, 50, 100, 75, 100, 100, 150
    };

    //This is the list of mineral patch, 0 presents there is no probe working for it.
    private List<Integer> mineralPatchList = Arrays.asList(0, 0, 0, 0, 0);
    //This is the list of gas, 0 presents there is no probe working for it.
    private List<Integer> gasList = Arrays.asList(0);


    /**
     * This constructor is to start the game.
     */
    public process() {
        totalTimer = new Timer();
        start();
    }


    /**
     * This is the beginner of this game, and this method is to start the timer as well as the basic facilities.
     */
    public void start() {
        setIdList();
        buildBase();
        assignMineralBeginning();
        totalTimer.schedule(totalTimeCalculation, new Date(), PERIOD);
        totalTimer.schedule(addMinerals, 1000, PERIOD); //The mineral calculation begins after 1 second.
        totalTimer.schedule(addGas, 1000, PERIOD);
    }

    /**
     * This method is to declare all units and buildings with their id.
     */
    public void setIdList() {
        int id = 1000;
        for (int i = 0; i < 15; i++) {
            idList.add(id);
            initialList.add(id);
            id += 1000;
        }
    }

    /**
     * This method is to build the basic army for requirement 6 probes and 1 nexus.
     */
    public void buildBase() {
        //This is to set the six probes at the beginning.
        for (int i = 0; i < 6; i++) {
            int probeNo = idList.get(PROBE) + 1;
            idList.set(PROBE, probeNo);
            totalmap.put(idList.get(PROBE), secondsTotal);
        }

        //This is to set the nexus.
        int nexusNo = idList.get(NEXUS) + 1;
        idList.set(NEXUS, nexusNo);
        nexusMap.put(nexusNo, true); //set the nexus list at the beginning.
        totalmap.put(idList.get(NEXUS), secondsTotal);

        //This is to set the minerals and gas.
        totalMinerals = 50;
        totalGas = 0;
    }

    //printer and timing calculation.
    /**
     * this method is to calculate the total time in seconds.
     */
    TimerTask totalTimeCalculation = new TimerTask() {
        @Override
        public void run() {
            secondsTotal++;
        }
    };

    /**
     * This method is to print out the current situation.
     */
    public void printSituation() {
        System.out.println("Minerals are: " + totalMinerals + " Vespene gas is: " + totalGas);
        String situation = "";
        for (int i = 0; i < idList.size(); i++) {
            int amount = idList.get(i) - initialList.get(i);
            if (amount > 0) {
                int character = initialList.get(i) / 1000 - 1;//This is to get the units/buildings in the array.
                situation = situation + amount + " " + convertList[character] + " ";
            }
        }
        System.out.println(situation);
    }

    /**
     * This is the method to assign probes working for minerals automatically.
     * The first mineral patch is assigned 2.
     * The rest of them are assigned 1 probe.
     */
    public void assignMineralBeginning() {
        mineralPatchList.set(mineralPatch1, 1);

        for (int i = 0; i < mineralPatchList.size(); i++) {
            int numberWorking = mineralPatchList.get(i) + 1;
            mineralPatchList.set(i, numberWorking);
        }

        MineralCalculator();
    }

    /**
     * This is to print out the minerals and gas.
     */
    public void printCurrency() {
        System.out.println("**** Minerals are: " + totalMinerals + " Vespene gas is: " + totalGas +" ****");
    }

    /**
     * This is to calculate the number of maximum speed of gathering and also on the otherwise.
     */
    public void MineralCalculator() {
        //reset all the value and calculate again.
        numberMaxVelocity = 0;
        numberMinVelocity = 0;
        totalNumberPatchWorking = 0;

        for (int i = 0; i < mineralPatchList.size(); i++) {
            int numberOfProbes =  mineralPatchList.get(i);
            if (numberOfProbes > 0 && numberOfProbes < 3) {     //first two probes to a mineral patch
                numberMaxVelocity = numberMaxVelocity + numberOfProbes;
            }
            if (numberOfProbes == 3) {      //The third probe to one mineral patch.
                numberMinVelocity++;
            }
        }
        //work out the total patch situation.
        totalNumberPatchWorking = numberMinVelocity + numberMaxVelocity;
    }

    /**
     * This method is to calculate total minerals need to be added every time.
     */
    TimerTask addMinerals = new TimerTask() {
        @Override
        public void run() {
            double minerals = (41.0 / 60.0 * numberMaxVelocity) + (20.0 / 60.0 * numberMinVelocity);
            int addMinerals = (int) minerals;
            totalMinerals = totalMinerals + addMinerals;

        }
    };

    /**
     * This method is to calculate the number of probes working for gathering gas.
     */
    public void gasCalculator() {
        totalNumberGasWorking = 0;

        for(int element : gasList) {
            totalNumberGasWorking += element;
        }
    }

    /**
     * This method is to calculate total gas to be added every second.
     */
    TimerTask addGas = new TimerTask() {
        @Override
        public void run() {
            double gas = (38.0 / 60.0 * totalNumberGasWorking);
            int addGas = (int) Math.round(gas);
            totalGas = totalGas + addGas;
        }
    };

    /**
     * This method is to find the free probes.
     * @return the number of free probes.
     */
    public int findNothingTaskProbes() {
        int id = initialList.get(PROBE) + 1;
        int freeProbes = 6;
        for (int i = initialList.get(PROBE) + 7; i <= idList.get(PROBE); i++) {//total times = total number of probes
                int value = totalmap.get(id);
                if (secondsTotal - value >= timeList[PROBE]) {
                    freeProbes++;
                }
        }
        freeProbes = freeProbes - totalNumberGasWorking - totalNumberPatchWorking;
        return freeProbes;
    }

    public void setUserInput(String input) {
        Scanner reader = new Scanner(new InputStreamReader(System.in)); //This is to scan user's action input.
        printCurrency();
        switch (input.toLowerCase()) {
            case("a"):
                updateNexusMap();
                System.out.println(nexusMap);
                System.out.println(convertList[NEXUS] + ": ");
                assimilator nexusSelection = new assimilator(
                  totalmap, idList.get(NEXUS), initialList.get(NEXUS),
                  timeList[NEXUS], secondsTotal,
                        totalMinerals, totalGas,
                        400);
                nexusSelection.printIndivadualSituation();
                nexusSelection.printGeneralSelection();
                String actionNex = reader.next();

                if (actionNex.toLowerCase().equals("a")) {
                    System.out.println("How many Nexus do you want to add?");
                    String amount = reader.next();
                    nexusSelection.processActionInput(amount);
                    int times = nexusSelection.getNewId() - idList.get(NEXUS);

                    if (times > 0) { //get update if the new Nexus is added.
                        //update nexus map.
                        setTotalFacilityUnavailable(times, idList.get(NEXUS), nexusMap);
                        //update the hash map.
                        totalmap.putAll(nexusSelection.getTotalMap());
                        //get new id.
                        idList.set(NEXUS, nexusSelection.getNewId());
                        //get current minerals.
                        totalMinerals = nexusSelection.getTotalMinerals();
                    }

                }
                break;

            case("b"):
                updateNexusMap();
                probe probeSelection = new probe(totalmap, idList.get(PROBE), initialList.get(PROBE),
                        timeList[PROBE], secondsTotal,
                        totalMinerals, totalGas,
                        mineralPatchList, totalNumberPatchWorking,
                        gasList, totalNumberGasWorking,
                        nexusMap);
                //print out the situation.
                System.out.print(convertList[PROBE] + ": ");
                probeSelection.printIndivadualSituation();
                //print out the minerals patch and gas working situation.
                System.out.println("--There are " + totalNumberPatchWorking + " probes gathering minerals, "
                        + totalNumberGasWorking + " gathering gas. "
                        + findNothingTaskProbes() + " nothing to do.");

                //try to prompt user input the action for his selection.
                probeSelection.printActionSelection();
                String actionInput = reader.next();

                //try to find out the amount of this action.
                if (!actionInput.equals("d")) {
                    System.out.println("How many probe(s) do you want to add to take this action?");
                    String amount = reader.next();
                    //process the user input.
                    probeSelection.processActionInput(actionInput, amount);
                }

                int timesPro = probeSelection.getNewId() - idList.get(PROBE);
                if (timesPro > 0) {
                    updateHashMapTotalAfterUnit(probeSelection.getNexusMap(), nexusMap);
                    //get new Id
                    idList.set(PROBE, probeSelection.getNewId());
                    //get new map
                    totalmap.putAll(probeSelection.getTotalMap());
                    //get new currentMinerals
                    totalMinerals = probeSelection.getTotalMinerals();
                }

                    //get new minerals patch list
                    renewPatchList(probeSelection.getMineralPatchList());
                    MineralCalculator();
                    //get new gas patch list
                    renewGasList(probeSelection.getGasList());
                    gasCalculator();

                break;

            //The following codes are for pylon.
            case("c"):
                System.out.print(convertList[PYLON] + ": ");
                assimilator pylonSelection = new assimilator(
                        totalmap, idList.get(PYLON), initialList.get(PYLON),
                        timeList[PYLON], secondsTotal,
                        totalMinerals, totalGas,
                        100);
                pylonSelection.printIndivadualSituation();
                pylonSelection.printGeneralSelection();
                String actionInputPy = reader.next();

                if(actionInputPy.toLowerCase().equals("a")) {
                    System.out.println("How many pylon(s) do you want to construct?");
                    String amount = reader.next();
                    pylonSelection.processActionInput(amount);
                    //update the hash map.
                    totalmap.putAll(pylonSelection.getTotalMap());
                    //get new id.
                    idList.set(PYLON, pylonSelection.getNewId());
                    //get current minerals.
                    totalMinerals = pylonSelection.getTotalMinerals();
                }
                break;

            //The following are for assimilator.
            case("d"):
                System.out.print(convertList[ASSIMILATOR] + ": ");
                assimilator assimilatorSelection = new assimilator(
                        totalmap, idList.get(ASSIMILATOR), initialList.get(ASSIMILATOR),
                        timeList[ASSIMILATOR], secondsTotal,
                        totalMinerals, totalGas,
                        75);
                assimilatorSelection.printIndivadualSituation();
                assimilatorSelection.printGeneralSelection();//print the option for it.
                String actionInputAs = reader.next();

                if (actionInputAs.toLowerCase().equals("a")) { //construct begins with here.
                    System.out.println("How many assimilator(s) do you want to be constructed?");
                    String amount = reader.next();
                    assimilatorSelection.processActionInput(amount);

                    //update the hash map.
                    totalmap.putAll(assimilatorSelection.getTotalMap());
                    //get new id.
                    int newestId = assimilatorSelection.getNewId();
                    if (newestId == 4002) { //if the second gas assimilator is created
                        gasList.add(0);
                    }
                    idList.set(ASSIMILATOR, newestId);
                    //get current minerals.
                    totalMinerals = assimilatorSelection.getTotalMinerals();
                }
                break;

            //This is began with GATEWAY type.
            case("e"):
                updateGateWayMap(); //checking the available gateway.
                System.out.println(gateWayMap);     //printing method in here.

                System.out.println(convertList[GATEWAY] + ": ");
                gateWay gateWaySelection = new gateWay(
                        totalmap, idList.get(GATEWAY), initialList.get(GATEWAY),
                        timeList[GATEWAY], secondsTotal,
                        totalMinerals, totalGas,
                        150 //spending  cost is the minerals that need to be deduced for each.
                );
                gateWaySelection.printIndivadualSituation();
                gateWaySelection.printGeneralSelection();
                String actionInputGAT = reader.next();

                if (actionInputGAT.toLowerCase().equals("a")) {
                    //process user input.
                    System.out.println("How many gateway(s) do you want to construct?");
                    String amount = reader.next();
                    gateWaySelection.processActionInput(amount);

                    //get the new map.
                    totalmap.putAll(gateWaySelection.getTotalMap());
                    // get the new id.
                    int newestId = gateWaySelection.getNewId();

                    //the map of the gate way will be added, if the new gate way is add.
                    int times = newestId - idList.get(GATEWAY);
                    if (times > 0) {
                        //set the situation for the gate way.
                        setTotalFacilityUnavailable(times, idList.get(GATEWAY), gateWayMap);

                        //set the newId for gate way.
                        idList.set(GATEWAY, newestId);

                        //This is to get the minerals.
                        totalMinerals = gateWaySelection.getTotalMinerals();
                    }

                }
                break;

            case("f"):      //This is for cybernetics core.
                System.out.println(convertList[CYBERNETIC] + ": ");
                cybernetics cyberneticsSelection = new cybernetics(
                  totalmap, idList.get(CYBERNETIC), initialList.get(CYBERNETIC),
                  timeList[CYBERNETIC], secondsTotal,
                  totalMinerals, totalGas,
                  150);
                cyberneticsSelection.printIndivadualSituation();
                cyberneticsSelection.printGeneralSelection();
                String actionInputCYB = reader.next();

                //process the user's input
                if (actionInputCYB.toLowerCase().equals("a")) {
                    System.out.println("How many Cybernetics Core do you want to construct?");
                    String amount = reader.next();
                    cyberneticsSelection.processActionInput(amount);

                    //get the new map.
                    totalmap.putAll(cyberneticsSelection.getTotalMap());

                    //get the new id.
                    int newestId = cyberneticsSelection.getNewId();
                    idList.set(CYBERNETIC, newestId);

                    //This is to get the total minerals (after deducing).
                    totalMinerals = cyberneticsSelection.getTotalMinerals();
                /**
                 * cyberneticsSelection.printMap(); before this part, testing is success,
                 * because deduce minerals, time, and building condition.
                 */
                }
                break;
            /**
             * The reason why ROBOTIC and STARGate share the same class.
             * because they have the same conditional except the spending of minerals and gas.
             */
            case("g"):
                System.out.println(convertList[ROBOTIC] + ": ");
                roboticsFac roboticsSelection = new roboticsFac(
                        totalmap, idList.get(ROBOTIC), initialList.get(ROBOTIC),
                        timeList[ROBOTIC], secondsTotal,
                        totalMinerals, totalGas,
                        200, gasCostList[ROBOTIC]);
                roboticsSelection.printIndivadualSituation();
                roboticsSelection.printGeneralSelection();
                String actionInputRob = reader.next();

                //process the user's input.
                if (actionInputRob.toLowerCase().equals("a")) {
                    System.out.println("How many Robotics Facility do you want to construct?");
                    String amount = reader.next();
                    roboticsSelection.processActionInput(amount);

                    //get the new map.
                    totalmap.putAll(roboticsSelection.getTotalMap());

                    //get the new id.
                    int newestId = roboticsSelection.getNewId();
                    if (newestId - idList.get(ROBOTIC) > 0) {
                        int times = newestId - idList.get(ROBOTIC);
                        //set the situation of the robotic facility.
                        setTotalFacilityUnavailable(times, idList.get(ROBOTIC), roboticsMap);
                        //set the new id.
                        idList.set(ROBOTIC, newestId);
                        //deduce the minerals.
                        totalMinerals = roboticsSelection.getTotalMinerals();
                        //deduce the gas.
                        totalGas = roboticsSelection.getTotalGas();
                    }
                }
                break;

            case("h"):
                System.out.println(convertList[STARGATE] + ": ");
                roboticsFac starGateSelection = new roboticsFac(
                        totalmap, idList.get(STARGATE), initialList.get(STARGATE),
                        timeList[STARGATE], secondsTotal,
                        totalMinerals, totalGas,
                        150, gasCostList[STARGATE]);
                starGateSelection.printIndivadualSituation();
                starGateSelection.printGeneralSelection();
                String actionInputSTA = reader.next();

                //process the user's input.
                if (actionInputSTA.toLowerCase().equals("a")) {
                    System.out.println("How many Stargate do you want to construct?");
                    String amount = reader.next();
                    starGateSelection.processActionInput(amount);

                    //get map
                    totalmap.putAll(starGateSelection.getTotalMap());
                    //get id
                    int newestId = starGateSelection.getNewId();
                    if (newestId - idList.get(STARGATE) > 0) {
                        int times = newestId - idList.get(STARGATE);
                        //set the situation of the star gate.
                        setTotalFacilityUnavailable(times, idList.get(STARGATE), starGateMap);
                        System.out.print("");
                        //set the new id.
                        idList.set(STARGATE, newestId);
                        //deduce the minerals.
                        totalMinerals = starGateSelection.getTotalMinerals();
                        //deduce the gas.
                        totalGas = starGateSelection.getTotalGas();
                    }
                }
                break;

            case("i"):
                updateGateWayMap();
                System.out.println(convertList[ZEALOT] + ": ");
                zealot zealotSelection = new zealot(
                     totalmap, idList.get(ZEALOT), initialList.get(ZEALOT),
                     timeList[ZEALOT], secondsTotal,
                     totalMinerals, totalGas,
                     100, gasCostList[ZEALOT],
                        gateWayMap);

                printIndividual(zealotSelection);
                String actionInputZE = reader.next();

                //process the user's input.
                if (actionInputZE.toLowerCase().equals("a")) {
                    System.out.println("How many Zealot(s) do you want to construct?");
                    String amount = reader.next();
                    zealotSelection.processActionInput(amount);

                    //get map.
                    totalmap.putAll(zealotSelection.getTotalMap());

                    //get gateWayMap.
                    updateHashMapTotalAfterUnit(zealotSelection.getGateMap(), gateWayMap);

                    //get id, deduce the minerals and gas.
                    updateTheList(ZEALOT, zealotSelection);
                }
                break;

            case ("j"):
                updateGateWayMap();
                System.out.println(convertList[STALKER] + ": ");
                stalker stalkerSelection = new stalker(
                        totalmap, idList.get(STALKER), initialList.get(STALKER),
                        timeList[STALKER], secondsTotal,
                        totalMinerals, totalGas,
                        125, gasCostList[STALKER],
                        gateWayMap);

                printIndividual(stalkerSelection);
                String actionInputSTAL = reader.next();

                //process the user's input.
                if (actionInputSTAL.toLowerCase().equals("a")) {
                    System.out.println("How many Stalker(s) do you want to construct?");
                    String amount = reader.next();
                    stalkerSelection.processActionInput(amount);

                    //get map.
                    totalmap.putAll(stalkerSelection.getTotalMap());

                    //get gateWay Map.
                    updateHashMapTotalAfterUnit(stalkerSelection.getGateMap(), gateWayMap);

                    //get id, deduce the minerals and gas.
                    updateTheList(STALKER, stalkerSelection);
                }
                break;

            case ("k"):
                updateGateWayMap();
                System.out.println(convertList[SENTRY] + ": ");
                zealot sentrySelection = new zealot(
                  totalmap, idList.get(SENTRY), initialList.get(SENTRY),
                  timeList[SENTRY], secondsTotal,
                  totalMinerals, totalGas,
                  50, gasCostList[SENTRY],
                  gateWayMap
                );

                printIndividual(sentrySelection);
                String actionSEN = reader.next();

                //process the user's input.
                if (actionSEN.toLowerCase().equals("a")) {
                    System.out.println("How many SENTRY do you want to construct?");
                    String amount = reader.next();
                    sentrySelection.processActionInput(amount);

                    //get map.
                    totalmap.putAll(sentrySelection.getTotalMap());
                    //get gateWay map.
                    updateHashMapTotalAfterUnit(sentrySelection.getGateMap(), gateWayMap);
                    //get id, deduce the minerals and gas.
                    updateTheList(SENTRY, sentrySelection);
                }
                break;
            /**
             * zealot, stalker, and sentry can be regarded as a type of unit.
             * because they are produced by the same building.
             */

            case ("l"):
                updateRoboticsMap();
                System.out.println(convertList[OBSERVER] + ": ");
                observe observeSelection = new observe(
                       totalmap, idList.get(OBSERVER), initialList.get(OBSERVER),
                       timeList[OBSERVER], secondsTotal,
                       totalMinerals, totalGas,
                       25, gasCostList[OBSERVER],
                        roboticsMap);

                printIndividual(observeSelection);
                String actionOBS = reader.next();

                //process the user's input.
                if (actionOBS.toLowerCase().equals("a")) {
                    System.out.println("How many Observer(s) do you want to construct?");
                    String amount = reader.next();
                    observeSelection.processActionInput(amount);

                    //get map.
                    totalmap.putAll(observeSelection.getTotalMap());
                    //get robotics map.
                    updateHashMapTotalAfterUnit(observeSelection.getRoboticsMap(), roboticsMap);
                    //get id, deduce the minerals and gas.
                    updateTheList(OBSERVER, observeSelection);
                }
                break;
            case ("m"):
                updateRoboticsMap();
                System.out.println(convertList[IMMORTAL] + ": ");
                observe immortalSelection = new observe(
                        totalmap, idList.get(IMMORTAL), initialList.get(IMMORTAL),
                        timeList[IMMORTAL], secondsTotal,
                        totalMinerals, totalGas,
                        250, gasCostList[IMMORTAL],
                        roboticsMap);

                printIndividual(immortalSelection);
                String actionIMM = reader.next();

                //process the user's input.
                if (actionIMM.toLowerCase().equals("a")) {
                    System.out.println("How many Immortal(s) do you want to construct?");
                    String amount = reader.next();
                    immortalSelection.processActionInput(amount);

                    //get map.
                    totalmap.putAll(immortalSelection.getTotalMap());
                    //get robotics map.
                    updateHashMapTotalAfterUnit(immortalSelection.getRoboticsMap(), roboticsMap);
                    //get id, deduce the minerals and gas.
                    updateTheList(IMMORTAL, immortalSelection);
                }
                break;
            /**
             * Immortal and Observer share similar situation, because they are built from the same building.
             */
            case ("n"):
                updateStarGateMap();
                System.out.println(convertList[PHOENIX] + ": ");
                phoenix phoenixSelection = new phoenix(
                        totalmap, idList.get(PHOENIX), initialList.get(PHOENIX),
                        timeList[PHOENIX], secondsTotal,
                        totalMinerals, totalGas,
                        150, gasCostList[PHOENIX],
                        starGateMap
                );

                printIndividual(phoenixSelection);
                String actionPho = reader.next();

                if (actionPho.toLowerCase().equals("a")) {
                    System.out.println("How many PHOENIX do you want to construct?");
                    String amount = reader.next();
                    phoenixSelection.processActionIput(amount);

                    //get map.
                    totalmap.putAll(phoenixSelection.getTotalMap());
                    //get stargate map.
                    updateHashMapTotalAfterUnit(phoenixSelection.getStarGateMap(), starGateMap);
                    //get id, deduce the minerals and gas.
                    updateTheList(PHOENIX, phoenixSelection);
                }
                break;
            case ("o"):
                updateStarGateMap();
                System.out.println(convertList[VOID_RAY] + ": ");
                phoenix raySelection = new phoenix(
                        totalmap, idList.get(VOID_RAY), initialList.get(VOID_RAY),
                        timeList[VOID_RAY], secondsTotal,
                        totalMinerals, totalGas,
                        250, gasCostList[VOID_RAY],
                        starGateMap
                );

                printIndividual(raySelection);
                String actionRAY = reader.next();

                if (actionRAY.toLowerCase().equals("a")) {
                    System.out.println("How many VOID RAY do you want to construct?");
                    String amount = reader.next();
                    raySelection.processActionIput(amount);

                    //get map.
                    totalmap.putAll(raySelection.getTotalMap());
                    //get stargate map.
                    updateHashMapTotalAfterUnit(raySelection.getStarGateMap(), starGateMap);
                    //get id, deduce the minerals and gas.
                    updateTheList(VOID_RAY, raySelection);
                }
                break;
            case("quit"):
                System.out.println("Game Over!!!");
                break;
            default:
                System.out.println("Invalid Selection!");
                break;
        }
    }

    //general method begins with here.
    /**
     * This method is to renew the facility hash map in order to get the situation of it.(print)
     * @param newHashMap the facility hash map after processing.
     * @param oldHashMap the facility hash map need to be updated.
     */
    public void updateHashMapTotalAfterUnit(HashMap<Integer, Boolean> newHashMap,
                                            HashMap<Integer, Boolean> oldHashMap) {
       oldHashMap.clear();
       oldHashMap.putAll(newHashMap);
       System.out.println(oldHashMap);
    }

    /**
     * This method is to set the facility not work at the beginning of being built.
     * @param times the number of gate way need to be set.
     * @param id the unit id.(print)
     */
    public void setTotalFacilityUnavailable(int times, int id, HashMap<Integer, Boolean> facilityMap) {
        for (int i = 0; i < times; i++) {
            id++;
            facilityMap.put(id, false);
        }
        System.out.println(facilityMap);
    }



    /**
     * This method is to print the individual situation and its selections can be chosen.
     * @param individualType the characteristic object.
     */
    public void printIndividual(typeOfConstruction individualType) {
        individualType.printIndivadualSituation();
        individualType.printGeneralSelection();
    }

    /**
     * This method is to update the list including minerals and gas.
     * @param position the character need to be changed.
     * @param individualType the characteristic object.
     */
    public void updateTheList(int position, typeOfConstruction individualType) {
        int id = individualType.getNewId();
        idList.set(position, id);
        totalMinerals = individualType.getTotalMinerals();
        totalGas = individualType.getTotalGas();
    }


    //Personal method begins with here.

    /**
     * This method is to update the situation of the minerals patches.
     * @param newMineralPatchList the situation of patch after the assignment.
     */
    public void renewPatchList(List<Integer> newMineralPatchList) {
        mineralPatchList = new ArrayList<>();
        mineralPatchList.addAll(newMineralPatchList);
        System.out.println("This is the situation of patch: " + mineralPatchList);
    }

    /**
     * This method is to renew the gas list.
     * @param newGasList the new gas list show the probes working.
     */
    public void renewGasList(List<Integer> newGasList) {
        gasList = new ArrayList<>();
        gasList.addAll(newGasList);
        System.out.println("This is the situation of gas: " + gasList);
    }

    /**
     * This method is to set the situation of the nexus.
     */
    public void updateNexusMap() {
        Set set = nexusMap.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            int id = (int) pair.getKey();
            boolean available = (boolean) pair.getValue();

            if (!available) {
                if ((id < initialList.get(NEXUS) + 1000)
                        && (secondsTotal - totalmap.get(id) >= timeList[NEXUS])) {
                    nexusMap.put(id, true);
                } else if ((id < initialList.get(PROBE) + 1000)
                        && (secondsTotal - totalmap.get(id) >= timeList[PROBE])) {
                    nexusMap.put(id, true);
                }
            }

        }
    }

    /**
     * This method is to set the situation of the gate way, which is used for probes.
     * True presents available.
     */
    public void updateGateWayMap() {
        if(!gateWayMap.isEmpty()) {// make sure there is value inside the hash map
            Set set = gateWayMap.entrySet();
            Iterator iterator = set.iterator();

            while (iterator.hasNext()) { //go over all the gate way.
                Map.Entry pair = (Map.Entry) iterator.next();
                int id = (int) pair.getKey();
                boolean available = (boolean) pair.getValue();

                if (!available) {
                    //if the gate way is not in constructing or building other unit,
                    //the value will become true.
                    if ((id < initialList.get(GATEWAY) + 1000)
                            && (secondsTotal - totalmap.get(id) >= timeList[GATEWAY])) {
                        gateWayMap.put(id, true);
                    } else if ((id < initialList.get(ZEALOT) + 1000)
                            && (secondsTotal - totalmap.get(id) >= timeList[ZEALOT])) {
                        gateWayMap.put(id, true);
                    } else if (id < initialList.get(STALKER) + 1000
                            && (secondsTotal - totalmap.get(id) >= timeList[STALKER])) {
                        gateWayMap.put(id, true);
                    } else if (id < initialList.get(SENTRY) + 1000
                            && (secondsTotal - totalmap.get(id) >= timeList[SENTRY])) {
                        gateWayMap.put(id, true);
                    }
                }
            }
        }
    }

    /**
     * This method is to set the situation of the robotics facility.
     * True presents available.
     */
    public void updateRoboticsMap() {
        if(!roboticsMap.isEmpty()) {
            Set set = roboticsMap.entrySet();
            Iterator iterator = set.iterator();

            while (iterator.hasNext()) {
                Map.Entry pair = (Map.Entry) iterator.next();
                int id = (int) pair.getKey();
                boolean available = (boolean) pair.getValue();

                if (!available) {
                    if ((id < initialList.get(ROBOTIC) + 1000)          //last used was robotics.
                            && (secondsTotal - totalmap.get(id) >= timeList[ROBOTIC])) {
                        roboticsMap.put(id, true);
                    } else if ((id < initialList.get(OBSERVER) + 1000)  //last used was observe.
                            && (secondsTotal - totalmap.get(id) >= timeList[OBSERVER])) {
                        roboticsMap.put(id, true);
                    } else if ((id < initialList.get(IMMORTAL) + 1000)  //last used was Immortal.
                            && (secondsTotal - totalmap.get(id) >= timeList[IMMORTAL])) {
                        roboticsMap.put(id, true);
                    }
                }
            }
            System.out.println(roboticsMap);
        }
    }

    /**
     * This method is to update the star gate map.
     */
    public void updateStarGateMap() {
        if(!starGateMap.isEmpty()) {
            Set set = starGateMap.entrySet();
            Iterator iterator = set.iterator();

            while (iterator.hasNext()) {
                Map.Entry pair = (Map.Entry) iterator.next();
                int id = (int) pair.getKey();
                boolean available = (boolean) pair.getValue();

                if (!available) {
                    if ((id < initialList.get(STARGATE) + 1000)
                            && (secondsTotal - totalmap.get(id) >= timeList[STARGATE])) {
                        starGateMap.put(id, true);
                    } else if ((id < initialList.get(PHOENIX) + 1000)
                            && (secondsTotal - totalmap.get(id) >= timeList[PHOENIX])) {
                        starGateMap.put(id, true);
                    } else if ((id < initialList.get(VOID_RAY) + 1000)
                            && (secondsTotal - totalmap.get(id) >= timeList[VOID_RAY])) {
                        starGateMap.put(id, true);
                    } else {
                        System.out.println("revise");
                    }
                }
            }
        }
    }


    /**
     * This method is to stop the whole game and print out the total time.
     */
    public void end() {
        totalTimer.cancel();
        printTotalTime();
    }

    /**
     * This is the printer to convert seconds to minutes.
     */
    public void printTotalTime() {
        int minute = secondsTotal / 60;
        int timerSecond = secondsTotal - minute * 60;
        System.out.println("Total time is: " + minute + " mins " + timerSecond + " seconds");
    }
}
