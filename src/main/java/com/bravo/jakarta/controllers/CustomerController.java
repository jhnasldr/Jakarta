package com.bravo.jakarta.controllers;

import com.bravo.jakarta.entities.Car;
import com.bravo.jakarta.services.BookingService;
import com.bravo.jakarta.services.CarService;
import com.bravo.jakarta.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private BookingService bookingService;
    private CarService carService;
    private CustomerService customerService;

    @Autowired
    public CustomerController(BookingService bookingService, CarService carService, CustomerService customerService) {
        this.bookingService = bookingService;
        this.carService = carService;
        this.customerService = customerService;
    }

    @GetMapping("/api/v1/cars") //TODO logik för att hämta endast tillgängliga bilar
    public List<Car> getAvailableCars(){
        System.out.println(carService.getAvailableCars());
        return carService.getAvailableCars();
    }
}
