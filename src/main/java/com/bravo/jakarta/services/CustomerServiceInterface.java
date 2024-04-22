package com.bravo.jakarta.services;

import com.bravo.jakarta.entities.Booking;
import com.bravo.jakarta.entities.Customer;

import java.util.List;

public interface CustomerServiceInterface {
    List<Customer> fetchAllCustomers();
    List<Booking> fetchCustomerBookings(Long id);

    Customer addNewCustomer(Customer customer);

    Customer updateCustomer(Long id, Customer customer);

    void deleteCustomer(Long id);
}
