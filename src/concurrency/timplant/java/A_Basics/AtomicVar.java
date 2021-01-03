package A_Basics;

import java.util.concurrent.atomic.AtomicInteger;

/*
  Use Atomic variables for synchronization in multiple threads
  (it is race condition?) if we use static int i)
 */
public class AtomicVar {

    // static int i;  output will not always be 10_000
    static AtomicInteger i = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        for (int j = 0; j < 10_000; j++) {
            new MyThread().start();
        }
        Thread.sleep(500);
        System.out.println(i);
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            /* int k = i + 1;
               i = k;    */
            i.incrementAndGet();
        }
    }
}
