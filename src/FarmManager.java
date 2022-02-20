public class FarmManager {
    private static int chickenNumber;
    private static int pickInterval;
    private static int maxEggs;
    private static double earnedMoney;
    private static int partialEgg;
    private static int totalEggs;
    private static int lostEggs;


    public FarmManager(int chickenNumber, int pickInterval, int maxEggs) {
        FarmManager.chickenNumber = chickenNumber;
        FarmManager.pickInterval = pickInterval;
        FarmManager.maxEggs = maxEggs;
    }

    public static void killChicken () {
        chickenNumber--;
    }

    public static int getChickenNumber () {
        return chickenNumber;
    }

    public static int getPickInterval () {
        return pickInterval;
    }

    public static int getMaxEggs () {
        return maxEggs;
    }

    public static void incrementMoney (double amount) {
        earnedMoney += amount;
    }

    public static double getEarnedMoney () {
        return earnedMoney;
    }

    public static void incrementEgg () {
        partialEgg++;
        totalEggs++;
    }
    public static void setPartialZero() {
        partialEgg = 0;
    }

    public static void updateLost (int newLost) {
        lostEggs += newLost;
    }

    public static int getPickedEggs () {
        return totalEggs - lostEggs;
    }

    public static int getPartialEgg () {
        return partialEgg;
    }

    public static int getLostEggs () {
        return lostEggs;
    }

    public static void collectAndSellEggs () {

        // SI los huevos acumulados no superan a los que se pueden recoger
        if (getPartialEgg() <= getMaxEggs()) {
            if (getPartialEgg() >= 3 && getPartialEgg() <= 4) {
                System.out.printf("\nThe farmer collected %d eggs and sold them for %.1f€\n\n", getPartialEgg(), 0.6 * getPartialEgg());
                incrementMoney(0.6 * getPartialEgg());
            } else {
                // Si no hay ni 3 ni 4 huevos, hay que comprobar que como mínimo se estén recogiendo más de 4
                if (getPartialEgg() > 4) {
                    System.out.printf("\nThe farmer collected %d eggs and sold them for %.1f€\n\n", getPartialEgg(), 0.4 * getPartialEgg());
                    incrementMoney(0.4 * getPartialEgg());
                }else{
                    // Si no había un mínimo de 3 huevos para recoger, esos huevos se perderán
                    updateLost(getPartialEgg());
                }
            }
            setPartialZero();
        }else{
            // Si hay mas huevos acumulados que los que se pueden recoger
            if (getMaxEggs() >= 3 && getMaxEggs() <= 4) {
                System.out.printf("\nThe farmer collected %d eggs and sold them for %.1f€\n\n", getMaxEggs(), 0.6 * getMaxEggs());
                incrementMoney(0.6 * getMaxEggs());
            } else {
                System.out.printf("\nThe farmer collected %d eggs and sold them for %.1f€\n\n", getMaxEggs(), 0.4 * getMaxEggs());
                incrementMoney(0.4 * getMaxEggs());
            }
            updateLost((getPartialEgg() - getMaxEggs()));
            setPartialZero();
        }
    }

}
