package top.example.boot.config.Controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.example.boot.config.model.ApiResponse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author: wujiawang
 * @Date: 2025/9/17
 * @Version: 1.0
 */
@RestController
@RequestMapping("/api/hutool/coll")
public class CollUtilController {

    /**
     * 计算两个列表的交集
     */@GetMapping("/intersection")
    public ApiResponse<List<String>> listIntersection(
            @RequestParam String list1,  // 格式：a,b,c
            @RequestParam String list2) { // 格式：b,c,d
        try {
            // 注意：分割字符串应该使用StrUtil.split()而不是CollUtil.split()
            List<String> coll1 = StrUtil.split(list1, ",");
            List<String> coll2 = StrUtil.split(list2, ",");

            // 计算交集（返回Collection类型）
            Collection<String> intersectionColl = CollUtil.intersection(coll1, coll2);

            // 转换为List<String>
            List<String> intersection = new ArrayList<>(intersectionColl);

            return ApiResponse.success("交集计算成功", intersection);
        } catch (Exception e) {
            return ApiResponse.error("集合操作失败：" + e.getMessage());
        }
    }
}

