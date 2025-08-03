package com.xworkz.customer.controller;

import com.xworkz.customer.dto.ContactDTO;
import com.xworkz.customer.service.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class ContactController {
    @Autowired
    private ContactServiceImpl contactServiceImpl;

    @RequestMapping("/form")
    public String getContact(ContactDTO contactDTO, Model model) {
        System.out.println("getContact method in controller");
        System.out.println("Contact details: " + contactDTO);
        if (contactServiceImpl.save(contactDTO)) {
            model.addAttribute("contactDTO", contactDTO);
            return "contactsuccess";
        } else {
            System.out.println("Invalid details");
            model.addAttribute("message", "Invalid details");
            return "contact";
        }
    }
}
