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
                 runner.printTotalTime();
                 runner.printSituation();

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
        System.out.println("a.NEXUS b.PROBE c.PYLON d.ASSIMILATOR e.GATEWAY f.CYBERNETICS CORE"
                + " g.ROBOTICS");
        System.out.println("h.ZEALOT" + " i.STALKER" + " j.OBSERVER" + " k.IMMORTAL" + " l.IMMORTAL"
                + " m.PHOENIX" + " n.VOID RAY");

    }
}
