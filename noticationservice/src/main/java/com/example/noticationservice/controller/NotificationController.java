package com.example.noticationservice.controller;

import com.example.noticationservice.dto.MessageDTO;
import com.example.noticationservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    @Autowired
    private EmailService emailService;

    @GetMapping
    public String home(){
        return "Hello world";
    }

    @PostMapping
    public void sendNotification(@RequestBody MessageDTO messageDTO) {
        this.emailService.sendEmail(messageDTO);
    }
}
