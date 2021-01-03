package E_ThreadControl;

import java.util.concurrent.Exchanger;
/*
 share objects between threads with Exchanger
 exchange waits for the other thread in the pair to call it as well
 */
public class ExchangerTest {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Timur(exchanger);
        new Ghoul(exchanger);
    }

    static class Timur extends Thread {
        Exchanger<String> exchanger;

        public Timur(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run() {
            try {
                System.out.println(exchanger.exchange("zxc"));
                sleep(200);
                System.out.println(exchanger.exchange("no zxc"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Ghoul extends Thread {
        Exchanger<String> exchanger;

        public Ghoul(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run() {
            try {
                System.out.println(exchanger.exchange("1"));
                System.out.println(exchanger.exchange("2"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
