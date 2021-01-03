package E_ThreadControl;

import java.util.concurrent.Phaser;
/*
 Each washer have phase of washing, and they cant go further, if all (3) not done
 */
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
