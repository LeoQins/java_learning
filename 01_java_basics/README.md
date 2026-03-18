# 01 - Java 基础语法

## 学习目标

- 了解 Java 的基本数据类型和变量。
- 掌握 `if-else` 和 `switch` 条件控制语句。
- 掌握 `for`, `while`, `do-while` 循环结构。
- 能够编写并运行简单的 Java 程序。

## 核心知识点

1.  **变量与数据类型**:
    -   `int`: 整数
    -   `double`: 浮点数
    -   `char`: 字符
    -   `boolean`: 布尔值 (`true` 或 `false`)
    -   `String`: 字符串 (注意：它是一个类，不是基本数据类型)

2.  **条件语句**:
    -   `if (condition) { ... }`: 如果条件为真，执行代码块。
    -   `if (condition) { ... } else { ... }`: 根据条件二选一执行。
    -   `if ... else if ... else`: 多重条件判断。
    -   `switch (variable) { case value: ... break; default: ... }`: 基于变量值的多路分支。

3.  **循环结构**:
    -   `for (initialization; condition; update) { ... }`: 固定次数的循环。
    -   `while (condition) { ... }`: 当条件为真时重复执行。
    -   `do { ... } while (condition);`: 先执行一次，再判断条件。
    -   `for (type variable : array/collection) { ... }`: 增强 for 循环，用于遍历集合或数组。

## 代码说明

-   `Main.java`: 项目的入口，调用其他示例类来展示效果。
-   `VariablesExample.java`: 演示了 Java 中最常用的几种变量类型的声明和使用。
-   `IfElseExample.java`: 包含 `if-else` 和 `switch` 语句的用法，用于处理不同的逻辑分支。
-   `LoopExample.java`: 展示了 `for`, `while`, `do-while` 和增强 `for` 循环，用于重复执行代码。

## 如何运行

### 方法一：使用 VS Code 的 Code Runner 扩展

1.  在 VS Code 中安装 [Code Runner](https://marketplace.visualstudio.com/items?itemName=formulahendry.code-runner) 扩展。
2.  打开 `Main.java` 文件。
3.  点击右上角的 "Run Code" 按钮（一个三角形图标），或使用快捷键 `Ctrl+Alt+N`。
4.  你将在 "OUTPUT" 窗口看到所有示例的运行结果。

### 方法二：使用终端手动编译和运行

1.  打开终端 (在 VS Code 中可以通过 `Terminal` -> `New Terminal` 打开)。
2.  确保你位于 `01_java_basics` 目录下。
3.  编译所有 `.java` 文件：
    ```shell
    javac *.java
    ```
4.  运行 `Main` 类：
    ```shell
    java Main
    ```
5.  你将在终端看到程序的输出。
