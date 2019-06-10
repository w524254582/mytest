package com.funtl.my.shop.commons.utils;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 邮件发送工具类
 * @ClassName EmailSendUtils
 * @Description TODO
 * @Author kdnight
 * @Date 2019/6/10 11:35
 * @Version 1.0
 **/
public class EmailSendUtils {
     @Autowired
     private Email email;

    public void send(String subject,String msg,String... to) {
         try {
              email.setSubject(subject);
              email.setMsg(msg);
              email.addTo(to);
              email.send();
         } catch (EmailException e) {
              e.printStackTrace();
         }

    }
}
