package com.bravo.jakarta.services;

import com.bravo.jakarta.entities.Customer;
import com.bravo.jakarta.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements CustomerServiceInterface {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> fetchAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer addNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {



        return null;
    }

    @Override
    public void deleteMember(Long id) {
        /*customerRepository.findById(id).orElseThrow();*/
        customerRepository.deleteById(id);
    }
}
