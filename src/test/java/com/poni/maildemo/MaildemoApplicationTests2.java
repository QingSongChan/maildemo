package com.poni.maildemo;

import com.poni.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaildemoApplicationTests2 {

    @Autowired
    private MailService mailService;

    @Test
    public void sendAttachmentsMail(){
        String filePath="C:\\Users\\45570\\Desktop\\杂七杂八\\666.jpg";
        mailService.sendAttachmentsMail("带附件的邮件","有附件，请查收",filePath);
    }

    @Test
    public  void sendSimpleMail() throws Exception{
        mailService.sendMail("简单邮件","springboot实现邮件发送");
    }

}
