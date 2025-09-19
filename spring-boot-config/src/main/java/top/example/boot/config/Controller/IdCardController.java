package top.example.boot.config.Controller;

import cn.hutool.core.util.IdcardUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.example.boot.config.model.ApiResponse;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/hutool/idcard")
public class IdCardController {

    @GetMapping("/info")
    public ApiResponse<Map<String, String>> getIdCardInfo(@RequestParam String idCardNo) {
        // 验证身份证号是否合法
        if (!IdcardUtil.isValidCard(idCardNo)) {
            return ApiResponse.error("身份证号格式不合法");
        }

        Map<String, String> info = new HashMap<>();
        // 直接通过 IdcardUtil 静态方法提取信息
        info.put("birthday", IdcardUtil.getBirthByIdCard(idCardNo)); // 生日（yyyyMMdd格式）
        info.put("gender", String.valueOf(IdcardUtil.getGenderByIdCard(idCardNo))); // 性别（"男"或"女"）
        info.put("province", IdcardUtil.getProvinceByIdCard(idCardNo)); // 省份

        return ApiResponse.success("身份证信息提取成功", info);
    }
}


