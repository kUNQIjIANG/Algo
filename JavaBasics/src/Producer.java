import java.util.Random;

/**
 * Created by kunqi
 * ON 11/28/18 7:49 PM
 */

public class Producer implements Runnable {
    private Drop drop;
    private String[] infos;

    public Producer (Drop drop, String[] infos){
        this.drop = drop;
        this.infos = infos;
    }

    public void run(){
        Random random = new Random();
        for (int i = 0; i < infos.length; i++) {
            drop.put(infos[i]);
            try {
                // simulate real-time application
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                System.out.println("producer sleep");
            }
        }
        drop.put("Done");
    }
}
