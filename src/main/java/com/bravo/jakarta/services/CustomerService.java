package com.bravo.jakarta.services;

import com.bravo.jakarta.entities.Customer;
import com.bravo.jakarta.exceptions.ResourceNotFoundException;
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
        if (customer.getEmail() == null) {
            throw new IllegalArgumentException("Email can not be null or empty");
        }
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Customer customerToUpdate = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "ID", id));

        if (customer.getUsername() != null) {
            customerToUpdate.setUsername(customer.getUsername());
        }
        if (customer.getName() != null) {
            customerToUpdate.setName(customer.getName());
        }
        if (customer.getEmail() != null) {
            customerToUpdate.setEmail(customer.getEmail());
        }
        if (customer.getAddress() != null) {
            customerToUpdate.setAddress(customer.getAddress());
        }
        if (customer.getPhoneNumber() != null) {
            customerToUpdate.setPhoneNumber(customer.getPhoneNumber());
        }

        return customerRepository.save(customerToUpdate);
    }


    @Override
    public void deleteCustomer(Long id) {
        customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "ID", id));
        customerRepository.deleteById(id);
    }
}
