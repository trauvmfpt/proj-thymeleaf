package com.fpt.t1708e.photoplatform.service;

import com.fpt.t1708e.photoplatform.entity.OrderDetail;
import com.fpt.t1708e.photoplatform.entity.OrderProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;

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
    private ApplicationContext applicationContext;

    public void sendMail(String to, String subject, String template,
                                OrderProduct orderProduct, List<OrderDetail> orderDetails, LocalDateTime createdAt) {
        try {
            SpringResourceTemplateResolver emailTemplateResolver = new SpringResourceTemplateResolver();
            emailTemplateResolver.setPrefix("classpath:/templates/");
            emailTemplateResolver.setSuffix(".html");
            emailTemplateResolver.setTemplateMode(TemplateMode.HTML);
            emailTemplateResolver.setApplicationContext(applicationContext);
            emailTemplateResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());

            SpringTemplateEngine templateEngine = new SpringTemplateEngine();
            templateEngine.addTemplateResolver(emailTemplateResolver);

            MimeMessage cfMail = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(cfMail,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            final Context context = new Context();
            context.setVariable("orderProduct", orderProduct);
            context.setVariable("orderDetails", orderDetails);
            context.setVariable("createdAt", createdAt);
            String html = templateEngine.process(template, context);

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
