import java.io.BufferedReader;
import java.io.IOException;
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
    Timer totalTimer;
    int secondsTotal = 0;
    final int PERIOD = 1000;
    int totalMinerals;
    int totalGas;
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

    //this is to store the type of the unit, and its newest ID.
    private ArrayList<Integer> idList = new ArrayList<>();
    private ArrayList<Integer> initialList = new ArrayList<>();

    // this is to store all the units and building.
    private HashMap<Integer, Integer> totalmap = new HashMap<>();

    //This is the list to convert from number to specific name.
    private String[] convertList = {
            "NEXUS", "PROBE", "PYLON", "ASSIMILATOR", "GATEWAY", "CYBERNETICS CORE", "ROBOTICS FACILITY", "STARGATE",
            "ZEALOT", "STALKER", "SENTRY", "OBSERVER", "IMMORTAL", "PHOENIX", "VOID RAY"};

    private int[] timeList = {
            100, 17, 25, 30, 65, 50, 65, 60, //This is for buildings and probe
            38, 42, 37, 40, 55, 35, 60 //This is for units
    };

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
        totalTimer.schedule(totalTimeCalculation, new Date(), PERIOD);
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
        totalmap.put(idList.get(NEXUS), secondsTotal);

        //This is to set the minerals and gas.
        totalMinerals = 250;
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

    public void setUserInput(String input) {
        Scanner reader = new Scanner(new InputStreamReader(System.in)); //This is to scan user's action input.
        switch (input.toLowerCase()) {
            case("a"):
                System.out.println("This is for " + convertList[NEXUS]);
                break;
            case("b"):
                System.out.println("This is for " + convertList[PROBE]);
                probe probeSelection = new probe(totalmap, idList.get(PROBE), initialList.get(PROBE),
                        timeList[PROBE], secondsTotal,
                        totalMinerals, totalGas);

                System.out.print(convertList[PROBE] + ": ");
                probeSelection.printIndivadualSituation();

                //try to prompt user input the action for his selection.
                probeSelection.printActionSelection();
                String actionInput = reader.next();

                //try to find out the amount of this action.
                if (!actionInput.equals("d")) {
                    System.out.println("How many probe will take this action?");
                    String amount = reader.next();
                    probeSelection.processActionInput(actionInput, amount);
                }

                //get new Id
                idList.set(PROBE, probeSelection.getNewId());

                //get new map
                totalmap.putAll(probeSelection.getTotalMap());

                break;
            case("c"):
                System.out.println("This is for " + convertList[PYLON]);
                break;
            case("d"):
                System.out.println("This is for " + convertList[ASSIMILATOR]);
                break;
            case("e"):
                System.out.println("This is for " + convertList[GATEWAY]);
                break;
            case("quit"):
                System.out.println("Game Over!!!");
                break;
            default:
                System.out.println("Invalid Selection!");
                break;
        }
        //method to update the map in the following codes.

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
