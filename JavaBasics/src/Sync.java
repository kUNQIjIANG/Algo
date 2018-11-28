/**
 * Created by kunqi
 * ON 11/27/18 11:37 AM
 */




public class Sync {
    private int c = 0;

    public synchronized void add() {
        c++;
    }

    public synchronized void subs() {
        c--;
    }

    public synchronized int getC() {
        return c;
    }

    public static void main(String[] args) {
        Sync sync = new Sync();
        Thread t3 = new Thread(new T3(sync,"t3"));
        Thread t4 = new Thread(new T4(sync,"t4"));
        Thread t5 = new Thread(new T5(sync,"t5"));
        t3.start();
        t4.start();
        t5.start();
    }
}

class T3 implements Runnable{
    Sync s;
    String name;

    T3(Sync s, String name){
        this.s = s;
        this.name = name;
    }

    public void run(){
        s.add();
        System.out.println(this.name+" "+s.getC());

    }
}

class T4 implements Runnable{
    Sync s;
    String name;

    T4(Sync s,String name){
        this.s = s;
        this.name = name;
    }

    public void run(){
        System.out.println(this.name + " " + s.getC());
        s.subs();
    }
}

class T5 implements Runnable{
    Sync s;
    String name;

    T5(Sync s, String name){
        this.s = s;
        this.name = name;
    }

    public void run(){
        System.out.println(this.name + " " + s.getC());
    }
}