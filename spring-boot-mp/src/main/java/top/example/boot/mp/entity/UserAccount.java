package top.example.boot.mp.entity;

/**
 * @Author: wujiawang
 * @Date: 2025/9/18
 * @Version: 1.0
 */
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Accessors
@TableName("user_account")
@Data
public class UserAccount implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Long id;
    @NotBlank(message = "用户名不能为空")
    @Size(max = 50, message = "用户名长度不能超过50个字符")
    private String username;
    @NotBlank(message = "密码不能为空")
    @Size(max = 255, message = "密码长度不能超过50个字符")
    private String password;

    @Size(max = 50, message = "昵称长度不能超过50个字符")
    private String nickname;
    @Email(message = "邮箱格式不正确")
    @Size(max = 100, message = "邮箱长度不能超过100个字符")
    private String email;
    @Size(max = 20, message = "手机号长度不能超过20个字符")
    private String phone;
    @Size(max = 255, message = "头像URL长度不能超过255个字符")
    private String avatarUrl;
    @TableField("status")
    @Max(value = 1)
    @Min(value = 0)
    private Integer status;
    @TableLogic(value = "0", delval = "1")
    private Integer deleted;
    @Version
    private Integer version;
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;
}
