package com.school.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailServices {

    JavaMailSender mailSender;
    public void sendMail(String userName,String email){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Registered successfullu");
        message.setText("Hi "+userName + ",\n\nyour registration has been completed with email:"+email+"\n in schoom management system. \nThank you");
        mailSender.send(message);
    }
}
