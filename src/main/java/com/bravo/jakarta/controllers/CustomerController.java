package com.bravo.jakarta.controllers;

import com.bravo.jakarta.entities.Customer;
import com.bravo.jakarta.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

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
        customerService.deleteMember(customerId);
        return ResponseEntity.ok("Customer with id " + customerId + " was deleted.");

    }
}
