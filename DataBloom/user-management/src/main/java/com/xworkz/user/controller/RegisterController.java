package com.xworkz.user.controller;

import com.xworkz.user.dto.RegisterDTO;
import com.xworkz.user.service.EmailSender;
import com.xworkz.user.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
@Slf4j
@Controller
@RequestMapping("/")
public class RegisterController {

    @Autowired
    private RegisterService service;

    @Autowired
    private EmailSender emailSender;

    public RegisterController() {
//        System.out.println("RegisterController instantiated...");
        log.info("RegisterRepositoryImpl instantiated...");

    }

    @GetMapping("home")
    public String onIndexHome() {
        System.out.println("Navigating to home page.");
        return "index";
    }

    @GetMapping("register")
    public String onIndexRegister(Model model) {
        System.out.println("Navigating to register page.");
        model.addAttribute("dto", new RegisterDTO());
        return "register";
    }

    @GetMapping("login")
    public String onIndexLogin() {
        System.out.println("Navigating to login page.");
        return "login";
    }

    @PostMapping("checkLogin")
    public String checkLogin(@RequestParam String email,@RequestParam String otp){
        System.out.println("check login");
        return "setpassword";
    }

    @PostMapping("register")
    public String save(@Valid @ModelAttribute("dto") RegisterDTO dto,
                       BindingResult result,
                       Model model,
                       RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            result.getFieldErrors().forEach(fieldError ->
                    System.out.println(fieldError.getField() + " -- " + fieldError.getDefaultMessage()));

            model.addAttribute("message", "Invalid details.");
            return "register";
        }

        boolean saved = service.save(dto);
        if (saved) {
            System.out.println("data is stored "+saved);
            emailSender.mailSender(dto.getEmail(), "Your verification code or link here");
            redirectAttributes.addFlashAttribute("message", "Registration successful! Please check your email to verify.");
            redirectAttributes.addFlashAttribute("email", dto.getEmail());
            return "loginwithotp";
        } else {
            model.addAttribute("message", "Registration failed. Please try again.");
            return "register";
        }
    }

    @PostMapping("login")
    public String logIn(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        Model model) {

        System.out.println("Login attempt for email: " + email);

        RegisterDTO dto = service.acceptLogin(email, password);
        if (dto == null) {
            model.addAttribute("message", "Invalid email or password");
            return "login";
        }

        model.addAttribute("dto", dto);
        return "view";
    }

    @PostMapping("savePassword")
    public String resetPassword(@RequestParam("email") String email,
                                @RequestParam("password") String password,
                                @RequestParam("confirmPassword") String confirmPassword,
                                Model model) {

        System.out.println("Reset Password request for: " + email);

        if (service.setPassword(email, password, confirmPassword)) {
            model.addAttribute("message", "Password Set Successfully. Please login.");
            return "login";
        } else {
            model.addAttribute("message", "Password Mismatch");
            model.addAttribute("email", email);
            return "setpassword";
        }
    }
}
