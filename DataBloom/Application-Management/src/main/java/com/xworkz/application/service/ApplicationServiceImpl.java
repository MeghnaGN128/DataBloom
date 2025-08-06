package com.xworkz.application.service;

import com.xworkz.application.entity.ApplicationEntity;
import com.xworkz.application.repository.ApplicationRepository;
import com.xworkz.application.repository.ApplicationRepositoryImpl;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository = new ApplicationRepositoryImpl();

    @Override
    public void saveApplication(ApplicationEntity applicationEntity) {
        if (isValid(applicationEntity)) {
            applicationRepository.saveApplication(applicationEntity);
            System.out.println("Application saved successfully.");
        } else {
            System.out.println("Application entity is invalid, cannot save.");
        }
    }

    private boolean isValid(ApplicationEntity applicationEntity) {
        if (applicationEntity == null) {
            System.out.println("ApplicationEntity is null");
            return false;
        }
        if (applicationEntity.getApplicationName() == null) {
            System.out.println("Name is invalid");
            return false;
        }
        if (applicationEntity.getApplicationSize() == null) {
            System.out.println("Size is invalid");
            return false;
        }
        if (applicationEntity.getCompany() == null) {
            System.out.println("Company is invalid");
            return false;
        }
        if (applicationEntity.getNoOfUsers() == null) {
            System.out.println("No of users is invalid");
            return false;
        }
        if (applicationEntity.getRatings() == null) {
            System.out.println("Ratings is invalid");
            return false;
        }
        if (applicationEntity.getLaunchDate() == null) {
            System.out.println("Launch date is invalid");
            return false;
        }
        // All validations passed
        return true;
    }

    @Override
    public ApplicationEntity readApplication(Integer id) {
        return applicationRepository.readApplication(id);
    }

    @Override
    public ApplicationEntity updateApplication(ApplicationEntity applicationEntity, Integer id) {
        return applicationRepository.updateApplication(applicationEntity, id);
    }

    @Override
    public ApplicationEntity deleteApplication(Integer id) {
        return applicationRepository.deleteApplication(id);
    }

    @Override
    public ApplicationEntity findApplicationByName(String name) {
        return applicationRepository.findApplicationByName(name);
    }

    @Override
    public ApplicationEntity findBySize(String size) {
        return applicationRepository.findBySize(size);
    }

    @Override
    public ApplicationEntity findByCompany(String company) {
        return applicationRepository.findByCompany(company);
    }

    @Override
    public ApplicationEntity findByUsers(Integer users) {
        return applicationRepository.findByUsers(users);
    }

    @Override
    public ApplicationEntity findByRatings(Float ratings) {
        return applicationRepository.findByRatings(ratings);
    }

    @Override
    public ApplicationEntity findByDate(LocalDate date) {
        return applicationRepository.findByDate(date);
    }

    @Override
    public List<ApplicationEntity> findByAll() {
        return applicationRepository.findByAll();
    }

    @Override
    public ApplicationEntity updateApplicationNameAndNoOfUsers(Integer id, String applicationName, String company, Integer noOfUsers) {
        return applicationRepository.updateApplicationNameAndNoOfUsers(id, applicationName, company, noOfUsers);
    }

    @Override
    public List<String> findAllApplicationName() {
        return applicationRepository.findAllApplicationName();
    }

    @Override
    public List<String> findAllCompany() {
        return applicationRepository.findAllCompany();
    }

    @Override
    public List<String> findAllApplicationSize() {
        return applicationRepository.findAllApplicationSize();
    }

    @Override
    public List<String> findAllNoOfUsers() {
        return applicationRepository.findAllNoOfUsers();
    }

    @Override
    public List<Object> findByAllLaunchDate() {
        return applicationRepository.findByAllLaunchDate();
    }

    @Override
    public List<String[]> findByAllApplicationNameAndApplicationSize() {
        return  applicationRepository.findByAllApplicationNameAndApplicationSize();
    }

    @Override
    public List<Object[]> findByCompanyaAndRatingsAndLaunchDate() {
        return applicationRepository.findByCompanyaAndRatingsAndLaunchDate();
    }
}
