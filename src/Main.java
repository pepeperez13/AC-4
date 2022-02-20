public class Main {

    public static void main (String[] args) throws InterruptedException {
        UIView uiView = new UIView();
        uiView.showWelcome();
        FarmManager farmManager = new FarmManager(uiView.askChickenNumber(), uiView.askPickInterval(), uiView.askEggsPicked());



        CollectEggs collectEggs = new CollectEggs();
        for (int i = 0; i < FarmManager.getChickenNumber(); i++) {
            LayEggs layEggs = new LayEggs(i+1);
            System.out.println("NEW THREAD");
            layEggs.start();
        }
        collectEggs.start();
        collectEggs.join();
        uiView.showFinalResult();


    }
}
