package com.example.noticationservice.service;

import com.example.noticationservice.dto.MessageDTO;

public interface EmailService {

    void sendEmail(MessageDTO messageDTO);

}
