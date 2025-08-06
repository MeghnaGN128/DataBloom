package com.xworkz.metro.runner;

import com.xworkz.metro.entity.MetroEntity;
import com.xworkz.metro.repository.MetroRepository;
import com.xworkz.metro.repository.MetroRepositoryImpl;
import com.xworkz.metro.service.MetroService;
import com.xworkz.metro.service.MetroServiceImpl;

import java.util.Arrays;
import java.util.List;

public class MetroRunner {
    public static void main(String[] args) {
        MetroRepository repository = new MetroRepositoryImpl();
        MetroService metroService=new MetroServiceImpl();

        // Create and save a new MetroEntity
        MetroEntity metro = new MetroEntity();
        metro.setMetroName("City Line Metro");
        metro.setOperator("Metro Operators Inc.");
        metro.setTotalRoutes(5);

        repository.saveMetro(metro);
        System.out.println("Metro saved successfully!");

        // Example: Read entity by metroId (assuming ID 1)
//        MetroEntity found = repository.readMetro(1);
//        if (found != null) {
//            System.out.println("Metro found: " + found);
//        } else {
//            System.out.println("No Metro found with id 1");
//        }
//
//        // Example: Update entity
//        MetroEntity toUpdate = new MetroEntity();
//        toUpdate.setMetroName("City Line Metro Updated");
//        toUpdate.setOperator("Metro Operators Ltd.");
//        toUpdate.setTotalRoutes(6);
//
//        MetroEntity updated = repository.updateMetro(toUpdate, 1);
//        if (updated != null) {
//            System.out.println("Update successful: " + updated);
//        } else {
//            System.out.println("Update failed for id 1");
//        }
//
//        // Example: Delete entity with id 1
//        MetroEntity deleted = repository.deleteMetro(1);
//        if (deleted != null) {
//            System.out.println("Deleted Metro: " + deleted);
//        } else {
//            System.out.println("Deletion failed for id 1");
//        }
//
//        // Example: Find all Metro entities
//        List<MetroEntity> allMetros = repository.findAllMetros();
//        System.out.println("Total Metro entities found: " + allMetros.size());
//        allMetros.forEach(System.out::println);
//        List<Integer> l1=metroService.findAllMetroIds();
//        l1.forEach(System.out::println);
//
//        List<String> l2=metroService.findAllMetroNames();
//        l2.forEach(System.out::println);
//
//        List<String> l4=metroService.findAllOperators();
//        l4.forEach(System.out::println);
//
//        List<Integer> l5=metroService.findAllTotalRoutes();
//        l5.forEach(System.out::println);

//        List<String[]> l6=metroService.findAllMetroNameAndOperator();
//        l6.forEach(row -> System.out.println(Arrays.toString(row)));
//
////
////        List<Object[]> l7 = metroService.findByAllOperatorAndTotalRoutesAndMetroName();
////        l7.forEach((a) -> System.out.println(Arrays.toString(a)));

        try {
            List<String[]> l6 = metroService.findAllMetroNameAndOperator();
            l6.forEach(row -> System.out.println(Arrays.toString(row)));
        } catch (Exception e) {
            System.out.println("Error while fetching metro name and operator: " + e.getMessage());
        }

        try {
            List<Object[]> l7 = metroService.findByAllOperatorAndTotalRoutesAndMetroName();
            l7.forEach((a) -> System.out.println(Arrays.toString(a)));
        } catch (Exception e) {
            System.out.println("Error while fetching operator, routes, and metro name: " + e.getMessage());
        }



    }
}
