// MethodExample.java - 演示方法的定义和调用

public class MethodExample {

    // 1. 无参数，无返回值的方法
    public static void printGreeting() {
        System.out.println("Hello, this is a method!");
    }

    // 2. 有参数，无返回值的方法
    public static void printPersonalizedGreeting(String name) {
        System.out.println("Hello, " + name + "!");
    }

    // 3. 有参数，有返回值的方法
    public static int add(int a, int b) {
        int sum = a + b;
        return sum; // 返回计算结果
    }

    // 4. 方法重载：方法名相同，但参数列表不同（类型、数量、顺序）
    public static double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        // 调用无参数方法
        System.out.println("调用 printGreeting:");
        printGreeting();

        // 调用有参数方法
        System.out.println("\n调用 printPersonalizedGreeting:");
        printPersonalizedGreeting("Alice");

        // 调用有返回值的方法
        System.out.println("\n调用 add(int, int):");
        int result1 = add(5, 3);
        System.out.println("5 + 3 = " + result1);

        // 调用重载的 add 方法
        System.out.println("\n调用 add(double, double):");
        double result2 = add(2.5, 3.7);
        System.out.println("2.5 + 3.7 = " + result2);
    }
}
