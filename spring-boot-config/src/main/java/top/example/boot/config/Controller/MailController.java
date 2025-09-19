package top.example.boot.config.Controller;

import enums.ResultStatus;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.example.boot.config.model.ApiResponse;
import top.example.boot.config.model.Mail;
import top.example.boot.config.service.MailService;

/**
 * @Author: wujiawang
 * @Date: 2025/9/12
 * @Version: 1.0
 */
@RestController
@RequestMapping("/mail")
public class MailController {
    @Resource
    private MailService mailService;
    /**
     * 发送简单邮件
     *
     * @param mail 邮件信息
     * @return 发送结果
     */
    @PostMapping("/simple")
    public ResponseEntity<ApiResponse<ResultStatus>> sendSimpleMail(@Valid @RequestBody Mail mail) {
        ResultStatus rs = mailService.sendSimpleMail(mail);
        if (rs == ResultStatus.SUCCESS) {
            return ResponseEntity.ok(ApiResponse.success("发送成功", rs));
        }
        // 业务失败建议返回 400（参数/业务错误），⽽不是 200
        return ResponseEntity.badRequest().body(ApiResponse.error("发送失败"));
    }

    /**
     * 发送HTML邮件
     *
     * @param mail 邮件信息
     * @return 邮件发送结果
     */
    @PostMapping("/html")
    public ResponseEntity<ApiResponse<ResultStatus>> sendHtmlMail(@Valid @RequestBody Mail mail) {
        ResultStatus rs = mailService.sendHTMLMail(mail);
        return rs == ResultStatus.SUCCESS ? ResponseEntity.ok(ApiResponse.success("发送成功", rs)) : ResponseEntity.badRequest().body(ApiResponse.error(
                "发送失败"));
    }

    /**
     * 发送带附件的邮件
     *
     * @param mail 邮件信息
     * @param files 附件⽂件
     * @return 邮件发送结果
     */
    @PostMapping(value = "/attachment", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<ResultStatus>> sendAttachmentsMail(@Valid @RequestPart("mail") Mail mail, @RequestPart("files") MultipartFile[] files) {
        ResultStatus rs = mailService.sendAttachmentsMail(mail, files);
        return rs == ResultStatus.SUCCESS ? ResponseEntity.ok(ApiResponse.success("发送成功", rs)) : ResponseEntity.badRequest().body(ApiResponse.error(
                "发送失败"));
    }



}
