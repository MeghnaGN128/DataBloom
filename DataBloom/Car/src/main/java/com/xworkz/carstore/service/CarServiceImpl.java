package com.xworkz.carstore.service;

import com.xworkz.carstore.entity.CarEntity;
import com.xworkz.carstore.repository.CarRepository;
import com.xworkz.carstore.repository.CarRepositoryImpl;

import java.util.Collections;
import java.util.List;

public class CarServiceImpl implements CarService {

    private final CarRepository carRepository = new CarRepositoryImpl();

    private boolean isValid(CarEntity car) {
        if (car == null) {
            System.out.println("CarEntity is null");
            return false;
        }
        if (car.getMake() == null || car.getMake().isEmpty()) {
            System.out.println("Make is invalid");
            return false;
        }
        if (car.getModel() == null || car.getModel().isEmpty()) {
            System.out.println("Model is invalid");
            return false;
        }
        if (car.getYear() == null || car.getYear() <= 0) {
            System.out.println("Year is invalid");
            return false;
        }
        if (car.getPrice() == null || car.getPrice() <= 0) {
            System.out.println("Price is invalid");
            return false;
        }
        return true;
    }

    @Override
    public void saveCar(CarEntity carEntity) {
        if (isValid(carEntity)) {
            try {
                carRepository.saveCar(carEntity);
                System.out.println("Car saved successfully.");
            } catch (Exception e) {
                System.out.println("Failed to save Car.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid CarEntity, cannot save.");
        }
    }

    @Override
    public CarEntity readCar(Integer carId) {
        if (carId == null || carId <= 0) {
            System.out.println("Invalid carId");
            return null;
        }
        return carRepository.readCar(carId);
    }

    @Override
    public CarEntity updateCar(CarEntity carEntity, Integer carId) {
        if (isValid(carEntity) && carId != null && carId > 0) {
            return carRepository.updateCar(carEntity, carId);
        }
        System.out.println("Invalid input for updateCar");
        return null;
    }

    @Override
    public CarEntity deleteCar(Integer carId) {
        if (carId == null || carId <= 0) {
            System.out.println("Invalid carId for deletion");
            return null;
        }
        return carRepository.deleteCar(carId);
    }

    @Override
    public CarEntity findByMake(String make) {
        if (make == null || make.isEmpty()) {
            System.out.println("Invalid make");
            return null;
        }
        return carRepository.findByMake(make);
    }

    @Override
    public CarEntity findByModel(String model) {
        if (model == null || model.isEmpty()) {
            System.out.println("Invalid model");
            return null;
        }
        return carRepository.findByModel(model);
    }

    @Override
    public CarEntity findByYear(Integer year) {
        if (year == null || year <= 0) {
            System.out.println("Invalid year");
            return null;
        }
        return carRepository.findByYear(year);
    }

    @Override
    public CarEntity findByPrice(Double price) {
        if (price == null || price <= 0) {
            System.out.println("Invalid price");
            return null;
        }
        return carRepository.findByPrice(price);
    }

    @Override
    public List<CarEntity> findAllCars() {
        List<CarEntity> list = carRepository.findAllCars();
        return list != null ? list : Collections.emptyList();
    }

    @Override
    public CarEntity updatePriceById(Integer carId, Double price) {
        if (carId == null || carId <= 0 || price == null || price <= 0) {
            System.out.println("Invalid input to updatePriceById");
            return null;
        }
        return carRepository.updatePriceById(carId, price);
    }

    @Override
    public CarEntity updateModelAndYearByMake(String make, String model, Integer year) {
        if (make == null || make.isEmpty() || model == null || model.isEmpty() || year == null || year <= 0) {
            System.out.println("Invalid input to updateModelAndYearByMake");
            return null;
        }
        return carRepository.updateModelAndYearByMake(make, model, year);
    }

    @Override
    public CarEntity updateMakeByModelAndPrice(String model, Double price, String make) {
        if (model == null || model.isEmpty() || price == null || price <= 0 || make == null || make.isEmpty()) {
            System.out.println("Invalid input to updateMakeByModelAndPrice");
            return null;
        }
        return carRepository.updateMakeByModelAndPrice(model, price, make);
    }
}
