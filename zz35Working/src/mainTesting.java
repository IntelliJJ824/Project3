import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class mainTesting {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String userInput;
            process runner = new process();
            do {
                 System.out.println("--------------------Summary--------------------------");
                 runner.printTotalTime();
                 runner.printSituation();
                 System.out.println();
                 System.out.println("Please select the kinds of buildings or units you would control.");
                 printSelection();//this is to print the selection for user to control.
                 userInput = reader.readLine();
                 runner.setUserInput(userInput);

                 System.out.println();
            } while (!userInput.equals("quit"));

            runner.end();
        } catch (IOException e) {
            e.getStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.getStackTrace();
            }
        }
    }

    static public void printSelection() {
        System.out.println("--Buildings and Probes:\na.NEXUS b.PROBE c.PYLON d.ASSIMILATOR e.GATEWAY f.CYBERNETICS CORE"
                + " g.ROBOTICS FACILITY" + " h.STARGATE"
                + "\np.TWILIGHT COUNCIL q.TEMPLAR ARCHIVES r.DARK SHRINE s.ROBOTICS BAY t.FLEET BEACON");
        System.out.println("--Units:\ni.ZEALOT" + " j.STALKER" + " k.SENTRY" + " l.OBSERVER" + " m.IMMORTAL"
                + " n.PHOENIX" + " o.VOID RAY" + "\nu.COLOSSI v.HIGH TEMPLAR w.DARK TEMPLAR x.CARRIER");
    }
}
