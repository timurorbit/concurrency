package D_Executors;

import java.util.concurrent.*;
/*
 Starting tasks with delay (in this example, with 3 second delay)
 */
public class ScheduledExecutorExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(new MyRunnable(), 3, TimeUnit.SECONDS);
        executorService.shutdown();
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println(1);
        }
    }

    static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "zxc";
        }
    }
}
