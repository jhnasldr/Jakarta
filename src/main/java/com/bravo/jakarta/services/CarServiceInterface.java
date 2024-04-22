package com.bravo.jakarta.services;

import com.bravo.jakarta.entities.Car;

import java.util.List;

public interface CarServiceInterface {
    List<Car> getAllCars();
    List<Car> getAvailableCars();
    Car addCar(Car car);
    Car updateCar(int id, Car car);
    void deleteCar(int id);
}
