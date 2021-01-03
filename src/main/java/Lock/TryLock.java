package Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
ThreadB will wait until lock is released
 */
public class TryLock {
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
       new ThreadA().start();
       new ThreadB().start();
    }

    static class ThreadA extends Thread {
        @Override
        public void run() {
            lock.lock();
            System.out.println(getName() + " start working");
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + " stop working");
            lock.unlock();
            System.out.println(getName() + " lock is released");
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            System.out.println(getName() + " begin working");
            while (true) {
                if (lock.tryLock()) {
                    System.out.println(getName() + " working");
                    break;
                } else {
                    System.out.println(getName() + " waiting");
                }
            }
        }
    }
}
