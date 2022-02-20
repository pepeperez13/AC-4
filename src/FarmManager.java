/**
 * Clase que gestiona el contabilizar huevos, gallinas, precios etc. En resumen gestiona la granja en general
 */
public class FarmManager {
    private static int chickenNumber; // Numero de gallinas en la granja
    private static int pickInterval;  // Intervalo temporal de recogida
    private static int maxEggs;       // Huevos maximos que se pueden recoger
    private static double earnedMoney;
    private static int partialEgg;    // Huevos que se han acumulado entre cada recogida
    private static int totalEggs;     // Huevos puestos en total
    private static int lostEggs;      // Huevos que se habían puesto pero no se han podido recoger


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

    // Controla la logica de cuantos huevos se pueden recoger y su precio
    public static void collectAndSellEggs () {

        // Si los huevos acumulados en esa ronda no superan a los que se pueden recoger
        if (getPartialEgg() <= getMaxEggs()) {
            // Si se han recogido entre 1 y 4 huevos, el precio es superior
            if (getPartialEgg() >= 1 && getPartialEgg() <= 4) {
                System.out.printf("\nThe farmer collected %d eggs and sold them for %.1f€\n\n", getPartialEgg(), 0.6 * getPartialEgg());
                incrementMoney(0.6 * getPartialEgg());
            } else {
                // Si se han recogido mas de 4 huevos (por los tiempos nunca llegará a ocurrir que haya cero), el precio es inferior
                System.out.printf("\nThe farmer collected %d eggs and sold them for %.1f€\n\n", getPartialEgg(), 0.4 * getPartialEgg());
                incrementMoney(0.4 * getPartialEgg());
            }
            setPartialZero();
        }else{
            // Si hay más huevos acumulados en esa ronda que los que se pueden recoger
            if (getMaxEggs() >= 3 && getMaxEggs() <= 4) {
                System.out.printf("\nThe farmer collected %d eggs and sold them for %.1f€\n\n", getMaxEggs(), 0.6 * getMaxEggs());
                incrementMoney(0.6 * getMaxEggs());
            } else {
                System.out.printf("\nThe farmer collected %d eggs and sold them for %.1f€\n\n", getMaxEggs(), 0.4 * getMaxEggs());
                incrementMoney(0.4 * getMaxEggs());
            }
            // Como se han recogido menos huevos de los que se habían puesto, se pierden huevos
            updateLost((getPartialEgg() - getMaxEggs()));
            // Ponemos a cero los huevos parciales acumulados entre las recogidas
            setPartialZero();
        }
    }

}
