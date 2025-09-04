package com.xworkz.user.service;

import com.xworkz.user.dto.RegisterDTO;
import com.xworkz.user.entity.RegisterEntity;
import com.xworkz.user.repository.RegisterRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterRepository repository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private EmailSender emailSender;
    private Map<String, Integer> attempts = new HashMap<>();

    public RegisterServiceImpl() {
        System.out.println("Running is RegisterServiceImpl");
    }

    @Override
    public boolean save(RegisterDTO dto) {
        RegisterEntity entity = new RegisterEntity();
        BeanUtils.copyProperties(dto, entity);
        String otp = OTP.genereateOtp(6);
        entity.setPassword(otp);
        entity.setPresent(true);
        entity.setLockTime(null);
        entity.setLoginCount(-1);
        if (repository.save(entity)) {
            if (emailSender.mailSender(dto.getEmail(), otp)) {
                System.out.println("send Email");
                return true;
            }
            System.out.println("Email not sent");
            return false;
        }
        System.out.println("data not saved");
        return false;
    }

    @Override
    public RegisterDTO acceptLogin(String email, String password) {
        RegisterEntity entity = repository.acceptLogin(email);
        if (entity == null) {
            return null;
        }
        if (!encoder.matches(password, entity.getPassword())) {
            return null;
        }
        RegisterDTO dto = new RegisterDTO();
        BeanUtils.copyProperties(entity, dto);
        System.out.println(entity);
        return dto;
    }

    @Override
    public String getEmail(String email) {
        System.out.println("getEmail");
        return repository.getEmail(email);
    }

    @Override
    public Long getMobile(Long mobile) {
        System.out.println("getMobile");
        return repository.getMobile(mobile);
    }

    @Override
    public String getPassword(String email) {
        System.out.println("getPassword");
        return repository.getPassword(email);
    }

    @Override
    public boolean updatePassword(String email, String password, String confirmPassword) {
        System.out.println("updatepassword.....");
        if (password.equals(confirmPassword)) {
            String encoded = encoder.encode(password);
            if (repository.updatePassword(email, encoded)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setPassword(String email, String password, String confirmPassword) {
        System.out.println("Reset Password Service......");
        if (password.equals(confirmPassword)) {
            String encoded = encoder.encode(password);
            if (repository.setPassword(email, encoded)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setOtpByemail(String email, String otp) {
        System.out.println("set otp by  email");
        String ot = OTP.genereateOtp(6);
        if (repository.setOtpByemail(email, otp)) {
            if (emailSender.mailSender(email, otp)) {
                System.out.println("otp sent successfully");
                return true;
            }
            System.out.println("otp not sent");
        }
        return false;
    }
}