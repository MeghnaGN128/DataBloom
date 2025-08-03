package com.xworkz.customer.repo;

import com.xworkz.customer.dto.ContactDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ContactRepositoryImpl implements ContactRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean persist(ContactDTO contactDTO) {
        System.out.println("save method in ContactRepositoryImplementation");

        String sql = "INSERT INTO contact_info (contact_name, contact_email, contact_phone, contact_comments) VALUES (?, ?, ?, ?)";
        int row = jdbcTemplate.update(
                sql,
                contactDTO.getName(),
                contactDTO.getEmail(),
                Long.parseLong(contactDTO.getPhoneNumber()),
                contactDTO.getComments()
        );

        System.out.println("row: " + row);

        if (row > 0) {
            System.out.println("Data is inserted");
            return true;
        } else {
            System.out.println("Row is not inserted");
            return false;
        }
    }
}
