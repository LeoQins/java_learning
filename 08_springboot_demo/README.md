# 08 - Spring Boot 基础

## 学习目标

- 了解 Spring Boot 是什么以及它的核心优势。
- 学习如何创建一个最简单的 Spring Boot "Hello, World" 应用。
- 理解 `@RestController` 和 `@GetMapping` 注解的作用。
- 能够运行 Spring Boot 应用并通过浏览器访问其端点（Endpoint）。
- 理解如何用 **Spring Boot + Thymeleaf（方案一）** 来构建稍复杂的网页界面。

## 核心知识点

1.  **Spring Boot**:
    -   一个基于 Spring 框架的开源 Java 框架，用于创建独立的、生产级的 Spring 应用程序。
    -   **核心优势**:
        -   **自动配置 (Auto-configuration)**: 自动配置应用程序所需的 Bean，极大简化了配置。
        -   **起步依赖 (Starter Dependencies)**: 提供了一系列 "starter" POMs，简化了 Maven/Gradle 的依赖管理。例如，`spring-boot-starter-web` 会自动包含构建 Web 应用所需的一切（如 Tomcat 服务器、Spring MVC 等）。
        -   **内嵌服务器**: 内置了 Tomcat, Jetty 或 Undertow，无需将应用部署到外部 Web 服务器。
        -   **无代码生成和 XML 配置**: 提倡使用注解和 Java 配置，而不是繁琐的 XML。

2.  **`@SpringBootApplication`**:
    -   一个复合注解，包含了 `@Configuration`, `@EnableAutoConfiguration`, 和 `@ComponentScan`。
    -   通常用在主类上，表示这是一个 Spring Boot 应用的入口。

3.  **`@RestController`**:
    -   一个用于 RESTful Web 服务的特殊控制器。
    -   它是 `@Controller` 和 `@ResponseBody` 的组合。
    -   `@ResponseBody` 告诉 Spring MVC，这个控制器处理的方法返回的对象应被自动序列化为 JSON 或 XML 并写入响应体。

4.  **`@GetMapping("/path")`**:
    -   一个用于处理 HTTP GET 请求的快捷注解。
    -   它等同于 `@RequestMapping(value = "/path", method = RequestMethod.GET)`。
    -   它将一个 URL 路径映射到一个控制器方法。

---

## 方案一：Spring Boot + Thymeleaf 构建网页

**用途**：在不搞前后端分离（Vue/React）的前提下，直接由 Spring Boot 渲染 HTML 模板，快速做出“有一定复杂度的页面”（表格、表单、布局等）。

### 1. 关键依赖

在 `pom.xml` 中使用 Spring Boot 2.7.x 时，典型依赖如下：

```xml
<dependencies>
    <!-- Web 应用（内嵌 Tomcat + Spring MVC） -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- 单元测试 -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>

    <!-- 方案一的核心：Thymeleaf 模板引擎，用于渲染 HTML 页面 -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
</dependencies>
```

> **Java 版本兼容注意**：
> - Spring Boot 2.7.x + Spring 5.3.x 最多支持到 **Java 17** 的 class 版本；
> - 即使本机安装了 JDK 21，也可以在 `pom.xml` 里把 `<java.version>` 设为 11 或 17，用 JDK 21 运行 —— 这是“老 class 在新 JDK 上运行”，是兼容的；
> - 不要在 Spring Boot 2.7.x 项目里把 `<java.version>` 设为 21，否则会出现类似 `Unsupported class file major version 65` 的错误。

### 2. 控制器：`@Controller` 返回页面视图

和 `@RestController` 返回 JSON 不同，**方案一中返回页面时应使用 `@Controller`**：

```java
package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // 注意：这里不是 @RestController
public class PageController {

    @GetMapping("/page")
    public String page(Model model) {
        // 向页面传递数据，在模板中通过 ${...} 使用
        model.addAttribute("title", "我的第一个 Thymeleaf 页面");
        model.addAttribute("message", "这是从后端传过来的内容，可以很复杂");

        // 返回视图名 "index"，对应 templates/index.html
        return "index";
    }
}
```

同时可以保留原来的 `HelloController`：

```java
// ...existing code...
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot!";
    }
}
```

这样：

- `GET /hello` 继续返回一个简单字符串（REST 风格接口）;
- `GET /page` 则返回一个由 Thymeleaf 渲染的 HTML 页面。

### 3. 模板目录与 `index.html`

Thymeleaf 默认会在 `src/main/resources/templates/` 目录下查找模板文件：

```text
src/
  main/
    resources/
      templates/
        index.html   # 与控制器中 return "index" 对应
```

一个简单但可以扩展的 `index.html` 示例：

