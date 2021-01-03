import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVar {

   // static int i;  output will be not 10_000
    static AtomicInteger i = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        for (int j = 0; j < 10_000; j++) {
            new MyThread().start();
        }
        Thread.sleep(2000);
        System.out.println(i);
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            /* int k = i + 1;
               int i = k;    */
            i.incrementAndGet();
        }
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            i.incrementAndGet();
        }
    }
}
