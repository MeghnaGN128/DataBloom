package com.xworkz.user.service;

import com.xworkz.user.dto.RegisterDTO;
public interface RegisterService {
    boolean save(RegisterDTO dto);
    RegisterDTO acceptLogin(String email,String password);
    String getEmail(String email);
    Long getMobile(Long mobile);
    String getPassword(String email);
    boolean updatePassword(String email,String password,String confirmPassword);
    boolean setPassword(String email, String password, String confirmPassword);
    boolean setOtpByemail(String email,String otp);
}
