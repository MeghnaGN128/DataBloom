package com.xworkz.redbus.runner;

import com.xworkz.redbus.entity.RedBusEntity;
import com.xworkz.redbus.repository.RedBusRepository;
import com.xworkz.redbus.repository.RedBusRepositoryImpl;
import com.xworkz.redbus.service.RedBusService;
import com.xworkz.redbus.service.RedBusServiceImpl;

import java.util.Arrays;
import java.util.List;

public class RedBusRunner {
    public static void main(String[] args) {
        RedBusRepository repository = new RedBusRepositoryImpl();
        RedBusService redBusService = new RedBusServiceImpl();

        // Create and save a new RedBusEntity
        RedBusEntity redBus = new RedBusEntity();
        redBus.setBusName("Ganesh Travels");
        redBus.setContact(8583920788L);
        redBus.setSeatNo(8);
        redBus.setPassengerName("Meera");
        redBus.setPassengerAge(15);

        repository.saveRedBus(redBus);
        System.out.println("RedBus saved successfully!");

        // Example: Read entity by busId (assuming ID 1)
//        RedBusEntity found = repository.readRedBus(1);
//        if (found != null) {
//            System.out.println("RedBus found: " + found);
//        } else {
//            System.out.println("No RedBus found with id 1");
//        }

//        // Update entity
//        RedBusEntity toUpdate = new RedBusEntity();
//        toUpdate.setBusName("Ganesh Travels Updated");
//        toUpdate.setContact(9999999999L);
//        toUpdate.setSeatNo(8);
//        toUpdate.setPassengerName("Meera Updated");
//        toUpdate.setPassengerAge(16);
//
//        RedBusEntity updated = repository.updateRedBus(toUpdate, 1);
//        if (updated != null) {
//            System.out.println("Update successful: " + updated);
//        } else {
//            System.out.println("Update failed for id 1");
//        }
//
//        //  Delete entity with id 1
//        RedBusEntity deleted = repository.deleteRedBus(2);
//        if (deleted != null) {
//            System.out.println("Deleted RedBus: " + deleted);
//        } else {
//            System.out.println("Deletion failed for id 2");
//        }
//
//        // Find all RedBus entities
//        List<RedBusEntity> allRedBuses = repository.findAllRedBus();
//        System.out.println("Total RedBus entities found: " + allRedBuses.size());
//        allRedBuses.forEach(System.out::println);

//        List<String> l3 = redBusService.findAllBusName();
//        l3.forEach(System.out::println);
//
//        List<String> l1 = redBusService.findAllPassengerName();
//        l1.forEach(System.out::println);
//
//        List<Integer> l2 = redBusService.findAllPassengerAge();
//        l2.forEach(System.out::println);
//
//        List<Long> l4 = redBusService.findAllContact();
//        l4.forEach(System.out::println);
//
//        List<Integer> l5 = redBusService.findAllSeatNo();
//        l5.forEach(System.out::println);

        List<Object[]> l6 = redBusService.findByAllBusNameAndSeatNo();
        l6.forEach(a-> System.out.println(Arrays.toString(a)));

//        List<Object[]> l7 = redBusService.findByAllPassengerNameAndPassengerAgeAndContact();
//        l7.forEach(b-> System.out.println(Arrays.toString(b)));


    }
}
