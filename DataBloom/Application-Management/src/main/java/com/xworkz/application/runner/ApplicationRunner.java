package com.xworkz.application.runner;

import com.xworkz.application.entity.ApplicationEntity;
import com.xworkz.application.repository.ApplicationRepository;
import com.xworkz.application.repository.ApplicationRepositoryImpl;
import com.xworkz.application.service.ApplicationService;
import com.xworkz.application.service.ApplicationServiceImpl;

public class ApplicationRunner {
    public static void main(String[] args) {
        ApplicationService applicationService=new ApplicationServiceImpl();
        ApplicationRepository applicationRepository=new ApplicationRepositoryImpl();
        ApplicationEntity applicationEntity=new ApplicationEntity();

        applicationRepository.findByCompany("Zomato");
        applicationRepository.findByRatings(4.0f);
        applicationRepository.findBySize("33");
        applicationRepository.findByUsers(110);


    }
}
