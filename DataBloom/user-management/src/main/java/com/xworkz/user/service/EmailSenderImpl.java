package com.xworkz.user.service;

import com.xworkz.user.configuration.EmailConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderImpl implements EmailSender{
    @Autowired
    EmailConfiguration configuration;

    @Override
    public boolean mailSender(String email, String otp) {
            try {
                System.out.println("Invoking mailSend ");
                System.out.println("Email :" + email + " Otp :" + otp);
                SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
                simpleMailMessage.setFrom("meghananinganur@gmail.com");
                simpleMailMessage.setTo(email);
                simpleMailMessage.setSubject("Otp to login");
                simpleMailMessage.setText("Otp for login " + otp);
                configuration.mailSender().send(simpleMailMessage);
                System.out.println("Otp sent for :" + email + ":" + otp);
                return true;
            }catch (Exception e)
            {
                System.out.println(e.getMessage());
                return false;
            }
    }
}
