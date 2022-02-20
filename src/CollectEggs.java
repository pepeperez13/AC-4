public class CollectEggs extends Thread{

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
