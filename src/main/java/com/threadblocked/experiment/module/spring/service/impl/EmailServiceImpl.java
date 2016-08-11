package com.threadblocked.experiment.module.spring.service.impl;

import com.threadblocked.experiment.module.spring.service.EmailService;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

/**
 * Created by ArthurTsang on 8/10/16.
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Override
    public void testEmail(){
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost("smtp.exmail.qq.com");
        sender.getJavaMailProperties().put("mail.smtp.auth","true");
        sender.getJavaMailProperties().put("mail.smtp.debug","true");
        //todo 不知道为何加密的调不通
        //sender.getJavaMailProperties().put("mail.smtp.ssl.enable","true");
        //sender.getJavaMailProperties().put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        sender.getJavaMailProperties().put("mail.smtp.timeout", 25000);
        sender.setUsername("zengzengxiong@smart3f.com");
        sender.setPassword("****");
        sender.setPort(25);

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setTo("1809575813@qq.com");
            helper.setFrom("zengzengxiong@smart3f.com");
            helper.setSubject("TTTTTTTTT");
            helper.setText("A hahhhaaa");
            sender.send(message);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("aaaaaa");
    }

}
