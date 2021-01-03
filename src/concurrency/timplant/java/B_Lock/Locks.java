package B_Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locks {

    /*
    resource.i might be 6 without locks. Even without yield
     */

    public static void main(String[] args) throws Exception {
        Resource resource = new Resource();
        resource.setI(5);
        resource.j = 5;
        MySyncThread thread1 = new MySyncThread();
        MySyncThread thread2 = new MySyncThread();

        thread1.setResource(resource);
        thread2.setResource(resource);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(resource.getI());
        System.out.println(resource.j);
    }
}

class MySyncThread extends Thread {
    Resource resource;

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.incrementI();
        resource.incrementJ();
    }
}

class Resource {
    private int i;
    int j;

    Lock lock = new ReentrantLock();

    public void setI(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    /*
     This method's is locked,
     Only a single thread can execute him in a same time (cuz locks)
     */
    public void incrementI() {
        lock.lock();
        int i = this.i;
        if (Thread.currentThread().getName().equals("Thread-0")) {
            Thread.yield();
        }
        i++;
        this.i = i;
    }

    public void incrementJ() {
        int j = this.j;
        if (Thread.currentThread().getName().equals("Thread-0")) {
            Thread.yield();
        }
        j++;
        this.j = j;
        lock.unlock();
    }
}
