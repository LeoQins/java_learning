# 07 - Web 基础

## 学习目标

- 了解 HTTP 协议的基本概念（请求/响应）。
- 学习如何使用 Java 内置的 `com.sun.net.httpserver` 包来创建一个简单的 HTTP 服务器。
- 理解如何处理不同的 URL 路径（路由）。
- 能够从浏览器向自己编写的 Java 服务器发送请求并获得响应。

## 核心知识点

1.  **HTTP (HyperText Transfer Protocol)**:
    -   超文本传输协议，是 Web 上数据通信的基础。
    -   它是一个基于客户端-服务器模型的请求-响应协议。浏览器是客户端，服务器是存储和提供资源的机器。

2.  **`com.sun.net.httpserver`**:
    -   Java SE 6 及以上版本内置的一个轻量级 HTTP 服务器 API。
    -   它不适合用于生产环境的高性能服务器，但非常适合用于学习、测试和简单的内部工具。

3.  **`HttpServer`**:
    -   核心类，代表一个 HTTP 服务器。
    -   通过 `HttpServer.create(new InetSocketAddress(port), 0)` 创建实例。

4.  **`HttpHandler`**:
    -   一个接口，用于处理接收到的 HTTP 请求。
    -   你需要实现 `handle(HttpExchange exchange)` 方法，所有请求处理逻辑都在这里。

5.  **`HttpExchange`**:
    -   代表一次完整的 HTTP 请求和响应交换。
    -   通过它可以获取请求信息（如请求方法、URI 等）和发送响应。
    -   `sendResponseHeaders(statusCode, length)`: 发送响应头。
    -   `getResponseBody()`: 获取一个 `OutputStream`，用于写入响应体内容。

6.  **上下文 (Context)**:
    -   通过 `server.createContext(path, handler)` 可以将一个 URL 路径（如 `/hello`）与一个 `HttpHandler` 绑定。当服务器收到该路径的请求时，就会调用相应的处理器。

## 代码说明

-   `SimpleHttpServer.java`:
    -   `main` 方法是程序的入口。
    -   它创建了一个监听 `8080` 端口的 `HttpServer`。
    -   它创建了两个 `HttpHandler`：
        -   `RootHandler`: 处理根路径 `/` 的请求，返回一个简单的 HTML 页面。
        -   `HelloHandler`: 处理 `/hello` 路径的请求，返回一个纯文本 "Hello, World"。
    -   最后，它启动服务器并等待请求。

## 如何运行

1.  打开终端并进入 `07_web_basic` 目录。
2.  编译 Java 文件:
    ```shell
    javac SimpleHttpServer.java
    ```
3.  运行 `SimpleHttpServer` 类:
    ```shell
    java SimpleHttpServer
    ```
4.  终端会显示服务器已启动。
5.  打开你的网络浏览器（如 Chrome, Firefox），在地址栏输入以下任一地址并回车：
    -   `http://localhost:8080/`
    -   `http://localhost:8080/hello`
6.  你将看到浏览器页面上显示了服务器返回的内容。
7.  要停止服务器，请返回终端并按 `Ctrl+C`。
