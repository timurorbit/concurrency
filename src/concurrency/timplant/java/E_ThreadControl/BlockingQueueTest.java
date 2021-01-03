package E_ThreadControl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
/*
Method take() gets the element
If there is no element, it blocks and waits for an element to become available
 */
public class BlockingQueueTest {
    public static void main(String[] args) {
    //    Queue<String> queue = new PriorityQueue<>();
        BlockingQueue<String> queue = new PriorityBlockingQueue<>();


        new Thread(() -> {
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> queue.add("This is string")).start();
    }
}
