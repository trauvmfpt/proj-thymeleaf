package com.fpt.t1708e.photoplatform.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class MailUtil{
    @Autowired
    public JavaMailSender emailSender;

    public void sendConfirmMessage(String to, String text) {
        try {
            MimeMessage mail = emailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mail, true);
            messageHelper.setTo(to);
            messageHelper.setSubject("You have a new order to confirm!");
            messageHelper.setText(text, true);
            emailSender.send(mail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
