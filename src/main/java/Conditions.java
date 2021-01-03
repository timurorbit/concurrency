import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
 Condition is equals to wait  (condition.await = wait)  (conditions.signal = notify)
 */
public class Conditions {

    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    static int account = 0;

    public static void main(String[] args) {
        new AccountMinus().start();
        new AccountPlus().start();
    }

    static class AccountPlus extends Thread {
        @Override
        public void run() {
            lock.lock();
            account += 10;
            condition.signal();
            lock.unlock();
        }
    }

    static class AccountMinus extends Thread {
        @Override
        public void run() {
            if (account < 10) {
                try {
                    lock.lock();
                    System.out.println("before = " + account);
                    while (account < 10) {
                        condition.await();
                    }
                    System.out.println("after = " + account);
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            account -= 10;
            System.out.println("account at the end = " + account);
        }
    }
}
