package Basic_Threads;

import java.util.*;

class MyThread extends Thread {
    public void run() {

        for(int i = 1; i <= 5; i++) {

            System.out.println(" user thread : " + i);

            try
            { Thread.sleep(500);
            }
            catch(Exception e) {

            }
        }
    }
}
public class ThreadDemo1 {
    public static void main(String[] args) {

        MyThread t1 = new MyThread();
        t1.start();

        for(int i = 1; i <= 5; i++) {
            System.out.println("main thread: " + i);
            try { Thread.sleep(500); } catch(Exception e) {}
        }
    }
}
