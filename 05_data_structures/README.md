# 05 - 数据结构与算法

## 学习目标

- 了解两种基本的数据结构：栈（Stack）和队列（Queue）。
- 掌握它们“后进先出”（LIFO）和“先进先出”（FIFO）的核心思想。
- 学习如何在 Java 中使用 `Stack` 类和 `Queue` 接口。

## 核心知识点

1.  **数据结构 (Data Structures)**:
    -   在计算机中组织和存储数据的方式。选择正确的数据结构可以提高算法的效率。

2.  **栈 (Stack)**:
    -   **LIFO (Last-In, First-Out)**: 最后进入的元素最先出来，就像一摞盘子。
    -   **主要操作**:
        -   `push`: 入栈，将元素添加到栈顶。
        -   `pop`: 出栈，移除并返回栈顶的元素。
        -   `peek`: 查看栈顶元素，但不移除。
    -   **Java 实现**: `java.util.Stack` 类。

3.  **队列 (Queue)**:
    -   **FIFO (First-In, First-Out)**: 最先进入的元素最先出来，就像排队买票。
    -   **主要操作**:
        -   `offer` / `add`: 入队，将元素添加到队尾。
        -   `poll` / `remove`: 出队，移除并返回队头的元素。
        -   `peek` / `element`: 查看队头元素，但不移除。
    -   **Java 实现**: `java.util.Queue` 是一个接口，通常使用 `java.util.LinkedList` 作为其实现类。

4.  **`offer` vs `add` / `poll` vs `remove` / `peek` vs `element`**:
    -   `add`, `remove`, `element`: 在操作失败时（如队列满或空）会抛出异常。
    -   `offer`, `poll`, `peek`: 在操作失败时会返回一个特殊值（`false` 或 `null`），而不会抛出异常。在大多数情况下，使用后者更安全。

## 代码说明

-   `Main.java`: 调用 `StackExample` 和 `QueueExample` 来运行示例。
-   `StackExample.java`:
    -   使用 `java.util.Stack` 类来模拟一个书堆。
    -   演示了 `push`, `pop`, `peek` 操作，展示了 LIFO 的特性。
-   `QueueExample.java`:
    -   使用 `LinkedList` 实现 `Queue` 接口，模拟顾客排队。
    -   演示了 `offer`, `poll`, `peek` 操作，展示了 FIFO 的特性。

## 如何运行

1.  打开终端并进入 `05_data_structures` 目录。
2.  编译所有 Java 文件:
    ```shell
    javac *.java
    ```
3.  运行 `Main` 类:
    ```shell
    java Main
    ```
4.  你将看到栈和队列的操作过程，直观地理解 LIFO 和 FIFO 的区别。
