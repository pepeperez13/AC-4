public class CollectEggs extends Thread{

    // Va ejecutando el thread que recoge huevos. Tiene que ir synchronized para que no modifique los huevos a la vez que otro thread
    @Override
    public synchronized void run () {

        while (FarmManager.getChickenNumber() > 0) {
            try {
                Thread.sleep(FarmManager.getPickInterval() * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            FarmManager.collectAndSellEggs();
        }

    }
}
