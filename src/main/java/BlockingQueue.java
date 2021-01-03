import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class BlockingQueue {
    public static void main(String[] args) {
    //    Queue<String> queue = new PriorityQueue<>();
        Queue<String> queue = new PriorityBlockingQueue<>();

        new Thread(() -> System.out.println(queue.remove())).start();

        new Thread(() -> queue.add("This is string")).start();
    }
}
