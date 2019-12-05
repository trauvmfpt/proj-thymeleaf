package com.fpt.t1708e.photoplatform.service;

import com.fpt.t1708e.photoplatform.entity.OrderDetail;
import com.fpt.t1708e.photoplatform.entity.OrderProduct;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
public class MailService {
    @Autowired
    public JavaMailSender emailSender;
//    @Autowired
//    private SpringTemplateEngine templateEngine;
    @Autowired
    private ApplicationContext applicationContext;

    public void sendConfirmMail(String to, String subject,
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
            String html = templateEngine.process("customer/receipt", context);

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
