import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/*
looks like wait() notify() but with tables in restaurant
semaphore its cafe with tables
 */
public class Semaphores {
    public static void main(String[] args) {
        Semaphore table = new Semaphore(2);

        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Person person = new Person();
            person.table = table;
            personList.add(person);
        }
        personList.forEach(Thread::start);
    }
}

class Person extends Thread {
    Semaphore table;

    @Override
    public void run() {
        System.out.println(getName() + " waiting for table");
        try {
            table.acquire();
            System.out.println(getName() + " eating");
            sleep(500);
            System.out.println(getName() + " release table");
            table.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
