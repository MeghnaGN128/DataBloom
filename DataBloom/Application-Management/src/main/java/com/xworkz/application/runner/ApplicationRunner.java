package com.xworkz.application.runner;

import com.xworkz.application.entity.ApplicationEntity;
import com.xworkz.application.service.ApplicationService;
import com.xworkz.application.service.ApplicationServiceImpl;

import java.time.LocalDate;
import java.util.List;

public class ApplicationRunner {
    public static void main(String[] args) {
        ApplicationService applicationService = new ApplicationServiceImpl();
        ApplicationEntity applicationEntity = new ApplicationEntity();
        applicationEntity.setApplicationName("Bigbasket");
        applicationEntity.setApplicationSize("20 KB");
        applicationEntity.setCompany("Relince");
        applicationEntity.setNoOfUsers(741);
        applicationEntity.setRatings(5.0f);
        applicationEntity.setLaunchDate(LocalDate.of(2025, 3, 11));

        //save
//        applicationService.saveApplication(applicationEntity);
//        System.out.println("Application saved successfully!");
        //save


        //read
//        applicationService.readApplication(2);
//        System.out.println("Application read successfully!");
        //read

        //update
//        ApplicationEntity updatedEntity = new ApplicationEntity();
//        updatedEntity.setApplicationName("Swiggy");
//        updatedEntity.setApplicationSize("30 MB");
//        updatedEntity.setCompany("Swiggy Company");
//        updatedEntity.setNoOfUsers(1200);
//        updatedEntity.setRatings(4.7f);
//        updatedEntity.setLaunchDate(LocalDate.of(2025, 7, 15));
//        Integer idToUpdate = 2;
//        ApplicationEntity updated = applicationService.updateApplication(updatedEntity, idToUpdate);
//        if (updated != null) {
//            System.out.println("Update successful: " + updated);
//        } else {
//            System.out.println("Update failed: Entity with ID " + idToUpdate + " not found");
//        }
        //update

        //delete
//        Integer id = 3;
//        boolean isDeleted = applicationService.deleteApplication(id) != null;
        //delete

        //findbyname
//        String nameToFind = "Swiggy";
//
//        ApplicationEntity entity = applicationService.findApplicationByName(nameToFind);
//
//        if (entity != null) {
//            System.out.println("Application found: " + entity);
//        } else {
//            System.out.println("Application not found with name: " + nameToFind);
//        }
        //findbyname

        // findBySize
//        ApplicationEntity entityBySize = applicationService.findBySize("30 MB");
//        if (entityBySize != null) {
//            System.out.println("Found by size: " + entityBySize);
//        } else {
//            System.out.println("No application found by size 20 KB");
//        }
        //findBySize

        // findByCompany
//        ApplicationEntity entityByCompany = applicationService.findByCompany("Relince");
//        if (entityByCompany != null) {
//            System.out.println("Found by company: " + entityByCompany);
//        } else {
//            System.out.println("No application found by company Relince");
//        }

        // findByUsers
//        ApplicationEntity entityByUsers = applicationService.findByUsers(741);
//        if (entityByUsers != null) {
//            System.out.println("Found by users: " + entityByUsers);
//        } else {
//            System.out.println("No application found by users 741");
//        }

        // findByRatings
//        ApplicationEntity entityByRatings = applicationService.findByRatings(5.0f);
//        if (entityByRatings != null) {
//            System.out.println("Found by ratings: " + entityByRatings);
//        } else {
//            System.out.println("No application found by ratings 5.0");
//        }

        // findByDate
//        ApplicationEntity entityByDate = applicationService.findByDate(LocalDate.of(2025, 3, 11));
//        if (entityByDate != null) {
//            System.out.println("Found by date: " + entityByDate);
//        } else {
//            System.out.println("No application found by date 2025-03-11");
//        }

        // findByAll
//        List<ApplicationEntity> allEntities = applicationService.findByAll();
//        if (allEntities != null) {
//            System.out.println("All applications:");
//            allEntities.forEach(System.out::println);
//        } else {
//            System.out.println("No applications found");
//       }

        ApplicationEntity application=applicationService.updateApplicationNameAndNoOfUsers(2 ,"Google","Swiggy Company",120);
        System.out.println("updateApplicationNameAndNoOfUsers"+application);

        }
    }

