package com.bravo.jakarta.services;

import com.bravo.jakarta.entities.Customer;

import java.util.List;

public interface CustomerServiceInterface {
    List<Customer> fetchAllCustomers();

    Customer addNewCustomer(Customer customer);

    Customer updateCustomer(Long id, Customer customer);

    void deleteCustomer(Long id);
}
