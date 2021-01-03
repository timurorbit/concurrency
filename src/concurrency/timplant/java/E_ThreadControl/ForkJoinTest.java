package E_ThreadControl;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/*
 For starting tasks recursively, use ForkJoinPool
 */
public class ForkJoinTest {

    static long numOfOperations = 1_000_000_000L;

    static int numOfCores = Runtime.getRuntime().availableProcessors();
    
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long j = 0;
//        for (long i = 0; i < numOfOperations; i++) {     // it will take 740ms
//            j += i;
//        }
        ForkJoinPool pool = new ForkJoinPool();
        j = pool.invoke(new MyFork(0, numOfOperations));   // it will take 270ms (less with more cores)


        System.out.println((System.currentTimeMillis() - startTime));
        System.out.println(j);
    }

    static class MyFork extends RecursiveTask<Long> {
        long from, to;

        public MyFork(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if (to - from <= numOfOperations/numOfCores) {
                long j = 0;
                for (long i = from; i < to; i++) {
                    j += i;
                }
                return j;
            } else {
              long mid = (to + from)/2;
              MyFork firstHalf = new MyFork(from, mid);
              firstHalf.fork();
              MyFork secondHalf = new MyFork(mid, to);
              long secondValue = secondHalf.compute();
              return firstHalf.join() + secondValue;
            }
        }
    }
}
