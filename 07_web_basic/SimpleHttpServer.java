import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

// SimpleHttpServer.java - 使用Java内置库创建一个简单的HTTP服务器
// 这个例子不需要任何外部依赖。
public class SimpleHttpServer {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        
        // 创建一个HttpServer实例，监听指定端口
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        // 创建一个上下文，将"/hello"路径映射到一个处理器
        server.createContext("/hello", new HelloHandler());
        
        // 创建默认的根路径处理器
        server.createContext("/", new RootHandler());

        // 设置服务器的执行器（使用默认的线程池）
        server.setExecutor(null); 

        // 启动服务器
        server.start();

        System.out.println("服务器已启动，正在监听端口 " + port);
        System.out.println("请在浏览器中访问: http://localhost:8080/ 或 http://localhost:8080/hello");
    }

    // 根路径 ("/") 的处理器
    static class RootHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "<h1>欢迎来到Java Web基础</h1><p>这是一个简单的HTTP服务器。</p><p>尝试访问 <a href=\"/hello\">/hello</a> 路径。</p>";
            
            // 设置响应头
            exchange.sendResponseHeaders(200, response.getBytes().length);
            
            // 获取输出流并写入响应
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    // "/hello" 路径的处理器
    static class HelloHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "Hello, World from Java HTTP Server!";
            
            // 设置响应头：状态码200表示成功，并设置响应体长度
            exchange.sendResponseHeaders(200, response.getBytes().length);
            
            // 获取输出流
            OutputStream os = exchange.getResponseBody();
            
            // 将响应内容写入输出流
            os.write(response.getBytes());
            
            // 关闭输出流
            os.close();
        }
    }
}
