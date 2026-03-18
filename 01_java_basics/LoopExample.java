// LoopExample.java - 演示循环结构

public class LoopExample {
    public static void main(String[] args) {
        // for 循环: 打印 0 到 4
        System.out.println("--- for 循环 ---");
        for (int i = 0; i < 5; i++) {
            System.out.println("i = " + i);
        }

        // while 循环: 计数到 3
        System.out.println("\n--- while 循环 ---");
        int count = 1;
        while (count <= 3) {
            System.out.println("Count is: " + count);
            count++;
        }

        // do-while 循环: 至少执行一次
        System.out.println("\n--- do-while 循环 ---");
        int j = 5;
        do {
            System.out.println("j = " + j);
            j++;
        } while (j < 5); // 条件为false，但循环体仍然执行了一次

        // 增强 for 循环 (for-each): 遍历数组
        System.out.println("\n--- 增强 for 循环 ---");
        int[] numbers = {10, 20, 30, 40, 50};
        for (int number : numbers) {
            System.out.println("Number: " + number);
        }
    }
}
