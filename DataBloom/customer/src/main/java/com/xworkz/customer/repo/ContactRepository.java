package com.xworkz.customer.repo;


import com.xworkz.customer.dto.ContactDTO;

public interface ContactRepository {
    boolean persist(ContactDTO customerDTO);
}
