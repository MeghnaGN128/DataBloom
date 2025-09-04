package com.xworkz.user.service;

public interface EmailSender {
    boolean mailSender(String email, String otp);
}
