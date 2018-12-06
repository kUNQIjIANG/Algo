package Multithreads.ProductConsumer;

import Multithreads.ProductConsumer.Drop;

import java.util.Random;

/**
 * Created by kunqi
 * ON 11/28/18 7:49 PM
 */

class Producer implements Runnable {

    private Drop drop;
    private String[] infos;

    Producer (Drop drop, String[] infos){
        this.drop = drop;
        this.infos = infos;
    }

    public void run(){
        Random random = new Random();
        for (String s : infos) {
            drop.put(s);
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
