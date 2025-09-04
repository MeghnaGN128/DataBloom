package com.xworkz.user.repository;

import com.xworkz.user.entity.RegisterEntity;

public interface RegisterRepository {
    boolean save(RegisterEntity entity);
    RegisterEntity acceptLogin(String email);
    String getEmail(String email);
    Long getMobile(Long mobile);
    String getPassword(String email);
    boolean updatePassword(String email,String password);
    boolean setPassword(String email, String password);
    boolean setOtpByemail(String email,String otp);
}
