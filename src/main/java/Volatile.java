public class Volatile {
    /*
    Do not cache variable, which means write always to memory.
    Without volatile keyword localVar will always be 1
    all threads will use the same i
     */
    volatile static int i = 0;

    public static void main(String[] args) {
        new MyThreadRead().start();
        new MyThreadWrite().start();
    }

    static class MyThreadWrite extends Thread {
        @Override
        public void run() {
            while (i < 5) {
                System.out.println("increment i to " + (++i));
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class MyThreadRead extends Thread {
        @Override
        public void run() {
            int localVar = i;
            while (localVar < 5) {
                if (localVar != i) {
                    System.out.println("new value of i is" + i);
                    localVar = i;
                }
            }
        }
    }
}
