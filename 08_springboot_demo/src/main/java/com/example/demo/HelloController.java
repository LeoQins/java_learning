package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController 注解表示这是一个处理 RESTful 请求的控制器
// 它会自动将返回的对象转换为 JSON 格式
@RestController
public class HelloController {

    // @GetMapping("/hello") 将这个方法映射到 HTTP GET 请求的 "/hello" 路径
    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot!";
    }
}
