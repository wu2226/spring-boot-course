package top.example.boot.week1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wujiawang
 * @Date: 2025/9/4
 * @Version: 1.0
 */
@RestController
public class HelloController {
    //读取“开关状态”和“关闭提示语“
    @Value("${my.feature.helloSwitch}")
    private boolean helloSwitch;

    @Value("${my.feature.closeMsg}")
    private String closeMessage;

    @GetMapping("/hello")
    public String hello() {
        if (helloSwitch) {
            return "接口开放中！欢迎访问我的第一个 spring boot 项目~";

        } else {
            return closeMessage;
        }
    }
}
