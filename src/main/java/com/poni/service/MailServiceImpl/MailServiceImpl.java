package com.poni.service.MailServiceImpl;

import com.poni.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

/*
 *@author:PONI_CHAN
 *@date:2018/12/11 23:04
 */
@Service("mailService")
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    /**
     *  群发
     * @author chenmc
     * @date 2018/12/12 00:27:46
     * @param subject, content
     * @return void
     */
    @Override
    public void sendMail(String subject, String content) {
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom("455705749@qq.com");//发起者
        mailMessage.setTo("419850688@qq.com");//接受者

        //如果发给多个人的：
        //mailMessage.setTo("1xx.com","2xx.com","3xx.com");  
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        try {
            mailSender.send(mailMessage);
            System.out.println("发送简单邮件");
        }catch (Exception e){
            System.out.println("发送简单邮件失败");
        }
    }


    /**
     *  发送带附件的邮件
     * @author chenmc
     * @date 2018/12/11 23:13:53
     * @param  subject, content, filePath
     * @return void
     */
    @Override
    public void sendAttachmentsMail(String subject,String content,String filePath){
        MimeMessage mimeMessage=mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
            helper.setFrom("455705749@qq.com");
            helper.setTo("419850688@qq.com");
            helper.setSubject(subject);
            helper.setText(content);
            FileSystemResource file=new FileSystemResource(new File(filePath));
            String fileName=filePath.substring(filePath.lastIndexOf(File.separator));

            //如果有多个附件则可以多用几次helper.addAttachment(fileName,file);
            helper.addAttachment(fileName,file);
            mailSender.send(mimeMessage);
            System.out.println("发送带附件的邮件成功");
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("发送带附件的邮件失败");
        }
    }
}
