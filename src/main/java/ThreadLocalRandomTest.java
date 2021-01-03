import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ThreadLocalRandomTest {
    public static void main(String[] args) throws InterruptedException {
        // System.out.println(Math.random()); dont use this in concurrency

        System.out.println(ThreadLocalRandom.current().nextInt());  // use this zxc

        // Thread.sleep(TimeUnit.DAYS.toMillis(15)); for wait 15 days
    }
}
