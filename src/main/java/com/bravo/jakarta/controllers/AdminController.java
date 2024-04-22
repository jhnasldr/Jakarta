package com.bravo.jakarta.controllers;

import com.bravo.jakarta.entities.Booking;
import com.bravo.jakarta.entities.Car;
import com.bravo.jakarta.entities.Customer;
import com.bravo.jakarta.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
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
        return ResponseEntity.ok(customerService.fetchAllCustomers());
    }

    @PostMapping("/api/v1/addcustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.addNewCustomer(customer), HttpStatus.CREATED);
    }

    @PutMapping("/api/v1/updatecustomer/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId, @RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.updateCustomer(customerId, customer));
    }

    @DeleteMapping("/api/v1/deletecustomer/{customerId}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok("Customer with id " + customerId + " was deleted.");

    }

    @GetMapping("/api/v1/allcars")
    public List<Car> getAllCars(){
        System.out.println(carService.getAllCars());
        return carService.getAllCars();
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
    public ResponseEntity<String> deleteCar(@RequestBody Car car){
        carService.deleteCar(car.getId());
        return new ResponseEntity<>("Car with id: " + car.getId() + " was deleted!", HttpStatus.OK);
    }
}
