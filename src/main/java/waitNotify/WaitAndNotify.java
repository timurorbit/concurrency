package waitNotify;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WaitAndNotify {

    static List<String> strings = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
             new Thread(new Operator()).start();
             new Thread(new Machine()).start();
    }

    static class Operator implements Runnable {

        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                synchronized (strings) {
                    strings.add(scanner.nextLine());
                    strings.notify();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Machine implements Runnable {

        @Override
        public void run() {
          while (strings.isEmpty()) {
              synchronized (strings) {
                  try {
                      strings.wait();
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  System.out.println(strings.remove(0));
              }
          }
        }
    }
}
