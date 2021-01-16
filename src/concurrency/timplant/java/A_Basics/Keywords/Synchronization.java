package A_Basics.Keywords;

public class Synchronization {

    /*
    resource.i might be not 7 without synchronized keyword. Even without yield
     */
    public static void main(String[] args) throws Exception {
        Resource resource = new Resource();
        resource.setI(5);
        MySyncThread thread1 = new MySyncThread();
        MySyncThread thread2 = new MySyncThread();

        thread1.setResource(resource);
        thread2.setResource(resource);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(resource.getI());
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
    }
}

class Resource {
    private int i;

    public void setI(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    /*
     This method is synchronized, which means method is locked,
     Only a single thread can execute him (or blocked in a same time
     Never combine static synchronized method with synchronized methods
     */
    public synchronized void incrementI() {  // synchronized method blocking whole class
        int i = this.i;
        i++;
        this.i = i;
    }
}
