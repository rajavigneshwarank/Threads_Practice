package Basic_Threads;

class StateThread extends Thread {
    public void run() {
        try {
            System.out.println(getName() + " is running");
            System.out.println("thread in the run method " + this.getState());

            Thread.sleep(1000);

            System.out.println(getName() + " finished sleep");
        }
        catch (InterruptedException e) {
        }
    }
}

public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        StateThread t1 = new StateThread();
        StateThread t2 = new StateThread();
          System.out.println("t1 state after creation " + t1.getState());
         System.out.println("t2 state after creation " + t2.getState());

        t1.start();
        t2.start();

//        Thread.sleep(100);
         System.out.println("t1 state after start " + t1.getState());
        System.out.println("t2 state after start " + t2.getState());

//        Thread.sleep(1000);
        System.out.println("t1 state during sleep: " + t1.getState());
         System.out.println("t2 state during sleep: " + t2.getState());

        t1.join();
        t2.join();

        System.out.println("t1 state after completion: " + t1.getState());
         System.out.println("t2 state after completion: " + t2.getState());
    }
}
