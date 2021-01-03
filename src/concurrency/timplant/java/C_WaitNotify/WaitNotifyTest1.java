package C_WaitNotify;

/*
 Wait and notify should be synchronized on the same object
 main thread wait for threadB call notify method, and then continues
 */
public class WaitNotifyTest1 {

    public static void main(String[] args) throws InterruptedException {
        ThreadB threadB = new ThreadB();
        threadB.start();
        synchronized (threadB) {
            threadB.wait();
        }
        System.out.println(threadB.total);
    }

    static class ThreadB extends Thread {
        int total;

        @Override
        public void run() {
            synchronized (this) {
                for (int i = 0; i < 5; i++) {
                    try {
                        total += i;
                        sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                notify();
            }
        }
    }
}
