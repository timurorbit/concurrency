/*
Thread states:
NEW
RUNNABLE
BLOCKED
WAITING / TIMED_WAITING
TERMINATED
 */

public class ThreadLifecycle {
    public static void main(String[] args) throws Exception {
        MyThread myThread = new MyThread();
        myThread.start();

       // myThread.setPriority(Thread.MAX_PRIORITY); set priority to thread

       // Thread.currentThread().sleep(1000);   this thread going to sleep

       // Thread.yield();  hey, use my core if you want do something else

       // myThread.join(); wait for complete of this thread (myThread), then resume doing this

        System.out.println("thread main");

    }
}