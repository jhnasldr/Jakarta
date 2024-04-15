package com.bravo.jakarta.controllers;

import com.bravo.jakarta.DTOs.IdDTO;
import com.bravo.jakarta.entities.Car;
import com.bravo.jakarta.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/api/v1/allcars") //Admin
    public List<Car> getAllCars(){
        System.out.println(carService.getAllCars());
        return carService.getAllCars();
    }

    @GetMapping("/api/v1/cars") //Customer //TODO logik för att hämta endast tillgängliga bilar
    public List<Car> getAvailableCars(){
        System.out.println(carService.getAvailableCars());
        return carService.getAvailableCars();
    }

    @PostMapping("/api/v1/addcar")
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        return new ResponseEntity<>(carService.addCar(car), HttpStatus.CREATED);
    }

    @PutMapping("/api/v1/updatecar")
    public ResponseEntity<Car> updateCar(@RequestBody Car car){
        int id = car.getId();
        return ResponseEntity.ok(carService.updateCar(id, car));
    }

    @DeleteMapping("/api/v1/deletecar")
    public ResponseEntity<String> deleteCar(@RequestBody IdDTO idDTO){
        carService.deleteCar(idDTO.getId());
        return new ResponseEntity<>("Car deleted!", HttpStatus.OK);

    }


}
