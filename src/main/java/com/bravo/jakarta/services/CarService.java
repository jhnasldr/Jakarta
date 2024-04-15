package com.bravo.jakarta.services;

import com.bravo.jakarta.entities.Car;
import com.bravo.jakarta.exceptions.ResourceNotFoundException;
import com.bravo.jakarta.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService implements CarServiceInterface{

    @Autowired
    private CarRepository carRepository;

    private String normalize(String input) {
        if (input != null) {
            return input.trim().toUpperCase();
        }
        return null;
    }

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
        String normalizedPlateNumber = normalize(car.getPlateNumber());
        if (normalizedPlateNumber == null || normalizedPlateNumber.isEmpty()) {
            throw new IllegalArgumentException("Plate number cannot be null or empty.");
        }
        car.setPlateNumber(normalizedPlateNumber);

        Optional<Car> existingCar = carRepository.findByPlateNumber(car.getPlateNumber());
        if (existingCar.isPresent()) {
            throw new IllegalStateException("A car with plate number " + car.getPlateNumber() + " already exists.");
        }

        return carRepository.save(car);
    }

    @Override
    public Car updateCar(int id, Car car) {
        String normalizedPlateNumber = normalize(car.getPlateNumber());
        if (normalizedPlateNumber == null || normalizedPlateNumber.isEmpty()) {
            throw new IllegalArgumentException("Plate number cannot be null or empty.");
        }
        car.setPlateNumber(normalizedPlateNumber);

        Car existingCar = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car", "ID", id));

        Optional<Car> carWithSamePlate = carRepository.findByPlateNumber(normalizedPlateNumber);
        if (carWithSamePlate.isPresent() && carWithSamePlate.get().getId() != id) {
            throw new IllegalStateException("Another car with plate number " + car.getPlateNumber() + " already exists.");
        }
        existingCar.setBrand(car.getBrand());
        existingCar.setModel(car.getModel());
        existingCar.setPlateNumber(car.getPlateNumber());
        existingCar.setDailyCost(car.getDailyCost());
        existingCar.setBookings(car.getBookings());

        return carRepository.save(existingCar);
    }

    @Override
    public void deleteCar(int id) {
        Car car = carRepository.findById(id)
                               .orElseThrow(() -> new ResourceNotFoundException("Car", "ID", id));
        carRepository.delete(car);
    }
}
