package com.poni.service;

/*
 *@author:PONI_CHAN
 *@date:2018/12/11 23:00
 */
public interface MailService {

    /**
     *  发送带附件的邮件
     * @author chenmc
     * @date 2018/12/11 23:01:10
     * @param
     * @return
     */
    void sendAttachmentsMail(String subject,String content,String filePath);

    void sendMail(String subject,String content);
}
