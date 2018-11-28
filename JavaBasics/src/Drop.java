/**
 * Created by kunqi
 * ON 11/28/18 7:40 PM
 */

public class Drop {
    private String message;
    private boolean empty = true;

    public synchronized String take(){
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

    public synchronized void put(String message){
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
