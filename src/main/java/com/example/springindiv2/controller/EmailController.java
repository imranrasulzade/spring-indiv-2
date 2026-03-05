package com.example.springindiv2.controller;

import com.example.springindiv2.dto.Email;
import com.example.springindiv2.service.EmailSenderService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/emails")
@RestController
public class EmailController {

    private final EmailSenderService service;

    @PostMapping
    public void sendSimpleEmail(@RequestBody Email email) {
        log.info("Simple email send started.");
        service.sendSimpleEmail(email);
        log.info("Simple email send finished.");
    }

    @PostMapping("/attachment")
    public void sendAttachment(@RequestBody Email email) throws MessagingException {
        log.info("attachment email send started.");
        service.sendEmailWithAttachment(email);
        log.info("attachment email send finished.");
    }

    @PostMapping("/html")
    public void sendHtml(@RequestBody Email email) throws MessagingException {
        log.info("html email send started.");
        service.sendEmailWithTemplate(email);
        log.info("html email send finished.");
    }



}
