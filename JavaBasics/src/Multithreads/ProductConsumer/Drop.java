package Multithreads.ProductConsumer;

/**
 * Created by kunqi
 * ON 11/28/18 7:40 PM
 */

class Drop {

    private String message;
    private boolean empty = true;

    synchronized String take(){
        while(empty){
            try{
                wait();
            }catch (InterruptedException e){
                System.out.println("take interrupt");
            }
        }

        empty = true;
        notifyAll();
        return message;
    }

    synchronized void put(String message){
        while(!empty){
            try{
                wait();
            }catch (InterruptedException e){
                System.out.println("put interrupt");
            }
        }
        this.message = message;
        empty = false;
        notifyAll();
    }
}
