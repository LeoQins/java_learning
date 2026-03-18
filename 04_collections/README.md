# 04 - 集合框架 (Collections)

## 学习目标

- 了解 Java 集合框架的基本概念。
- 掌握 `List` 接口及其常用实现类 `ArrayList` 的使用。
- 掌握 `Map` 接口及其常用实现类 `HashMap` 的使用。
- 学习如何对集合进行增、删、改、查和遍历操作。

## 核心知识点

1.  **集合框架 (Collections Framework)**:
    -   一个用于存储和操作对象组的统一架构。它包含接口、实现类和算法。
    -   主要接口包括 `List`, `Set`, `Queue`, `Map` 等。

2.  **`List` 接口**:
    -   一个有序的集合（也称为序列）。元素可以重复。
    -   可以通过索引（位置）来访问元素。
    -   **`ArrayList`**: `List` 的一个常用实现，基于动态数组。查询快，增删慢。

3.  **`Map` 接口**:
    -   一个存储键值对（key-value pairs）的对象。
    -   键（Key）是唯一的，不能重复。每个键映射到一个值（Value）。
    -   **`HashMap`**: `Map` 的一个常用实现，基于哈希表。它提供了高效的查找、添加和删除操作，但元素的顺序是不保证的。

4.  **泛型 (Generics)**:
    -   在集合中使用泛型（如 `List<String>` 或 `Map<String, Integer>`）可以在编译时提供类型安全。
    -   它告诉编译器这个集合只能存储特定类型的对象，避免了在运行时出现类型转换错误。

## 代码说明

-   `Main.java`: 调用 `ListExample` 和 `MapExample` 来运行示例。
-   `ListExample.java`:
    -   演示了如何创建 `ArrayList`。
    -   展示了 `add` (添加), `get` (获取), `set` (修改), `remove` (删除) 等基本操作。
    -   展示了如何使用增强 for 循环遍历 `List`。
-   `MapExample.java`:
    -   演示了如何创建 `HashMap`。
    -   展示了 `put` (添加/修改), `get` (获取), `remove` (删除) 等操作。
    -   展示了两种遍历 `Map` 的常用方法：遍历 `keySet` 和遍历 `entrySet`。

## 抽象类与普通类补充知识

虽然本章节主要讲 `List`、`Map` 这样的接口及其实现类，但在理解集合框架时，顺带理解“抽象类 vs 普通类”的概念会很有帮助。

### 1. 普通类 (Concrete Class)

- 使用方式：可以直接用 `new` 创建对象，例如：
  ```java
  Dog dog = new Dog("小黄");
  ```
- 特点：
  - 不能包含抽象方法，类中的方法都有具体实现（有方法体 `{}`）。
  - 可以直接被实例化，是“完整的蓝图”。

示例：
```java
public class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public void makeSound() {
        System.out.println("汪汪!");
    }

    public void eat() {
        System.out.println("狗正在吃东西...");
    }
}
```

### 2. 抽象类 (Abstract Class)

- 使用 `abstract` 关键字声明，**不能直接实例化**：
  ```java
  public abstract class Animal { ... }
  ```
- 可以包含：
  - 抽象方法：只有方法声明，没有方法体，以分号结尾。
  - 已实现的方法：和普通类一样有方法体，可以被子类直接复用。
- 作用：作为一类事物的“通用模板”，把共性的代码写在抽象类里，把个性的行为留给子类去实现。

示例：
```java
public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    // 抽象方法：没有方法体，子类必须实现
    public abstract void makeSound();

    // 具体方法：所有动物都可以直接使用
    public void eat() {
        System.out.println(this.name + " 正在吃东西...");
    }
}

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("喵喵!");
    }
}

// 使用示例
public class AnimalMain {
    public static void main(String[] args) {
        // Animal a = new Animal("test"); // 错误：不能实例化抽象类
        Animal cat = new Cat("咪咪");    // 通过子类来使用
        cat.eat();        // 调用抽象类中已实现的方法
        cat.makeSound();  // 调用子类中实现的抽象方法
    }
}
```

### 3. 抽象类和接口的关系小结

- 接口（如 `List`, `Map`）更偏向“行为规范”：只定义有哪些方法。
- 抽象类更偏向“通用实现”：既可以定义规范（抽象方法），也可以提供部分通用代码（具体方法）。
- 普通类：既可以实现接口，也可以继承抽象类，但最终必须把所有抽象方法都实现，才能被实例化使用。

## 如何运行

1.  打开终端并进入 `04_collections` 目录。
2.  编译所有 Java 文件:
    ```shell
    javac *.java
    ```
3.  运行 `Main` 类:
    ```shell
    java Main
    ```
4.  你将看到 `List` 和 `Map` 的各种操作演示。
