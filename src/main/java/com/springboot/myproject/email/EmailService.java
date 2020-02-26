package com.springboot.myproject.email;

import com.springboot.myproject.web.dto.EmailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {
    @Autowired
    JavaMailSender javaMailSender;

    public boolean sendEmail(EmailDto emailDto) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo("kls6221@naver.com");
            helper.setSubject(emailDto.getTitle());
            helper.setText(emailDto.getSender()+"\n"+emailDto.getContent());
            javaMailSender.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }

//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo("kls6221@naver.com"); // 수신자
//        message.setFrom(emailDto.getSender()); // 발신자
//        message.setSubject(emailDto.getTitle()); // 제목
//        message.setText(emailDto.getContent()); // 본문
//        try {
//            javaMailSender.send(message);
//            return true;
//        }catch (MailException me){
//            me.printStackTrace();
//            return false;
//        }
    }
}
