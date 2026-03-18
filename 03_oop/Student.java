// Student.java - 继承自 Person 类的“学生”类

// 使用 extends 关键字实现继承
public class Student extends Person {
    
    // 子类特有的属性
    private String studentId;

    // 子类的构造方法
    // 必须调用父类的构造方法，使用 super()
    public Student(String name, int age, String studentId) {
        super(name, age); // 调用父类 Person 的构造方法
        this.studentId = studentId;
    }

    // 获取学号
    public String getStudentId() {
        return studentId;
    }

    // 子类特有的方法
    public void study() {
        System.out.println(getName() + " 正在学习 Java。"); // 可以调用父类的 public/protected 方法
    }

    // 方法重写 (Override): 子类提供了与父类相同签名的方法
    // @Override 注解可以帮助编译器检查重写是否正确
    @Override
    public void introduce() {
        // 使用 super 关键字可以调用父类被重写的方法
        // super.introduce(); 
        System.out.println("大家好，我是一名学生，我叫 " + getName() + "，学号是 " + studentId + "。");
    }
}
