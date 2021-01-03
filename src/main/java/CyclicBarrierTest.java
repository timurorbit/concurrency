import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Run());
        new Sportsman(cyclicBarrier);
        new Sportsman(cyclicBarrier);
        new Sportsman(cyclicBarrier);
    }

    static class Run implements Runnable {

        @Override
        public void run() {
            System.out.println("Run is begun");
        }
    }

    static class Sportsman extends Thread {
        CyclicBarrier barrier;

        public Sportsman(CyclicBarrier cyclicBarrier) {
            this.barrier = cyclicBarrier;
            start();
        }

        @Override
        public void run() {
            try {
                System.out.println("Barrier");
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("Barrier was broken");
        }
    }
}
