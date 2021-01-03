package A_Basics;
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
        // System.out.println(myThread.getState()); print thread state

        MyThread myThread = new MyThread(); // NEW
        myThread.start();  // RUNNABLE

       // myThread.setPriority(Thread.MAX_PRIORITY); // set priority to thread

       // Thread.currentThread().sleep(1000); //   this thread going to sleep    TIMED_WAITING

       // Thread.yield(); //  hey, use my core if you want do something else  WAITING (if core have different tasks)

       // myThread.join(); // wait for complete of this thread (myThread), then resume doing this  WAITING(main thread in waiting state)

        // for BLOCKED watch the Locks

        // Thread.sleep(500); or myThread.join() let the myThread complete and it will be in TERMINATED state

        System.out.println("thread main");
    }
}