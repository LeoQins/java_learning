import java.util.LinkedList;
import java.util.Queue;

// QueueExample.java - 演示队列 (Queue) 的使用
// 队列是一种先进先出 (FIFO - First In, First Out) 的数据结构。
public class QueueExample {
    public static void main(String[] args) {
        // Queue 是一个接口，通常使用 LinkedList 作为其实现
        Queue<String> customerQueue = new LinkedList<>();

        // 1. 入队 (add 或 offer)
        // add 在队列满时会抛出异常，offer 返回 false
        System.out.println("顾客开始排队...");
        customerQueue.offer("顾客A");
        customerQueue.offer("顾客B");
        customerQueue.offer("顾客C");
        System.out.println("当前队列: " + customerQueue);

        // 2. 查看队头元素 (element 或 peek)
        // element 在队列为空时抛出异常，peek 返回 null
        String headCustomer = customerQueue.peek();
        System.out.println("队头的顾客是: " + headCustomer);
        System.out.println("执行 peek 后队列: " + customerQueue);

        // 3. 出队 (remove 或 poll)
        // remove 在队列为空时抛出异常，poll 返回 null
        String servedCustomer = customerQueue.poll();
        System.out.println("服务的顾客是: " + servedCustomer);
        System.out.println("执行 poll 后队列: " + customerQueue);

        // 4. 检查队列是否为空
        System.out.println("队列是否为空? " + customerQueue.isEmpty());

        // 5. 全部出队
        System.out.println("服务所有顾客...");
        while (!customerQueue.isEmpty()) {
            System.out.println("服务: " + customerQueue.poll());
        }
        System.out.println("最终队列: " + customerQueue);
        System.out.println("队列是否为空? " + customerQueue.isEmpty());
    }
}
