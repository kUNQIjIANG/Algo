package Multithreads.RunnableDemo;

import Multithreads.RunnableDemo.RunnableDemo;

/**
 * Created by kunqi
 * ON 11/24/18 10:31 PM
 */

public class TestThread {
    public static void main(String[] args){
        RunnableDemo R1 = new RunnableDemo("thread-1");
        R1.start();

        RunnableDemo R2 = new RunnableDemo("thread-2");
        R2.start();
    }
}
