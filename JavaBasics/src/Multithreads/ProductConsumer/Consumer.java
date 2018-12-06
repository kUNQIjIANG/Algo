package Multithreads.ProductConsumer;

import Multithreads.ProductConsumer.Drop;

import java.util.Random;

/**
 * Created by kunqi
 * ON 11/28/18 9:50 PM
 */

class Consumer implements Runnable {
    private Drop drop;

    Consumer(Drop drop){
        this.drop = drop;
    }

    public void run(){
        Random random = new Random();

        for ( String message = drop.take();
                ! message.equals("Done");
                message = drop.take()){
            System.out.format("Message Received: %s%n", message);
            try{
                Thread.sleep(random.nextInt(5000));
            }catch (InterruptedException e){
                System.out.println("Multithreads.ProductConsumer.Consumer interrupt");
            }
        }
    }


}
