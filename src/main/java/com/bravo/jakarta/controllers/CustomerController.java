package com.bravo.jakarta.controllers;

import com.bravo.jakarta.dto.OrdersDto;
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
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/api/v1/ordercar")
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking){
        Booking addedBooking = bookingService.addBooking(booking);
        if (addedBooking == null) {
            logger.info("Customer with id: " + booking.getCustomer().getId() + " tried to order car with id: " + booking.getCar().getId() + " but did not succeed");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }else{
            logger.info("Customer with id: " + booking.getCustomer().getId() + " ordered car with id: " + booking.getCar().getId());
            return ResponseEntity.ok(addedBooking);
        }
    }

    @GetMapping("/api/v1/myorders")
//    public ResponseEntity<List<Booking>> getCustomerOrders(@RequestBody Customer customer) {
    public ResponseEntity<OrdersDto> getCustomerOrders(@RequestBody Customer customer) {
        logger.info("customer with id " + customer.getId() + " viewed their orders");
        return ResponseEntity.ok(new OrdersDto(customerService.fetchCustomerBookings(customer.getId())));
//        return ResponseEntity.ok(customerService.fetchCustomerBookings(customer.getId()));
    }

    @PutMapping("/api/v1/cancelorder")
    public ResponseEntity<String> cancelBooking(@RequestBody Booking booking) {
        Long id = booking.getId();
        bookingService.cancelBooking(id);
        logger.info("customer cancelled booking with ID " + id);
        String message = "Booking with ID " + id + " has been cancelled.";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}

