package Synchronization;
import java.util.*;

public class SyncRace {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable r1 = new MyRunnable(counter);
        Runnable r2 = new MyRunnable(counter);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();t2.start();

        t1.join();t2.join();

        System.out.println("result is " + counter.count);
    }
}

class Counter {
    int count = 0;

    void increment() {
        count++;
    }
}

class MyRunnable implements Runnable {
    Counter counter;

    MyRunnable(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}
