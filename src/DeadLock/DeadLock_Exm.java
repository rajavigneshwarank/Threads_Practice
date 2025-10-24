package DeadLock;

import java.util.*;

public class DeadLock_Exm {
    public static void main(String[] args) {

      final Object resource1 = "Resource-1";
        final Object resource2 ="Resource-2";

      Thread t1 = new Thread(()->{
        synchronized(resource1){
            System.out.println("thread 1 locked resource 1");
            try{
                Thread.sleep(5000);
            }catch(InterruptedException e){}

           System.out.println("thread 1 waiting to lock resource 2");
          synchronized(resource2){
              System.out.println("thread 1  locked resource 2");
          }

        }
      });

        Thread t2 = new Thread(()->{
            synchronized(resource2){
                System.out.println("thread 2 locked resource 2");
                try{
                    Thread.sleep(5000);
                }catch(InterruptedException e){}

                System.out.println("thread 2 waiting to lock resource 1");
                synchronized(resource1){
                    System.out.println("thread 2  locked resource 1");
                }

            }
        });

        t1.start();
        t2.start();

    }
}
