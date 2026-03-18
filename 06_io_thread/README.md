# 06 - IO 与多线程

## 学习目标

- 了解 Java I/O (输入/输出) 的基本概念。
- 掌握使用 `FileReader`/`FileWriter` 和 `BufferedReader`/`BufferedWriter` 进行基本的文件读写。
- 理解什么是线程和进程，以及多线程的优势。
- 掌握在 Java 中创建和启动线程的两种主要方式。

## 核心知识点

1.  **Java I/O (Input/Output)**:
    -   I/O 是指程序与外部世界（如文件、网络、控制台）之间的数据交换。
    -   **流 (Stream)**: Java I/O 的核心概念，数据像水流一样单向流动。分为字节流（`InputStream`/`OutputStream`）和字符流（`Reader`/`Writer`）。
    -   **缓冲流**: `BufferedReader` 和 `BufferedWriter` 提供了缓冲功能，可以一次读写一块数据，而不是一个字符，从而提高效率。
    -   **try-with-resources**: `try (ResourceType resource = ...)` 语法可以自动关闭实现了 `AutoCloseable` 接口的资源（如流），是处理 I/O 资源的推荐方式。

2.  **多线程 (Multithreading)**:
    -   **进程 (Process)**: 操作系统中一个正在运行的程序实例。
    -   **线程 (Thread)**: 进程中的一个执行单元。一个进程可以包含多个线程，它们共享进程的内存空间。
    -   **优势**: 可以执行并发任务，提高程序响应速度和资源利用率（尤其是在多核 CPU 上）。

3.  **创建线程的方式**:
    -   **继承 `Thread` 类**:
        -   创建一个类继承 `java.lang.Thread`。
        -   重写 `run()` 方法，将线程要执行的代码放在其中。
        -   创建该类的实例，并调用 `start()` 方法来启动线程。
    -   **实现 `Runnable` 接口**:
        -   创建一个类实现 `java.lang.Runnable` 接口。
        -   实现 `run()` 方法。
        -   创建该类的实例，并将其作为参数传递给 `Thread` 类的构造函数，然后调用 `start()` 方法。
    -   **推荐使用 `Runnable`**: 因为 Java 是单继承的，实现接口更加灵活。它将任务（`Runnable`）与执行机制（`Thread`）解耦。

## 代码说明

-   `Main.java`: 依次调用文件操作和多线程的示例。
-   `FileReadWriteExample.java`:
    -   演示了如何使用 `BufferedWriter` 向文件写入文本。
    -   演示了如何使用 `BufferedReader` 从文件中逐行读取文本。
    -   使用了 `try-with-resources` 语句来确保文件流被正确关闭。
-   `ThreadExample.java`:
    -   `MyThread`: 通过继承 `Thread` 类创建线程。
    -   `MyRunnable`: 通过实现 `Runnable` 接口创建线程。
    -   `main` 方法中展示了如何启动这两种线程，并额外提供了一个使用 Lambda 表达式的简洁写法（Java 8+）。

## 如何运行

1.  打开终端并进入 `06_io_thread` 目录。
2.  编译所有 Java 文件:
    ```shell
    javac *.java
    ```
3.  运行 `Main` 类:
    ```shell
    java Main
    ```
4.  你将看到文件被创建、写入、读取和删除的过程。接着，你会看到多个线程的输出交织在一起，这表明它们是并发执行的。

# 06 IO 与多线程示例

本目录包含 Java 中 IO 操作与多线程的简单示例。

## 文件 IO 示例

- `FileReadWriteExample.java`：演示如何读写文本文件。

### 关于 `static final` 常量 FILE_NAME

在 `FileReadWriteExample.java` 中有这样一行：

```java
private static final String FILE_NAME = "sample.txt";
```

可以拆开理解：

- `String`：类型，表示这是一个字符串。
- `FILE_NAME`：变量名，表示“文件名”，后面代码里统一用它来指代要操作的那个文件。
- `final`：说明这是一个**常量**，只能赋值一次，不能再修改。
- `static`：说明这是一个**类级别**的变量，属于类本身，而不是某个对象。

#### FILE_NAME 是“类的属性”还是“对象的属性”？

有了 `static` 之后，`FILE_NAME` 是一个**静态字段（类属性 / 类变量）**：

- 它属于整个类 `FileReadWriteExample`，而不是某一个具体对象。
- 理论上可以通过类名访问（如果是 `public`）：`FileReadWriteExample.FILE_NAME`。
- JVM 只为这个字段保留一份内存，所有使用它的代码共享这一份值。

如果去掉 `static`：

```java
private final String fileName = "sample.txt";
```

这时 `fileName` 就变成了**实例字段（对象属性 / 实例变量）**：

- 每创建一个 `new FileReadWriteExample()`，这个对象内部都会有自己的一份 `fileName`。
- 必须先创建对象，才能通过 `ex.fileName` 访问：

```java
public static void main(String[] args) {
    FileReadWriteExample ex = new FileReadWriteExample();
    System.out.println(ex.fileName); // 对象的属性
}
```

而当前代码中，`FILE_NAME` 需要在 `static main` 方法里直接使用：

```java
public static void main(String[] args) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
        // ... 写入内容
    }
    // ... 读取文件、删除文件同样使用 FILE_NAME
}
```

因此把它设计成：

```java
private static final String FILE_NAME = "sample.txt";
```

表达的含义就是：

- 这是一个**类级别的静态常量（类属性）**。
- 所有使用 `FileReadWriteExample` 的代码都共享同一个文件名配置。
- 不能被修改（`final`），也不会因为创建多个对象而出现多份副本。

这种“`static final` + 全大写命名”的写法，是 Java 中定义常量的标准习惯用法。

## 多线程示例

- `ThreadExample.java`：演示创建和启动多线程的三种方式：
  1. 继承 `Thread` 类
  2. 实现 `Runnable` 接口
  3. 使用 **Lambda 表达式**（Java 8+）

### 什么是 Lambda 表达式？

在 `ThreadExample.java` 中有如下代码：

```java
Thread thread3 = new Thread(() -> {
    for (int i = 0; i < 3; i++) {
        System.out.println("Lambda 表达式线程正在运行: " + i);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
});
thread3.start();
```

这里的 `() -> { ... }` 就是一个 **Lambda 表达式**，可以理解为：

- 它是对接口中“唯一一个抽象方法”的实现（即函数式接口）。
- 在这里，`new Thread(...)` 构造方法需要的是 `Runnable` 接口对象，而 `Runnable` 只有一个抽象方法 `void run()`，所以 `() -> { ... }` 就表示这个 `run()` 方法的实现。

上述 Lambda 写法等价于下面的匿名内部类写法：

```java
Thread thread3 = new Thread(new Runnable() {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Lambda 表达式线程正在运行: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
});
thread3.start();
```

对比可以看到：

- Lambda 省掉了 `new Runnable() { public void run() { ... } }` 这层样板代码，语法更简洁。
- 只要目标类型是一个“函数式接口”（只有一个抽象方法），就可以用 Lambda 表达式来写，例如 `Runnable`、`Callable`、`Comparator` 等。

### 小结

在多线程中：

- 使用 `new Thread(new MyRunnable()).start();` 是“实现 `Runnable` 接口”的传统写法。
- 使用 `new Thread(() -> { /* 线程要执行的代码 */ }).start();` 是 Java 8 引入的 Lambda 写法，本质一样，但更简洁，在实际开发中非常常见。
