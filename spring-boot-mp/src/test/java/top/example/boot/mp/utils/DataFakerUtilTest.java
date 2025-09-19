package top.example.boot.mp.utils;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DataFakerUtilTest {
    @Resource
    private DataFakerUtil dataFakerUtil;

    @Test
    void generateBatch() {
        dataFakerUtil.generateBatch();
    }
}