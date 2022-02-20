import java.util.Random;

public class LayEggs extends Thread{

    private int chickenTag;

    public LayEggs (int chickenTag) {
        this.chickenTag = chickenTag;
    }

    @Override
    public synchronized void run () {
        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(r.nextInt(6000-2000) + 2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            FarmManager.incrementEgg();
            System.out.printf("Chicken #%d laid the #%d egg.\n", chickenTag, (i+1));
            // Si es el último huevo de la última gallina, mostramos mensaje
            if (i == 9 && FarmManager.getChickenNumber() == 1) {
                System.out.printf("Chicken #%d died.\n", chickenTag);
            }
        }
        FarmManager.killChicken();
    }
}
