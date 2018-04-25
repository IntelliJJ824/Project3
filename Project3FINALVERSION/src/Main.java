import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        GUIForm form = new GUIForm();
        optimiser model = new optimiser();
        BufferedReader reader = reader = new BufferedReader(new InputStreamReader(System.in));


        try {
            form.setVisible(true);
            model.printGoalSelection();
            String goal = reader.readLine();
            model.processGoal(goal);

            String userInput;
            process runner = new process();
            runner.runTheGame();
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

    static public void printSelection() throws IOException {
        System.out.println("--Buildings and Probes:\na.NEXUS b.PROBE c.PYLON d.ASSIMILATOR e.GATEWAY f.CYBERNETICS CORE"
                + " g.ROBOTICS FACILITY" + " h.STARGATE"
                + "\np.TWILIGHT COUNCIL q.TEMPLAR ARCHIVES r.DARK SHRINE s.ROBOTICS BAY t.FLEET BEACON");
        System.out.println("--Units:\ni.ZEALOT" + " j.STALKER" + " k.SENTRY" + " l.OBSERVER" + " m.IMMORTAL"
                + " n.PHOENIX" + " o.VOID RAY" + "\nu.COLOSSI v.HIGH TEMPLAR w.DARK TEMPLAR x.CARRIER");
    }

}