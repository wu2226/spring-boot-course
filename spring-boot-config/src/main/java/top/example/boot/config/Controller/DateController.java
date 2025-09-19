package top.example.boot.config.Controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
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
@RequestMapping("/api/hutool/date")
public class DateController {
    @GetMapping("/format")
    public ApiResponse<String> formatDate(
            @RequestParam String dateStr,
            @RequestParam(required = false, defaultValue = "yyyy-MM-dd HH:mm:ss") String pattern) {
        DateTime dateTime = DateUtil.parse(dateStr); // Hutool 日期解析
        String formatted = DateUtil.format(dateTime, pattern); // Hutool 日期格式化
        return ApiResponse.success(formatted); // 统一响应格式
    }
}
