package com.xworkz.carstore.repository;

import com.xworkz.carstore.entity.CarEntity;
import java.util.List;

public interface CarRepository {

    void saveCar(CarEntity carEntity);

    CarEntity readCar(Integer carId);

    CarEntity updateCar(CarEntity carEntity, Integer carId);

    CarEntity deleteCar(Integer carId);

    CarEntity findByMake(String make);

    CarEntity findByModel(String model);

    CarEntity findByYear(Integer year);

    CarEntity findByPrice(Double price);

    List<CarEntity> findAllCars();

    CarEntity updatePriceById(Integer carId, Double price);

    CarEntity updateModelAndYearByMake(String make, String model, Integer year);

    CarEntity updateMakeByModelAndPrice(String model, Double price, String make);
}
