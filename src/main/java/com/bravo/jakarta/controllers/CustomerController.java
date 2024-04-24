package com.bravo.jakarta.controllers;

import com.bravo.jakarta.entities.Booking;
import com.bravo.jakarta.entities.Car;
import com.bravo.jakarta.entities.Customer;
import com.bravo.jakarta.services.BookingService;
import com.bravo.jakarta.services.CarService;
import com.bravo.jakarta.services.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private BookingService bookingService;
    private CarService carService;
    private CustomerService customerService;
    private static final Logger logger = Logger.getLogger(CustomerController.class);

    @Autowired
    public CustomerController(BookingService bookingService, CarService carService, CustomerService customerService) {
        this.bookingService = bookingService;
        this.carService = carService;
        this.customerService = customerService;
    }

    @GetMapping("/api/v1/cars") 
    public List<Car> getAvailableCars(){
        System.out.println(carService.getAvailableCars());
        return carService.getAvailableCars();
    }
    @GetMapping("/api/v1/myorders")
    public ResponseEntity<List<Booking>> getCustomerOrders(@RequestBody Customer customer) {
        logger.info("customer with id " + customer.getId() + " viewed their orders");
        return ResponseEntity.ok(customerService.fetchCustomerBookings(customer.getId()));
    }

    @PutMapping("/api/v1/cancelbooking")
    public ResponseEntity<String> cancelBooking(@RequestBody Booking booking) {
        Long id = booking.getId();
        bookingService.cancelBooking(id);
        String message = "Booking with ID " + id + " has been cancelled.";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
