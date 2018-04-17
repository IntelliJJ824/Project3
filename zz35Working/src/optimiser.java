
public class optimiser {

    public void processGoal(String userInput) {
        switch(userInput) {
            case ("1"):
                System.out.println("first goal.");
                break;

                case ("2"):
                break;

            case ("3"):
                break;

            case("4"):
                break;

            case ("5"):
                break;

                default:
                System.out.println("No such a goal.");
        }
    }

    /**
     * This is to print out  the five goals in the specificaiton.
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
}
