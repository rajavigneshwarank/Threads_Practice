package Basic_Threads;

import java.util.*;

class MyRunnable implements Runnable {
    public void run() {
        for(int i = 1; i <= 5; i++) {

            System.out.println("runnable thread: " + i);

            try { Thread.sleep(500); }

            catch(Exception e)
            {}
        }
    }
}
public class ThreadDemo2 {
    public static void main(String[] args) {
        MyRunnable r = new MyRunnable();
        Thread t1 = new Thread(r);
        t1.start();

        for(int i = 1; i <= 5; i++) {
            System.out.println("main thread: " + i);

            try { Thread.sleep(500); }

            catch(Exception e)
            {}
        }
    }
}
