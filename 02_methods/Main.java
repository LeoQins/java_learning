// Main.java - 方法（函数）学习入口

public class Main {
    public static void main(String[] args) {
        System.out.println("--- 方法示例 ---");
        
        // 调用无参数方法
        System.out.println("调用 printGreeting:");
        MethodExample.printGreeting();

        // 调用有参数方法
        System.out.println("\n调用 printPersonalizedGreeting:");
        MethodExample.printPersonalizedGreeting("Alice");

        // 调用有返回值的方法
        System.out.println("\n调用 add(int, int):");
        int result1 = MethodExample.add(5, 3);
        System.out.println("5 + 3 = " + result1);

        // 调用重载的 add 方法
        System.out.println("\n调用 add(double, double):");
        double result2 = MethodExample.add(2.5, 3.7);
        System.out.println("2.5 + 3.7 = " + result2);
    }
}
