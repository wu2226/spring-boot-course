package top.example.boot.config.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @Author: wujiawang
 * @Date: 2025/9/12
 * @Version: 1.0
 */
@Data
public class Mail {
    @NotBlank
    @Email
    private String to;
    @NotBlank
    private String subject;

    @NotBlank
    private String content;
}

