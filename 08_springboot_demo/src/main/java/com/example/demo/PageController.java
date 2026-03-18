package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // 注意这里不是 @RestController
public class PageController {

    @GetMapping("/page")
    public String page(Model model) {
        // 这里放一些要传给页面的数据
        model.addAttribute("title", "我的第一个 Thymeleaf 页面");
        model.addAttribute("message", "这是从后端传过来的内容，可以很复杂");

        // 返回视图名 "index" -> 会去找 templates/index.html
        return "index";
    }
}