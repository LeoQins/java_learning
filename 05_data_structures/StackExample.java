import java.util.Stack;

// StackExample.java - 演示栈 (Stack) 的使用
// 栈是一种后进先出 (LIFO - Last In, First Out) 的数据结构。
public class StackExample {
    public static void main(String[] args) {
        // Java 中 Stack 是一个类
        Stack<String> bookStack = new Stack<>();

        // 1. 入栈 (push)
        System.out.println("将书放入栈中...");
        bookStack.push("Java 编程思想");
        bookStack.push("Effective Java");
        bookStack.push("代码整洁之道");
        System.out.println("当前栈: " + bookStack);

        // 2. 查看栈顶元素 (peek)
        // peek 不会移除元素
        String topBook = bookStack.peek();
        System.out.println("栈顶的书是: " + topBook);
        System.out.println("执行 peek 后栈: " + bookStack);

        // 3. 出栈 (pop)
        // pop 会移除并返回栈顶元素
        String takenBook = bookStack.pop();
        System.out.println("取出的书是: " + takenBook);
        System.out.println("执行 pop 后栈: " + bookStack);

        // 4. 检查栈是否为空
        System.out.println("栈是否为空? " + bookStack.isEmpty());

        // 5. 全部出栈
        System.out.println("清空栈...");
        while (!bookStack.isEmpty()) {
            System.out.println("取出: " + bookStack.pop());
        }
        System.out.println("最终栈: " + bookStack);
        System.out.println("栈是否为空? " + bookStack.isEmpty());
    }
}
