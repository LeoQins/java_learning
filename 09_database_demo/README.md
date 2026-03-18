# 09 - 数据库 (MySQL)

## 学习目标

- 了解 JDBC (Java Database Connectivity) 的基本概念。
- 学习使用 JDBC 连接到 MySQL 数据库。
- 掌握使用 JDBC 执行基本的 SQL 操作：查询（SELECT）。
- 理解 `Connection`, `Statement`, `ResultSet` 等核心 JDBC 对象的作用。

## 核心知识点

1.  **JDBC (Java Database Connectivity)**:
    -   一套标准的 Java API，用于在 Java 程序和各种数据库（如 MySQL, PostgreSQL, Oracle 等）之间执行 SQL 命令。
    -   它提供了一系列接口和类，使得开发者可以用统一的方式与数据库交互，而不用关心底层数据库的具体实现。

2.  **JDBC 驱动 (JDBC Driver)**:
    -   一个实现了 JDBC API 的库，专门用于与特定类型的数据库通信。
    -   要连接 MySQL，你需要 MySQL 的 JDBC 驱动（例如 `mysql-connector-java`）。

3.  **JDBC 核心对象**:
    -   `DriverManager`: 用于管理一组 JDBC 驱动。它的 `getConnection()` 方法用于建立与数据库的连接。
    -   `Connection`: 代表与数据库的一个物理连接。
    -   `Statement`: 用于执行静态 SQL 语句并返回结果。
    -   `PreparedStatement`: `Statement` 的子接口，用于执行预编译的 SQL 语句，可以防止 SQL 注入，性能更好。
    -   `ResultSet`: 代表 SQL 查询的结果集。它维护一个指向其数据行的游标。

4.  **连接步骤**:
    1.  **加载驱动**: (在现代 JDBC 中，这一步通常是自动的)。
    2.  **建立连接**: 使用 `DriverManager.getConnection(url, user, password)`。
    3.  **创建 `Statement`**: `conn.createStatement()`。
    4.  **执行查询**: `stmt.executeQuery(sql)`。
    5.  **处理 `ResultSet`**: 使用 `while (rs.next()) { ... }` 遍历结果。
    6.  **关闭资源**: **非常重要！** 必须按 `ResultSet` -> `Statement` -> `Connection` 的顺序关闭资源，以避免资源泄露。`try-with-resources` 是最佳实践。

## 代码说明

-   `pom.xml`:
    -   这个文件是必需的，因为它定义了对 MySQL JDBC 驱动的依赖。Maven 会自动下载这个驱动。
-   `JdbcExample.java`:
    -   演示了连接到 MySQL 数据库并执行一个简单查询的完整流程。
    -   **请务必修改 `URL`, `USER`, `PASS` 常量为你自己的数据库配置。**
    -   代码中创建了一个 `users` 表（如果不存在），插入了一些数据，然后查询并打印了所有用户。
    -   使用了 `try-with-resources` 语句来自动管理和关闭 `Connection`, `Statement`, `ResultSet`，这是现代 JDBC 编程的推荐做法。

## 如何运行

### 准备工作

1.  **安装并运行 MySQL**: 确保你的电脑上已经安装了 MySQL 数据库并且正在运行。
2.  **创建一个数据库**: 在 MySQL 中创建一个数据库，例如命名为 `testdb`。
3.  **修改代码**: 打开 `JdbcExample.java` 文件，将 `URL`, `USER`, `PASS` 的值修改为你的 MySQL 配置。
    -   `URL`: `jdbc:mysql://localhost:3306/testdb` (将 `testdb` 换成你的数据库名)
    -   `USER`: 你的 MySQL 用户名 (如 `root`)
    -   `PASS`: 你的 MySQL 密码

### 运行程序

1.  打开终端并进入 `09_database_demo` 目录。
2.  使用 Maven 编译并执行代码。Maven 会负责下载 MySQL 驱动。
    ```shell
    mvn compile exec:java -Dexec.mainClass="JdbcExample"
    ```
3.  如果连接成功，你将在终端看到如下输出：
    -   表创建和数据插入的成功信息。
    -   从 `users` 表中查询到的用户数据。

**注意**: 这个例子是为了演示 JDBC 的基本用法。在实际项目（如 Spring Boot）中，通常会使用更高级的数据访问框架，如 Spring Data JPA 或 Mybatis，它们极大地简化了数据库操作。
