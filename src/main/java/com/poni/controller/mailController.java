package com.poni.controller;

/*
 *@author:PONI_CHAN
 *@date:2018/12/11 22:04
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class mailController {

    @RequestMapping("/mail")
    public String index() {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.qq.com");
        mailSender.setUsername("455705749@qq.com");
        mailSender.setPassword("auqhupohkxhrbhgh");

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("455705749@qq.com");
        message.setTo("419850688@qq.com");
        message.setSubject("单发邮件");
        message.setText("This is a test e-mail");
        mailSender.send(message);

        return "success";
    }
}
