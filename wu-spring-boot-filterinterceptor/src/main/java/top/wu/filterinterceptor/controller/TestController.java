package top.wu.filterinterceptor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import top.wu.filterinterceptor.result.Result;

@RestController
@RequestMapping("/api")
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/test/filter")
    public Result<String> testFilter(@RequestParam String name) {
        return Result.ok("Hello, " + name);
    }

    @GetMapping("/pay/{id}")
    public Result<String> pay(@PathVariable long id) {
        log.info("开始支付");
        return Result.ok("支付成功，订单号：" + id);
    }
}