```html
<!DOCTYPE html>
<html lang="zh-cn" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title th:text="${title}">默认标题</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; background: #f5f5f5; }
        .container { max-width: 800px; margin: 0 auto; background: #fff; padding: 20px; border-radius: 8px; }
        .header { border-bottom: 1px solid #eee; margin-bottom: 16px; }
        .card { border: 1px solid #ddd; padding: 16px; border-radius: 6px; margin-bottom: 12px; }
        .card-title { font-weight: bold; margin-bottom: 8px; }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <h1 th:text="${title}">标题占位</h1>
    </div>

    <div class="card">
        <div class="card-title">基本信息</div>
        <p th:text="${message}">这里是占位文本</p>
    </div>

    <div class="card">
        <div class="card-title">支持的功能示例</div>
        <ul>
            <li>可以写表格、表单、按钮、分页等复杂布局；</li>
            <li>可以引入 CSS 框架（Bootstrap、Tailwind 等）；</li>
            <li>可以在页面里用 JS 调用后端 REST 接口，动态更新内容。</li>
        </ul>
    </div>

    <div class="card">
        <div class="card-title">原有 /hello 接口</div>
        <p>这是原来的接口：<a href="/hello" target="_blank">/hello</a></p>
    </div>
</div>
</body>
</html>
```

**核心点**：

- `th:text="${title}"` 等表达式，使用的是控制器中 `Model` 里放入的数据；
- HTML 可以任意复杂，Thymeleaf 只是帮你把“后端数据 + 模板”拼成最终 HTML；
- 页面中依然可以引入外部 CSS/JS 文件，做更复杂的交互。

### 4. 访问路径

在应用启动成功后：

- `http://localhost:8080/hello`：返回简单字符串（REST 接口）；
- `http://localhost:8080/page`：返回由 Thymeleaf 渲染的 HTML 页面。

---

## 项目结构说明

Spring Boot 项目通常遵循标准的 Maven/Gradle 项目结构。

```text
springboot_demo/
├── pom.xml                 # Maven 配置文件，定义项目依赖和构建方式
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── example/
        │           └── demo/
        │               ├── DemoApplication.java    # Spring Boot 主启动类
        │               ├── HelloController.java    # 简单的 REST 控制器 (返回字符串/JSON)
        │               └── PageController.java     # 使用 Thymeleaf 返回 HTML 页面
        └── resources/
            └── templates/
                └── index.html                     # Thymeleaf 模板
```

- `pom.xml`: 这是运行此项目**必需**的文件。它告诉 Maven 如何构建项目，以及需要下载哪些 Spring Boot 相关的库（"起步依赖"）。
- `DemoApplication.java`: 包含 `main` 方法，是整个应用的启动点。
- `HelloController.java`: 定义了返回 JSON/字符串的 Web 接口逻辑。
- `PageController.java`: 定义了返回 HTML 页面的控制器。
- `index.html`: 一个使用 Thymeleaf 语法渲染的页面模板。

## 代码说明

-   `pom.xml`:
    -   `spring-boot-starter-parent`: 提供了有用的 Maven 默认值。
    -   `spring-boot-starter-web`: 添加了构建 Web 应用（包括 RESTful 应用）所需的一切，例如内嵌的 Tomcat 服务器和 Spring MVC。
    -   `spring-boot-starter-thymeleaf`: 提供服务端模板引擎，用于渲染 HTML 页面，是“方案一”的核心依赖之一。
    -   `spring-boot-maven-plugin`: 将应用打包成一个可执行的 JAR 文件，并支持 `mvn spring-boot:run` 直接启动。

-   `DemoApplication.java`:
    -   `@SpringBootApplication` 注解标记了主类。
    -   `SpringApplication.run()` 方法启动了整个应用。

-   `HelloController.java`:
    -   `@RestController` 标记这个类为一个 Web 控制器，返回值直接写入 HTTP 响应体（一般是 JSON/字符串）。
    -   `@GetMapping("/hello")` 将 `hello()` 方法映射到 `GET /hello` 请求。

-   `PageController.java`:
    -   `@Controller` 用于返回视图（模板页面），而不是直接返回 JSON。
    -   `Model` 用来向视图传递数据，在模板中通过 `${属性名}` 使用。
    -   返回的字符串（如 `"index"`）对应 `templates` 目录下的模板文件名（如 `index.html`）。

-   `index.html`:
    -   使用 Thymeleaf 标签（例如 `th:text`）将后端数据渲染到 HTML 中。
    -   可以根据需要添加 CSS 样式和 JavaScript，实现更复杂的页面效果。

---

## 如何运行

**重要提示**: 与之前的项目不同，Spring Boot 项目依赖于构建工具（如 Maven 或 Gradle）来下载依赖并运行。

### 方法一：使用 VS Code 的 Spring Boot 插件 (推荐)

1.  在 VS Code 中安装 [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-spring-boot) 扩展。
2.  打开 `springboot_demo` 文件夹。
3.  在 "SPRING-BOOT DASHBOARD" 视图中，你应该能看到 `demo` 应用。
4.  点击旁边的 "Run" (▶) 按钮来启动应用。
5.  等待 "OUTPUT" 或 "DEBUG CONSOLE" 窗口显示 "Tomcat started on port(s): 8080"。
6.  打开浏览器访问：
    - `http://localhost:8080/hello` 查看 REST 接口效果；
    - `http://localhost:8080/page` 查看 Thymeleaf 渲染的页面。

