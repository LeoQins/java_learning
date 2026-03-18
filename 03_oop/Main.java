// Main.java - 面向对象学习入口

public class Main {
    public static void main(String[] args) {
        // 1. 创建 Person 对象
        System.out.println("--- 创建 Person 对象 ---");
        Person person1 = new Person("张三", 30);
        person1.introduce(); // 调用对象的方法

        // 2. 创建 Student 对象 (继承自 Person)
        System.out.println("\n--- 创建 Student 对象 ---");
        Student student1 = new Student("李四", 18, "S001");
        student1.introduce(); // 调用了被子类重写的方法
        student1.study();     // 调用子类特有的方法
    }
}
