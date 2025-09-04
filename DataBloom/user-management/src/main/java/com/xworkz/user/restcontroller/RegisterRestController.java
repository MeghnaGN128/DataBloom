package com.xworkz.user.restcontroller;

import com.xworkz.user.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-management")
public class RegisterRestController {

    @Autowired
    private RegisterService registerService;

    public RegisterRestController() {
        System.out.println("RegisterRestController instantiated...");
    }

    // ✅ Validate email
    @GetMapping("/loginemail")
    public String mailValidation(@RequestParam("email") String email) {
        String existing = registerService.getEmail(email);
        if (existing == null) {
            return "Email is available.";
        }
        return "Email already exists!";
    }

    // ✅ Validate mobile
    @GetMapping("/loginmobile")
    public String mobileValidation(@RequestParam("mobile") String mobile) {
        try {
            Long mobileNumber = Long.valueOf(mobile);
            Long existing = registerService.getMobile(mobileNumber);
            if (existing == null) {
                return "Mobile number is available.";
            }
            return "Mobile number already registered!";
        } catch (NumberFormatException e) {
            return "Invalid mobile number format.";
        }
    }
}
