import java.util.concurrent.CountDownLatch;
/*
For doing some exact number of works, and then await.
 */
public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        new Work(countDownLatch);
        new Work(countDownLatch);
        new Work(countDownLatch);

        countDownLatch.await();
        System.out.println("all jobs done");
    }
}

class Work extends Thread {
    CountDownLatch countDownLatch;

    public Work(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("work was done");
        countDownLatch.countDown();
    }
}
