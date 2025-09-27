package top.example.boot.redis;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wujiawang
 * @Date: 2025/9/25
 * @Version: 1.0
 */
@SpringBootTest
public class TestRedis {
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void testRedis(){
        redisTemplate.opsForValue().set("name", "张三", 20, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set("age", "28",20, TimeUnit.SECONDS);

    }
}
