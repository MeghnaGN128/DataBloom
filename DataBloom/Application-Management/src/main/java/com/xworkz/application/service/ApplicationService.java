package com.xworkz.application.service;

import com.xworkz.application.entity.ApplicationEntity;

import java.time.LocalDate;
import java.util.List;

public interface ApplicationService {
    void saveApplication(ApplicationEntity applicationEntity);

    ApplicationEntity readApplication(Integer id);

    ApplicationEntity updateApplication(ApplicationEntity applicationEntity, Integer id);

    ApplicationEntity deleteApplication(Integer id);

    ApplicationEntity findApplicationByName(String name);

    ApplicationEntity findBySize(String size);

    ApplicationEntity findByCompany(String company);

    ApplicationEntity findByUsers(Integer users);

    ApplicationEntity findByRatings(Float ratings);

    ApplicationEntity findByDate(LocalDate date);

    List<ApplicationEntity> findByAll();

    ApplicationEntity updateApplicationNameAndNoOfUsers(Integer id,String applicationName,String company,Integer noOfUsers);

}
