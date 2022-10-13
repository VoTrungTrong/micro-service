package com.example.noticationservice.controller;

import com.example.noticationservice.dto.MessageDTO;
import com.example.noticationservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public void sendNotification(@RequestBody MessageDTO messageDTO) {
        this.emailService.sendEmail(messageDTO);
    }
}
