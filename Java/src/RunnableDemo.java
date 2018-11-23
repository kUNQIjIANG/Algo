/**
 * Created by kunqi
 * ON 11/23/18 5:52 PM
 */

public class RunnableDemo implements Runnable {
    private Thread t;
    private String threadName;

    RunnableDemo(String threadName){
        this.threadName = threadName;
        System.out.println("Creating thread " + threadName);
    }

    public void run() {
        System.out.println("Running thread " + threadName);
        try{
            for (int i = 4; i > 0; i--){
                System.out.println("Thread " + threadName + ", " + i);
                Thread.sleep(50);
            }
        }catch(InterruptedException e){
            System.out.println("Thread " + threadName + "interrupted");
        }
        System.out.println("Thread " + threadName + "exits");
    }

    public void start(){
        System.out.println("Starting thread " + threadName);
        if (t == null){
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
