// Person.java - 定义一个基本的“人”类

public class Person {
    // 成员变量 (属性)
    // 使用 private 封装，只能通过类内部的方法访问
    private String name;
    private int age;

    // 构造方法：用于创建对象时初始化属性
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter 方法：用于获取属性值
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Setter 方法：用于设置属性值
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 0 && age < 150) { // 可以添加一些逻辑验证
            this.age = age;
        } else {
            System.out.println("年龄不合法！");
        }
    }

    // 成员方法 (行为)
    public void introduce() {
        System.out.println("大家好，我叫 " + name + "，今年 " + age + " 岁。");
    }
}
