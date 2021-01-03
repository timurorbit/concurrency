import java.util.concurrent.*;

public class ThreadCreation {
    /*
       Runnable (interface), Thread (extends class), and Callable (return value)

       Output is unpredicted

       new Thread = new Stack - from method run()
     */
    public static void main(String[] args) throws Exception {
        MyThread myThread = new MyThread();

        MyRunnable myRunnable = new MyRunnable();

        MyCallable myCallable = new MyCallable();


        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(myThread);
        executorService.submit(myThread);
        executorService.submit(myRunnable);
        executorService.submit(myCallable);

      //  myThread.start();
      //  myThread.start(); illegalStateException
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("This is a new thread " + Thread.currentThread().getName());
    }
}

class MyRunnable implements Runnable {

    public void run() {
        System.out.println("This is a new runnable " + Thread.currentThread().getName());
    }
}

class MyCallable implements Callable<String> {

    public String call() throws Exception {
        System.out.println("This is a new callable " + Thread.currentThread().getName());
        return "This is a old callable " + Thread.currentThread().getName();
    }
}
