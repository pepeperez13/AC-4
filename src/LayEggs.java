import java.util.Random;

/**
 * Clase que se encarga de poner huevos con un thread
 */
public class LayEggs extends Thread{

    private int chickenTag;

    public LayEggs (int chickenTag) {
        this.chickenTag = chickenTag;
    }

    // Va ejecutando el thread de cada gallina que pone huevos. Tiene que ir synchronized para que no modifique los huevos/gallinas a la vez que otro thread
    @Override
    public synchronized void run () {
        Random r = new Random();

        // Bucle que va haciendo que una gallina ponga 10 huevos con un tiempo de espera aleatorio
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(r.nextInt(6000-2000) + 2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Después del tiempo de espera añadimos huevo
            FarmManager.incrementEgg();
            System.out.printf("Chicken #%d laid the #%d egg.\n", chickenTag, (i+1));
            // Si es el último huevo de la última gallina, mostramos mensaje
            if (i == 9 && FarmManager.getChickenNumber() == 1) {
                System.out.printf("Chicken #%d died.\n", chickenTag);
            }
        }
        // Una vez se han puesto los 10 huevos, se reduce el número de gallinas
        FarmManager.killChicken();
    }
}
