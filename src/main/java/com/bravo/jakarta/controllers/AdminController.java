package com.bravo.jakarta.controllers;

import com.bravo.jakarta.entities.Booking;
import com.bravo.jakarta.entities.Car;
import com.bravo.jakarta.entities.Customer;
import com.bravo.jakarta.services.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AdminController {
    private static final Logger logger = Logger.getLogger(AdminController.class);
    private BookingService bookingService;
    private CarService carService;
    private CustomerService customerService;


    @Autowired
    public AdminController(BookingService bookingService, CarService carService, CustomerService customerService) {
        this.bookingService = bookingService;
        this.carService = carService;
        this.customerService = customerService;
    }

    @GetMapping("/api/v1/orders")
    public List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @DeleteMapping("/api/v1/deleteorder")
    public ResponseEntity<String> deleteBooking(@RequestBody Booking booking){
        bookingService.deleteBooking(booking.getId());
        return new ResponseEntity<>("Booking with id: " + booking.getId() + " was deleted.", HttpStatus.OK);
    }

    @GetMapping("/api/v1/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        logger.info("admin viewed customers");
        return ResponseEntity.ok(customerService.fetchAllCustomers());
    }
    @PostMapping("/api/v1/addcustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer addedCustomer = customerService.addNewCustomer(customer);
        logger.info("admin added customer with ID " + addedCustomer.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(addedCustomer);
    }


    @PutMapping("/api/v1/updatecustomer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        long id = customer.getId();
        logger.info("admin updated customer with ID " + customer.getId());
        return ResponseEntity.ok(customerService.updateCustomer(id, customer));
    }

    @DeleteMapping("/api/v1/deletecustomer")
    public ResponseEntity<String> deleteCustomer(@RequestBody Customer customer) {
        customerService.deleteCustomer(customer.getId());
        logger.info("admin deleted customer with ID " + customer.getId());
        return new ResponseEntity<>("Customer with id " + customer.getId()+  " was deleted.", HttpStatus.OK);

    }

    @GetMapping("/api/v1/allcars")
    public List<Car> getAllCars(){
        System.out.println(carService.getAllCars());
        return carService.getAllCars();
    }

    @PostMapping("/api/v1/addcar")
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        Car addedCar = carService.addCar(car);
        logger.info("admin added car with ID " + addedCar.getId());
        return new ResponseEntity<>(addedCar, HttpStatus.CREATED);
    }

    @PutMapping("/api/v1/updatecar")
    public ResponseEntity<Car> updateCar(@RequestBody Car car){
        int id = car.getId();
        logger.info("admin updated car with ID " + car.getId());
        return ResponseEntity.ok(carService.updateCar(id, car));
    }

    @DeleteMapping("/api/v1/deletecar")
    public ResponseEntity<String> deleteCar(@RequestBody Car car){
        carService.deleteCar(car.getId());
        logger.info("admin deleted car with ID " + car.getId());
        return new ResponseEntity<>("Car with id: " + car.getId() + " was deleted!", HttpStatus.OK);
    }
}
