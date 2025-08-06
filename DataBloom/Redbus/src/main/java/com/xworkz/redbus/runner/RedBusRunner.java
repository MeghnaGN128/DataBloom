package com.xworkz.redbus.runner;

import com.xworkz.redbus.entity.RedBusEntity;
import com.xworkz.redbus.repository.RedBusRepository;
import com.xworkz.redbus.repository.RedBusRepositoryImpl;

import java.util.List;

public class RedBusRunner {
    public static void main(String[] args) {
        RedBusRepository repository = new RedBusRepositoryImpl();

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
//
//        // Example: Update entity
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
//        // Example: Delete entity with id 1
//        RedBusEntity deleted = repository.deleteRedBus(1);
//        if (deleted != null) {
//            System.out.println("Deleted RedBus: " + deleted);
//        } else {
//            System.out.println("Deletion failed for id 1");
//        }
//
//        // Example: Find all RedBus entities
//        List<RedBusEntity> allRedBuses = repository.findAllRedBus();
//        System.out.println("Total RedBus entities found: " + allRedBuses.size());
//        allRedBuses.forEach(System.out::println);
//
//        // You could continue adding more tests for your named query updates and finds here...
    }
}
