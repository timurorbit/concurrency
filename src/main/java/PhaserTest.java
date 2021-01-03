import java.util.concurrent.Phaser;

public class PhaserTest {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);
        new Washer(phaser);
        new Washer(phaser);
        new Washer(phaser);
    }

    static class Washer implements Runnable {
        Phaser phaser;

        public Washer(Phaser phaser) {
            this.phaser = phaser;
            new Thread(this).start();
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + " washing the car");
                phaser.arriveAndAwaitAdvance();
            }
        }
    }
}
