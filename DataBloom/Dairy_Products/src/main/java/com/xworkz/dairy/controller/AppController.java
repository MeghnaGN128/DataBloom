package com.xworkz.dairy.controller;

import com.xworkz.dairy.dto.AdminDTO;
import com.xworkz.dairy.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
@Slf4j
public class AppController {
@Autowired
private AdminService adminService;

    @GetMapping("adminLogin")
    public String adminLogin(){
        return "adminLoginform";
    }
    @PostMapping("adminLoginSuccess")
    public String adminLogin(@RequestParam String adminName, @RequestParam String password, Model model,HttpSession session){
        // Treat adminName as email for login
        if (adminService.isAccountLocked(adminName)) {
            model.addAttribute("lockMessage", "Your account is locked due to too many failed attempts. Please reset your password.");
            model.addAttribute("email", adminName);
            return "adminaccountlocked";
        }
        AdminDTO adminDTO = adminService.adminlogin(adminName, password);
        if (adminDTO!=null){
            log.info("Admin login successfully");
            session.setAttribute("adminDTO", adminDTO);
            model.addAttribute("adminDTO", adminDTO);
            System.out.println("Admin adminDTO ========= "+adminDTO);
            return "adminloginsuccessfully";

        }else {
            log.info("Admin login failed");
            if (adminService.isAccountLocked(adminName)) {
                model.addAttribute("lockMessage", "Your account is now locked due to too many failed attempts. Please reset your password.");
                model.addAttribute("email", adminName);
                return "adminaccountlocked";
            }
            model.addAttribute("message", "Invalid admin name or password");
            return "adminLoginform";
        }

    }

    @GetMapping("adminprofile")
    public String adminProfile(HttpSession session,Model model) {
        AdminDTO adminDTO = (AdminDTO) session.getAttribute("adminDTO");
        if (adminDTO == null) {
            return "adminLoginform";
        }
        model.addAttribute("adminDTO", adminDTO);
        return "adminprofile";
    }

    @PostMapping("updateAdminProfile")
    public String updateAdminProfile(@ModelAttribute AdminDTO adminDTO,
                                     HttpSession session,
                                     RedirectAttributes redirectAttributes) {
        AdminDTO adminDTO1=(AdminDTO) session.getAttribute("adminDTO");
        if(adminDTO1==null) {
            return "adminloginform";
        }
        log.info("AdminDTO from session{"+adminDTO+"}");
        boolean update = adminService.update(adminDTO);
        session.setAttribute("adminDTO", adminDTO);
        redirectAttributes.addFlashAttribute("message", "Profile updated successfully!");
        return "adminprofile";
    }

    // Account locked page
    @GetMapping("adminaccountlocked")
    public String adminAccountLocked(@RequestParam(required = false) String email, Model model) {
        model.addAttribute("email", email);
        return "adminaccountlocked";
    }

    // Show Forgot Password (email capture) page
    @GetMapping("adminForgotPassword")
    public String adminForgotPassword(@RequestParam(required = false) String email, Model model) {
        model.addAttribute("email", email);
        model.addAttribute("info", "Enter your email to receive a reset link.");
        return "adminforgotpassword";
    }
    // Send reset link handler
    @PostMapping("sendResetLink")
    public String sendResetLink(@RequestParam String email,
                                @RequestParam(required = false) String source,
                                HttpServletRequest request,
                                Model model) {
        String baseUrl = request.getScheme() + "://" + request.getServerName()
                + ((request.getServerPort()==80 || request.getServerPort()==443) ? "" : (":" + request.getServerPort()))
                + request.getContextPath();
        String token = adminService.initiatePasswordReset(email, baseUrl);
        // Separate behavior based on the flow source
        if ("locked".equalsIgnoreCase(source)) {
            // Do NOT redirect to set password directly. Inform user to check email.
            model.addAttribute("info", "If an account exists for this email, a reset link has been sent.");
            model.addAttribute("email", email);
            return "adminaccountlocked";
        } else {
            // Default and 'forgot' flow: show info on forgot page
            model.addAttribute("info", "If an account exists for this email, a reset link has been sent.");
            model.addAttribute("email", email);
            return "adminforgotpassword";
        }
    }

    // Set password by token
    @GetMapping("adminSetPassword")
    public String showSetPassword(@RequestParam String token, Model model) {
        model.addAttribute("token", token);
        return "adminsetpassword";
    }

    @PostMapping("adminSetPassword")
    public String handleSetPassword(@RequestParam String token,
                                    @RequestParam String password,
                                    @RequestParam String confirmPassword,
                                    Model model,
                                    RedirectAttributes redirectAttributes) {
        if (!password.equals(confirmPassword)) {
            model.addAttribute("token", token);
            model.addAttribute("error", "Passwords do not match");
            return "adminsetpassword";
        }
        boolean ok = adminService.resetPassword(token, password);
        if (ok) {
            redirectAttributes.addFlashAttribute("message", "Password has been set. You can now log in.");
            return "redirect:/adminLogin";
        } else {
            model.addAttribute("error", "Invalid or expired link. Please request a new reset link.");
            return "adminaccountlocked";
        }
    }

    @GetMapping("logout")
    public String logout(HttpSession session, Model model, RedirectAttributes redirectAttributes) {
        session.invalidate();
        // Use flash attribute so message survives redirect
        redirectAttributes.addFlashAttribute("message", "You have been logged out successfully.");
        log.info("logout successfully");
        return "redirect:/adminLogin";
    }

    
}
