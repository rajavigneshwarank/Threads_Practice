package Synchronization;
import java.util.*;
public class SyncRaceStatic {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyRunnable2());
        Thread t2 = new Thread(new MyRunnable2());

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("result is  " + Counter2.count);
    }
}
class Counter2 {
    static int count = 0;

    static synchronized void increment() { // lock on Counter.class
        count++;
    }
}
class MyRunnable2 implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            Counter2.increment();
        }
    }
}
