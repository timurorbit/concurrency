package A_Basics;

/*
Alphonse locks himself in synchronized block,
Elric locks himself too.
Then each other trying to access brother, but they cant cuz they locked
This is DeadLock
 */
public class Deadlock {

    public static void main(String[] args) {
        final Friend alphonse = new Friend("A");
        final Friend elric = new Friend("B");
        new Thread(() -> alphonse.bow(elric)).start();
        new Thread(() -> elric.bow(alphonse)).start();
    }
}

class Friend {
    private final String name;

    public Friend(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public synchronized void bow(Friend bower) {
        System.out.format("%s: %s" + "  has bowed to me!%n", this.name, bower.getName());
        bower.bowBack(this);
    }

    public synchronized void bowBack(Friend bower) {
        System.out.format("%s: %s" + " has bowed back to me!%n", this.name, bower.getName());
    }
}
