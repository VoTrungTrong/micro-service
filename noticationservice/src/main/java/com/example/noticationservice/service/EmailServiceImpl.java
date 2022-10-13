package com.example.noticationservice.service;

import com.example.noticationservice.dto.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    @Override
    public void sendEmail(MessageDTO messageDTO) {
        try {
            log.info("Start... Sending email");

            MimeMessage message = this.javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, StandardCharsets.UTF_8.name());

            // Load template email with content
            Context context = new Context();
            context.setVariable("name", messageDTO.getTo());
            context.setVariable("content", messageDTO.getContent());
            String html = this.templateEngine.process("welcome-email", context);

            // Send email
            helper.setTo(messageDTO.getTo());
            helper.setText(html, true);
            helper.setSubject(messageDTO.getSubject());
            helper.setFrom(messageDTO.getFrom());
            this.javaMailSender.send(message);
            log.info("End... Email sent success");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
