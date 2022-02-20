import java.util.Scanner;

public class UIView {
    Scanner scanner = new Scanner(System.in);


    public void showWelcome () {
        System.out.println("******** Welcome to the Farm Simulator! ********");
    }

    public int askChickenNumber () {
        int chicken;

        System.out.print("Enter a number of chickens [4-15]: ");
        chicken = scanner.nextInt();
        while (chicken < 4 || chicken > 15) {
            System.out.print("\tThe value entered is not correct. Enter a valid one: ");
            chicken = scanner.nextInt();
        }
        return chicken;
    }

    public int askPickInterval () {
        int interval;
        System.out.print("Enter a pick-up interval [5-30]: ");
        interval = scanner.nextInt();
        while (interval < 5 || interval > 30) {
            System.out.print("\tThe value entered is not correct. Enter a valid one: ");
            interval = scanner.nextInt();
        }
        return interval;
    }

    public int askEggsPicked () {
        int pick;
        System.out.print("Enter the number of eggs picked on each round: ");
        pick = scanner.nextInt();
        while (pick < 3 || pick > 8) {
            System.out.print("\tThe value entered is not correct. Enter a valid one: ");
            pick = scanner.nextInt();
        }
        return pick;
    }

    public void showFinalResult () {
        System.out.println("\n********************************************************************");
        System.out.printf("The farmer collected a total of %d eggs and earned a total of %.1f€.\n", FarmManager.getPickedEggs(), FarmManager.getEarnedMoney());
        System.out.printf("All chickens have died and a total of %d eggs haven't been collected.\n", FarmManager.getLostEggs());
        System.out.println("*********************************************************************");
    }
}
