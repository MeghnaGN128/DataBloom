package com.xworkz.user.service;

import java.security.SecureRandom;

public class OTP {
    private static final SecureRandom random=new SecureRandom();
    public static String genereateOtp(int length){
        StringBuilder s=new StringBuilder();
        for (int i=0;i<length;i++){
            s.append(random.nextInt(10));
        }
        return  s.toString();
    }
}
