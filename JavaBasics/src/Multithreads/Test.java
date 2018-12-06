package Multithreads;

/**
 * Created by kunqi
 * ON 11/26/18 9:54 PM
 */

public class Test implements Runnable{
    public void run(){
        try{
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread t = new Thread(new Test(),"thread test");
        System.out.println("start");
        long patient = 3000;
        long startTime = System.currentTimeMillis();
        t.start();
        while(t.isAlive()) {

            System.out.println("wait");
            t.join(2000);
            if (System.currentTimeMillis() - startTime > patient) {
                System.out.println("interrupt");
                t.interrupt();
                System.out.println("cont");
                t.join();
            }
        }
        System.out.println("finished");
    }

}
