package top.example.boot.config.service;

import enums.ResultStatus;
import org.springframework.web.multipart.MultipartFile;
import top.example.boot.config.model.Mail;

/**
 * @Author: wujiawang
 * @Date: 2025/9/12
 * @Version: 1.0
 */
public interface MailService {
    /**
     * 发送简单邮件
     *
     * @param mail 邮件信息
     */
    ResultStatus sendSimpleMail(Mail mail);

    /**
     * 发送HTML邮件
     *
     * @param mail 邮件信息
     */
    ResultStatus sendHTMLMail(Mail mail);

    /**
     * 发送带附件的邮件
     *
     * @param mail 邮件信息
     * @param files 附件⽂件
     */
    ResultStatus sendAttachmentsMail(Mail mail, MultipartFile[] files);

}
