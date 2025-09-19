package enums;

import lombok.Getter;

/**
 * @Author: wujiawang
 * @Date: 2025/9/12
 * @Version: 1.0
 */
@Getter
public enum ResultStatus {
    SUCCESS("发送成功"), FAIL("发送失败");
    private final String info;

    ResultStatus(String info) {
        this.info = info;
    }

}
