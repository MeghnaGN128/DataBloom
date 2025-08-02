package com.xworkz.application.service;

import com.xworkz.application.entity.ApplicationEntity;
import com.xworkz.application.repository.ApplicationRepository;
import com.xworkz.application.repository.ApplicationRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    ApplicationRepository applicationRepository;

    @Override
    public boolean Check(ApplicationEntity applicationEntity) {
        if (applicationEntity == null) {
            System.out.println("Entity is null");
            return false;
        }

        if (applicationEntity.getApplicationName() == null || applicationEntity.getApplicationName().isEmpty()) {
            System.out.println("Name is invalid");
            return false;
        }

        if (applicationEntity.getApplicationSize() == null || applicationEntity.getApplicationSize().isEmpty()) {
            System.out.println("Size is invalid");
            return false;
        }

        if (applicationEntity.getCompany() == null || applicationEntity.getCompany().isEmpty()) {
            System.out.println("Company is invalid");
            return false;
        }

        if (applicationEntity.getNoOfUsers() == null) {
            System.out.println("No. of users is invalid");
            return false;
        }

        if (applicationEntity.getRatings() == null) {
            System.out.println("Ratings are invalid");
            return false;
        }

        if (applicationEntity.getLaunchDate() == null) {
            System.out.println("Launch date is invalid");
            return false;
        }

        return true;
    }
}
