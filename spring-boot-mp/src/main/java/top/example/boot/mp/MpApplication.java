package top.example.boot.mp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: wujiawang
 * @Date: 2025/9/18
 * @Version: 1.0
 */
@SpringBootApplication
@MapperScan("top.example.boot.mp.mapper")
public class MpApplication {
    public static void main(String[] args) {
        SpringApplication.run(MpApplication.class, args);
    }
}