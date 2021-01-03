import java.util.concurrent.Exchanger;

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
                exchanger.exchange("zxc");
                sleep(200);
                exchanger.exchange("no zxc");
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
                System.out.println(exchanger.exchange(null));
                System.out.println(exchanger.exchange(null));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
