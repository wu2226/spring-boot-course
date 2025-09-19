package top.example.boot.config.Controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.example.boot.config.model.ApiResponse;

@RestController
@RequestMapping("/api/hutool/captcha")
public class CaptchaController {

    @GetMapping("/generate")
    public ApiResponse<String> generateCaptcha(
            @RequestParam(required = false, defaultValue = "4") int length) {
        // 创建图形验证码（宽度100，高度40，验证码长度，干扰线数量）
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(100, 40, length, 5);
        // 获取验证码字符
        String code = captcha.getCode();
        return ApiResponse.success("验证码生成成功", code);
    }
}
