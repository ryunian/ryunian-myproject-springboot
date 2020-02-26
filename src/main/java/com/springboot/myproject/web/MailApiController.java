package com.springboot.myproject.web;

import com.springboot.myproject.email.EmailService;
import com.springboot.myproject.web.dto.EmailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailApiController {
    @Autowired
    EmailService emailService;

    @PostMapping("/api/mail")
    public boolean mail(@RequestBody EmailDto emailDto){
        return emailService.sendEmail(emailDto);
    }
}
