package ThreadPool;

import java.util.concurrent.*;

public class ThreadPool{
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 6; i++) {
            MyTask task = new MyTask(i);
            pool.submit(task);
        }

        pool.shutdown();
    }
}
class MyTask implements Runnable {
    private int taskId;

    public MyTask(int taskId) {
        this.taskId = taskId;
    }
    public void run() {
        System.out.println("task " + taskId + " started by " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000); // simulate task execution
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task " + taskId + " completed by " + Thread.currentThread().getName());
    }
}
