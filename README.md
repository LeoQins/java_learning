# Java 学习路线项目（java_learning）

本仓库是一个循序渐进的 Java 学习示例项目，从基础语法、面向对象，到集合、IO 与多线程、Web、Spring Boot、数据库，再到综合小项目，帮助你完整搭建 Java 开发的知识框架。

## 目录总览

每个子目录对应一个知识章节，内部包含示例代码和更详细的章节 README 说明。

1. `01_java_basics` —— Java 基础语法：变量与数据类型、条件语句、循环结构。
2. `02_methods` —— 方法（函数）：定义与调用、参数与返回值、方法重载。
3. `03_oop` —— 面向对象编程：类与对象、封装、继承、构造方法、方法重写。
4. `04_collections` —— 集合框架：List / Map、ArrayList / HashMap、泛型及遍历操作。
5. `05_data_structures` —— 数据结构：栈（Stack）与队列（Queue），LIFO / FIFO 思想。
6. `06_io_thread` —— IO 与多线程：文件读写、缓冲流、线程创建与启动、Runnable 与 Lambda。
7. `07_web_basic` —— Web 基础：内置 HttpServer，处理 / 与 /hello 等基本路由。
8. `08_springboot_demo` —— Spring Boot 基础：REST 接口、Thymeleaf 页面、Maven 构建与运行。
9. `09_database_demo` —— 数据库（MySQL & JDBC）：连接数据库、执行 SQL、处理 ResultSet。
10. `10_final_project` —— 综合项目：命令行用户管理系统，整合 OOP、集合、控制流、I/O 等。

建议按数字顺序逐个文件夹学习，每个文件夹下已有更详细的中文说明文档（README）。

## 环境准备

- **JDK**：建议安装 JDK 11～17 版本（本仓库所有示例在该范围内均可运行）。
- **IDE / 编辑器**：推荐 VS Code + Java 扩展包，或 IntelliJ IDEA / Eclipse。
- **构建工具**：部分章节（如 `08_springboot_demo`, `09_database_demo`）需要 Maven。

## 示例运行速览

下面给出几个常见章节的运行方式（在终端中执行）。更多细节可查看对应子目录 README。

### 1. 普通 Java 示例（如 01～07、10）

以 `01_java_basics` 为例：

```shell
cd 01_java_basics
javac *.java
java Main
```

其他不依赖 Maven 的章节类似：进入对应目录后，`javac *.java`，再 `java Main` 或指定的主类。

### 2. Spring Boot 示例（`08_springboot_demo`）

```shell
cd 08_springboot_demo
mvn spring-boot:run
```

启动后在浏览器访问：

- `http://localhost:8080/hello` —— REST 文本接口。
- `http://localhost:8080/page` —— Thymeleaf 渲染页面。

### 3. JDBC + MySQL 示例（`09_database_demo`）

> 运行前请确保本机已安装并启动 MySQL，且在 `JdbcExample.java` 中配置了正确的 URL / 用户名 / 密码。

```shell
cd 09_database_demo
mvn compile exec:java -Dexec.mainClass="JdbcExample"
```

程序会演示创建表、插入数据并查询输出的完整流程。

## 学习建议

- **由浅入深**：建议从 `01_java_basics` 顺序学习到 `10_final_project`，每一章都依赖前面章节的部分知识点。
- **多动手改代码**：尝试修改示例中的变量、条件、循环次数、集合内容等，观察程序行为变化。
- **做小练习**：在每一章的基础上增加小功能，例如：
  - 为 OOP 章节增加新的子类和方法；
  - 在集合章节中练习更多遍历与查找逻辑；
  - 给最终项目增加“持久化到文件或数据库”的功能。

## 许可与用途

本仓库主要用于个人学习与教学示例，你可以自由克隆、修改和扩展代码，用于自学或课堂演示。
