package com.xworkz.customer.service;

import com.xworkz.customer.dto.ContactDTO;
import com.xworkz.customer.repo.ContactRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepositoryImpl contactRepositoryImpl;

    @Override
    public boolean save(ContactDTO contactDTO) {
        System.out.println("validate method in ContactServiceImplementation");

        if (contactDTO == null) {
            System.out.println("ContactDto is null");
            return false;
        }

        String name = contactDTO.getName();
        if (name == null || name.length() <= 3 || name.length() >= 25) {
            System.out.println("name is not valid");
            return false;
        }

        String email = contactDTO.getEmail();
        if (email == null || !email.contains("@gmail.com")) {
            System.out.println("email is not valid");
            return false;
        }

        String phoneStr = contactDTO.getPhoneNumber();
        if (phoneStr == null || phoneStr.length() != 10) {
            System.out.println("phone number is not valid");
            return false;
        }

        String comments = contactDTO.getComments();
        if (comments == null || comments.length() <= 3 || comments.length() >= 150) {
            System.out.println("comments is not valid");
            return false;
        }

        System.out.println("All details are valid");
        return contactRepositoryImpl.persist(contactDTO);
    }
}
