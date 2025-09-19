package top.example.boot.config.Controller;

import cn.hutool.crypto.SecureUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.example.boot.config.model.ApiResponse;

/**
 * @Author: wujiawang
 * @Date: 2025/9/16
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/hutool/crypto")
public class CryptoController {
    @GetMapping("/md5")
    public ApiResponse<String> md5Encrypt(@RequestParam String content) {
        String md5 = SecureUtil.md5(content); // Hutool 加密工具
        return ApiResponse.success(md5);
    }
}