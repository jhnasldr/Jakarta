package com.bravo.jakarta.services;

import com.bravo.jakarta.entities.Car;
import com.bravo.jakarta.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements CarServiceInterface{

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {     //admin endpoint, bokade eller ej
        return carRepository.findAll();
    }

    @Override
    public List<Car> getAvailableCars() {   //customer endpoint, visa lediga bilar
        return null;
    }

    @Override
    public Car addCar(Car car) {
        return null;
    }

    @Override
    public Car updateCar(int id, Car car) {
        return null;
    }

    @Override
    public void deleteCar(int id) {

    }
}
