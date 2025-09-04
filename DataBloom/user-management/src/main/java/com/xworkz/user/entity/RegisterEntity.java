package com.xworkz.user.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@RequiredArgsConstructor
@Table(name="user_info")
@NamedQuery(name="acceptLogin",query = "select r from RegisterEntity r where r.email=:email and r.isPresent=true")
@NamedQuery(name="getEmail",query = "select e.email from RegisterEntity e where e.email=:email and e.isPresent=true")
@NamedQuery(name="getMobile",query = "select m.mobile from RegisterEntity m where m.mobile=:mobile and m.isPresent=true")
@NamedQuery(name = "getPassword",query = "select a.password from RegisterEntity a where a.email=:email and a.isPresent=true")
@NamedQuery(name = "setOtpByemail",query = "update RegisterEntity a set a.password=:otp where a.email=:email and a.isPresent=true")
@NamedQuery(name = "updatePassword",query = "update RegisterEntity a set a.password=:password, a.loginCount=0 where a.email=:email and a.isPresent=true")
public class RegisterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name="mobile")
    private Long mobile;

    @Column(name="dob")
    private String dob;

    @Column(name = "gender")
    private String gender;

    @Column(name = "state")
    private String  state;

    @Column(name = "address")
    private String address;

    @Column(name="password")
    private String password;

    @Column(name="confirmPassword")
    private String confirmPassword;

    @Column(name="isPresent")
    private boolean isPresent;

    @Column(name = "login_count")
    private Integer loginCount;

    @Column(name = "lock_time",columnDefinition = "DATETIME")
    private LocalDateTime lockTime;

    @Column(name = "expiry_time")
    private LocalDateTime expiryTime;
}
