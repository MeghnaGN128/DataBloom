package com.xworkz.makeupkit.runner;

import com.xworkz.makeupkit.entity.MakeupKitEntity;
import com.xworkz.makeupkit.repository.MakeupKitRepository;
import com.xworkz.makeupkit.repository.MakeupKitRepositoryImpl;

import java.time.LocalDate;
import java.util.List;

public class MakeupKitRunner {
    public static void main(String[] args) {
        MakeupKitRepository repository = new MakeupKitRepositoryImpl();

        // Create and save a new MakeupKitEntity
        MakeupKitEntity kit = new MakeupKitEntity();
        kit.setBrand("L'Oréal");
        kit.setType("Lipstick");
        kit.setExpiryDate(LocalDate.of(2025, 12, 31));
        kit.setPrice(25.00);

        repository.saveMakeupKit(kit);
        System.out.println("MakeupKit saved successfully!");

        // Example: Read entity by makeupKitId (assuming ID 1)
//        MakeupKitEntity found = repository.readMakeupKit(1);
//        if (found != null) {
//            System.out.println("MakeupKit found: " + found);
//        } else {
//            System.out.println("No MakeupKit found with id 1");
//        }
//
//        // Example: Update entity
//        MakeupKitEntity toUpdate = new MakeupKitEntity();
//        toUpdate.setBrand("L'Oréal Paris");
//        toUpdate.setType("Lipstick Matte");
//        toUpdate.setExpiryDate(LocalDate.of(2026, 1, 30));
//        toUpdate.setPrice(27.00);
//
//        MakeupKitEntity updated = repository.updateMakeupKit(toUpdate, 1);
//        if (updated != null) {
//            System.out.println("Update successful: " + updated);
//        } else {
//            System.out.println("Update failed for id 1");
//        }
//
//        // Example: Delete entity with id 1
//        MakeupKitEntity deleted = repository.deleteMakeupKit(1);
//        if (deleted != null) {
//            System.out.println("Deleted MakeupKit: " + deleted);
//        } else {
//            System.out.println("Deletion failed for id 1");
//        }
//
//        // Example: Find all MakeupKit entities
//        List<MakeupKitEntity> allKits = repository.findAllMakeupKits();
//        System.out.println("Total MakeupKit entities found: " + allKits.size());
//        allKits.forEach(System.out::println);
//
//        // Add more test code for named query operations if desired.
    }
}
