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
                 userInput = reader.readLine();
                 System.out.println();
            } while (!userInput.equals("quit"));

            System.out.println("Game Over!!!");
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
}
