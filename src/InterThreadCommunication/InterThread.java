package InterThreadCommunication;

import java.util.*;


public class InterThread {

    public static void main(String[] args) {
        Shared s = new Shared();
        Producer p = new Producer(s);
        Consumer c = new Consumer(s);
        p.start(); c.start();

    }
}
class Shared {
    private int data;
    private boolean available = false;

    public synchronized void produce(int value) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        data = value;
        available = true;
        System.out.println("produced data " + data);
        notify();
    }

    public synchronized void consume() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        System.out.println("consumed data " + data);
        available = false;
        notify();
    }
}
class Producer extends Thread {
    Shared s;
    Producer(Shared s) {
        this.s = s;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            s.produce(i);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {}
        }
    }
}

class Consumer extends Thread {
    Shared s;
    Consumer(Shared s) {
        this.s = s;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            s.consume();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {}
        }
    }
}

