# 10 - 项目实战

## 学习目标

- 综合运用之前学到的 Java 知识（面向对象、集合、控制流、输入输出）来构建一个完整的应用程序。
- 学习如何将一个项目拆分为不同的类和职责（如模型、服务、视图）。
- 体验一个小型命令行应用的完整开发流程。

## 核心知识点

这是一个简单的命令行**用户管理系统**，它综合了前面章节的许多概念：

1.  **面向对象编程 (OOP)**:
    -   `User.java`: 这是一个**模型（Model）**类，用于封装用户的数据（id, username, password）。
    -   `UserService.java`: 这是一个**服务（Service）**类，负责处理核心的业务逻辑，如添加、删除、查找用户。它将数据操作与用户界面分离。
    -   `UserManager.java`: 这是一个**视图/控制器（View/Controller）**类，负责处理用户的输入输出，显示菜单，并将用户的请求委托给 `UserService` 来处理。

2.  **集合框架**:
    -   `UserService` 内部使用 `ArrayList<User>` 作为内存数据库来存储所有用户对象。

3.  **控制流**:
    -   `UserManager` 中的 `while` 循环保持程序持续运行，`switch` 语句根据用户输入执行不同的操作。

4.  **输入/输出 (I/O)**:
    -   使用 `java.util.Scanner` 类来读取用户从控制台的输入。
    -   使用 `System.out.println()` 将信息输出到控制台。

5.  **Java 8 Stream API (可选)**:
    -   在 `UserService` 中，使用了 `stream()`, `filter()`, `findFirst()` 等方法来简化用户的查找操作。这是一种更现代、更声明式的编程风格。
    -   `Optional<User>` 被用来优雅地处理可能找不到用户的情况，避免了返回 `null` 带来的 `NullPointerException` 风险。

## 代码说明

-   `Main.java`: 程序的唯一入口，它创建 `UserManager` 对象并启动系统。
-   `User.java`: 定义了 `User` 对象的结构，包含 id, username, password 等属性和相应的 getter/setter。
-   `UserService.java`: 封装了所有对 `userDatabase` 这个列表的操作。这是应用的核心逻辑所在。
-   `UserManager.java`: 负责与用户打交道。它显示菜单、接收用户输入，并调用 `UserService` 中相应的方法来完成任务，最后将结果展示给用户。

## 如何运行

1.  打开终端并进入 `10_final_project` 目录。
2.  编译所有 Java 文件:
    ```shell
    javac *.java
    ```
3.  运行 `Main` 类:
    ```shell
    java Main
    ```
4.  你将看到一个命令行菜单。
5.  根据提示输入数字（1, 2, 3, 4, 5, 0）来执行相应的操作，例如：
    -   输入 `1` 查看所有用户。
    -   输入 `2` 添加一个新用户，并按提示输入用户名和密码。
    -   输入 `0` 退出程序。

这个项目为你提供了一个将所有知识点整合在一起的实践机会。你可以尝试在此基础上进行扩展，例如：
- 将用户数据保存到文件（使用第6章的知识）。
- 将用户数据保存到数据库（使用第9章的知识）。
- 将其改造为一个 Spring Boot Web 应用（使用第8章的知识）。
