import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomTest {
    public static void main(String[] args) throws InterruptedException {
        // System.out.println(Math.random()); dont use this in concurrency

        System.out.println(ThreadLocalRandom.current().nextInt());  // use this

    }
}
