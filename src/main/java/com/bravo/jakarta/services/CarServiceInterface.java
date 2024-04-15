package com.bravo.jakarta.services;

import com.bravo.jakarta.entities.Car;

import java.util.List;

public interface CarServiceInterface {
    List<Car> getAllCars(); //admin endpoint, bokade eller ej
    List<Car> getAvailableCars(); // customer endpoint, visa lediga bilar
    Car addCar(Car car);
    Car updateCar(int id, Car car);
    void deleteCar(int id);
}
