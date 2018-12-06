package Multithreads;

/**
 * Created by kunqi
 * ON 11/26/18 6:05 PM
 */

public class Chat {

    private Boolean flag = false;

    synchronized void question(String msg){
        if (flag){
            try{
                wait();
            }catch( InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(msg);
        flag = true;
        notify();
    }

    synchronized void answer(String msg){
        if (!flag){
            try{
                wait();
            }catch( InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(msg);
        flag = false;
        notify();
    }

    public static void main(String[] args){
        Chat chat = new Chat();
        String[] question = {"Hi", "How are you today?","Share mercy"};
        String[] answer = {"Hi","I am good","Never Vanity"};
        new T1(chat,question);
        new T2(chat,answer);
    }

}

class T1 implements Runnable {
    private Chat c;
    private String[] msgs;

    T1(Chat c, String[] msgs){
        this.c = c;
        this.msgs = msgs;
        new Thread(this,"Question thread").start();
    }

    public void run(){
        for ( String msg : msgs){
            c.question(msg);
        }
    }
}

class T2 implements Runnable{
    private Chat c;
    private String[] msgs;

    T2(Chat c, String[] msgs){
        this.c = c;
        this.msgs = msgs;
        new Thread(this,"Answer thread").start();
    }

    public void run(){
        for (String msg : msgs){
            c.answer(msg);
        }
    }
}

