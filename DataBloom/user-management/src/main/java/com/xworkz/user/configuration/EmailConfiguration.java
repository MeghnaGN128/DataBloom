package com.xworkz.user.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfiguration {
    public EmailConfiguration(){
        System.out.println("Running in EmailConfiguration");
    }

    @Bean
    public JavaMailSenderImpl mailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        System.out.println("EmailConfiguration");
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        javaMailSender.setUsername("meghananinganur@gmail.com");
        javaMailSender.setPassword("qlwm odun iskq cchf");
        Properties properties = javaMailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        System.out.println("End EmailConfiguration" + properties);
        return javaMailSender;

    }
}
