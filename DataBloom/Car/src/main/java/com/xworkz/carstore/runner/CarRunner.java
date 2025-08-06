package com.xworkz.carstore.runner;

import com.xworkz.carstore.entity.CarEntity;
import com.xworkz.carstore.repository.CarRepository;
import com.xworkz.carstore.repository.CarRepositoryImpl;

import java.util.List;

public class CarRunner {
    public static void main(String[] args) {
        CarRepository repository = new CarRepositoryImpl();

        // Create and save a new CarEntity
        CarEntity car = new CarEntity();
        car.setMake("Toyota");
        car.setModel("Camry");
        car.setYear(2022);
        car.setPrice(30000.00);

        repository.saveCar(car);
        System.out.println("Car saved successfully!");

        // Example: Read entity by carId (assuming ID 1)
//        CarEntity found = repository.readCar(1);
//        if (found != null) {
//            System.out.println("Car found: " + found);
//        } else {
//            System.out.println("No Car found with id 1");
//        }
//
//        // Example: Update entity
//        CarEntity toUpdate = new CarEntity();
//        toUpdate.setMake("Toyota");
//        toUpdate.setModel("Camry XSE");
//        toUpdate.setYear(2023);
//        toUpdate.setPrice(35000.00);
//
//        CarEntity updated = repository.updateCar(toUpdate, 1);
//        if (updated != null) {
//            System.out.println("Update successful: " + updated);
//        } else {
//            System.out.println("Update failed for id 1");
//        }
//
//        // Example: Delete entity with id 1
//        CarEntity deleted = repository.deleteCar(1);
//        if (deleted != null) {
//            System.out.println("Deleted Car: " + deleted);
//        } else {
//            System.out.println("Deletion failed for id 1");
//        }
//
//        // Example: Find all Car entities
//        List<CarEntity> allCars = repository.findAllCars();
//        System.out.println("Total Car entities found: " + allCars.size());
//        allCars.forEach(System.out::println);
//
//        // You could continue adding more tests for your named query updates and finds here...
    }
}
