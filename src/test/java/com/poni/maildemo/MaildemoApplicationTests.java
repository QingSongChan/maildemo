package com.poni.maildemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaildemoApplicationTests {

    @Autowired
    private MailSender mailSender;

    @Test
    public void sendMail()throws Exception{
        SimpleMailMessage helper = new SimpleMailMessage();
        helper.setFrom("455705749@qq.com");
        helper.setTo("419850688@qq.com","1565158783@qq.com");
        helper.setSubject("springboot测试");
        helper.setText("这是个群发邮件");
        mailSender.send(helper);
    }

}
