/**
 * Clase que se encarga de recoger los huevos con un thread
 */
public class CollectEggs extends Thread{

    // Va ejecutando el thread que recoge huevos. Tiene que ir synchronized para que no modifique los huevos a la vez que otro thread
    @Override
    public synchronized void run () {

        // Seguimos recogiendo huevos hasta que se mueran todas las gallinas
        while (FarmManager.getChickenNumber() > 0) {
            try {
                Thread.sleep(FarmManager.getPickInterval() * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Después del tiempo de espera, recolectamos y vendemos huevos
            FarmManager.collectAndSellEggs();
        }

    }
}
