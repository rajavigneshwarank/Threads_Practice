package Synchronization;
import java.util.*;
public class SyncRaceBlockMethod {
    public static void main(String[] args) throws InterruptedException {
        Counter1 counter = new Counter1();

        Runnable r1 = new MyRunnable1(counter);
        Runnable r2 = new MyRunnable1(counter);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("result is " + counter.count);
    }
}
class MyRunnable1 implements Runnable {
    Counter1 counter;

    MyRunnable1(Counter1 counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            counter.increment();
        }
    }
}

//class Counter1 {
//    int count = 0;
//
//    synchronized void increment() {
//        count++;
//    }
//}

class Counter1 {
    int count = 0;
    void increment() {
        synchronized (this) {
            count++;
        }
    }
}