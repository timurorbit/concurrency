package E_ThreadControl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/*
looks like wait() notify() but with tables in restaurant
semaphore its cafe with tables
Like we have cafe with 2 tables, and ppl 6 wanted to eat. If cafe is full, then other ppl should wait for table
 */
public class Semaphores {
    public static void main(String[] args) {
        Semaphore table = new Semaphore(2);

        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
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
            table.acquire();  // asks for free table
            System.out.println(getName() + " eating");
            sleep(500);
            System.out.println(getName() + " release table");
            table.release(); // release table
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