### 方法二：使用终端和 Maven

1.  确保你已经安装了 [Maven](https://maven.apache.org/download.cgi)。
2.  打开终端并进入 `08_springboot_demo` 目录。
3.  运行以下 Maven 命令来启动应用：
    ```shell
    mvn spring-boot:run
    ```
    Maven 会自动下载所有依赖并启动应用。
4.  等待日志显示应用已在 `8080` 端口启动。
5.  打开浏览器访问：
    - `http://localhost:8080/hello`
    - `http://localhost:8080/page`
6.  要停止应用，请返回终端并按 `Ctrl+C`。

---

## Maven 在 `mvn spring-boot:run` 中做了什么？

下面这段 README 中的步骤：

1. 确保你已经安装了 Maven。
2. 打开终端并进入 `08_springboot_demo` 目录。
3. 运行 `mvn spring-boot:run`。
4. 等待日志显示应用已在 `8080` 端口启动。
5. 打开浏览器访问 `http://localhost:8080/hello` 或 `http://localhost:8080/page`。
6. 按 `Ctrl + C` 停止应用。

背后其实发生了以下几件事：

### 1. 读取 `pom.xml`

当你在项目根目录（包含 `pom.xml` 的目录）执行：

```shell
mvn spring-boot:run
```

Maven 会：

- 找到当前目录下的 `pom.xml`；
- 解析其中定义的依赖（`<dependencies>`）、父 POM、插件（尤其是 `spring-boot-maven-plugin`）等配置。

### 2. 下载并管理依赖

根据 `pom.xml` 中的依赖声明（例如）：

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

Maven 会：

- 从远程仓库（通常是 Maven 中央仓库）下载对应的 JAR 包及其传递依赖（如 Spring MVC、Tomcat 等）；
- 缓存到本地仓库（Windows 上默认是 `C:\Users\你的用户名\.m2\repository`）；
- 下次再构建同一个项目时会优先使用本地缓存，而不是重新下载。

README 里那句“**Maven 会自动下载所有依赖并启动应用**”指的就是这一步。

### 3. 编译项目源码

在运行之前，Maven 会触发一个最小的构建流程，大致等价于：

- 编译 `src/main/java` 下的所有 Java 源文件；
- 把生成的 `.class` 文件放到 `target/classes` 目录中。

目录结构会类似：

```text
08_springboot_demo/
├── pom.xml
├── src/
└── target/
    └── classes/
        └── com/example/demo/
            ├── DemoApplication.class
            └── HelloController.class
```

如果你使用了 `PageController` 和 Thymeleaf 模板，对应的 `.class` 也会一起生成。

### 4. 调用 Spring Boot 插件的 `run`

`spring-boot:run` 实际上是调用 `spring-boot-maven-plugin` 插件的 `run` 目标，它会：

- 把 `target/classes` 和所有依赖的 JAR 组合成一个运行时类路径；
- 找到带有 `@SpringBootApplication` 的启动类（本项目中是 `DemoApplication`）；
- 等价于执行：

```shell
java -cp (依赖JAR + target/classes) com.example.demo.DemoApplication
```

也就是运行 `DemoApplication` 的 `main` 方法：

```java
SpringApplication.run(DemoApplication.class, args);
```

### 5. Spring Boot 启动内嵌 Tomcat

`SpringApplication.run` 内部会完成：

- 创建和启动 Spring 应用上下文（IoC 容器）；
- 根据 `spring-boot-starter-web` 自动配置 Web 相关组件；
- 启动内嵌的 Tomcat 服务器，默认监听 `8080` 端口；
- 扫描 `com.example.demo` 包，找到 `@RestController`（如 `HelloController`）以及其中的 `@GetMapping("/hello")` 方法，并建立 URL 到方法的映射；
- 同时也会扫描 `@Controller`（如 `PageController`），配置视图解析器以渲染 Thymeleaf 模板。

当日志中出现类似：

- `Tomcat started on port(s): 8080`
- `Started DemoApplication in ... seconds`

说明应用已经启动完成，正在监听 `http://localhost:8080`。

### 6. 处理浏览器请求 `/hello` 和 `/page`

- 当浏览器请求 `GET /hello` 时：
    - 请求会被分发到 `HelloController.hello()` 方法；
    - 返回的字符串直接写入响应体，浏览器显示纯文本 `Hello, Spring Boot!`。

- 当浏览器请求 `GET /page` 时：
    - 请求会被分发到 `PageController.page()` 方法；
    - 方法向 `Model` 填充数据，并返回视图名 `"index"`；
    - Spring Boot 使用 Thymeleaf 找到 `templates/index.html`，用 `Model` 中的数据进行渲染；
    - 最终生成的 HTML 返回给浏览器渲染显示。

通过这一套流程，**方案一（Spring Boot + Thymeleaf）就可以在同一个项目中同时提供 REST 接口和较为复杂的网页界面**。

