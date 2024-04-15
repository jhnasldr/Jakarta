package com.bravo.jakarta.controllers;

import com.bravo.jakarta.entities.Booking;
import com.bravo.jakarta.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

    @DeleteMapping("/api/v1/deleteorder/{id}")
    public ResponseEntity<Booking> deleteBooking(@PathVariable Long id){
        bookingService.deleteBooking(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
