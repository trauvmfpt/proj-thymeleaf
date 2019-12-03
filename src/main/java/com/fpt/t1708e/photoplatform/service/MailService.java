package com.fpt.t1708e.photoplatform.service;

import com.fpt.t1708e.photoplatform.entity.OrderDetail;
import com.fpt.t1708e.photoplatform.entity.OrderProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MailService {
    @Autowired
    public JavaMailSender emailSender;
    @Autowired
    private SpringTemplateEngine templateEngine;

    public void sendConfirmMail(String to, String content, String subject,
                                OrderProduct orderProduct, List<OrderDetail> orderDetails, LocalDateTime createdAt) {
        try {
            MimeMessage cfMail = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(cfMail,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            Context context = new Context();
            context.setVariable("orderProduct", orderProduct);
            context.setVariable("orderDetails", orderDetails);
            context.setVariable("createdAt", createdAt);
            String html = templateEngine.process("customer/email-template", context);

            helper.setTo(to);
            helper.setText(html, true);
            helper.setSubject(subject);
            helper.setFrom("photoplatform0@gmail.com");

            emailSender.send(cfMail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
