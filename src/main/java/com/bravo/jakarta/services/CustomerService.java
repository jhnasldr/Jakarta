package com.bravo.jakarta.services;

import com.bravo.jakarta.entities.Customer;
import com.bravo.jakarta.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Customer customerToUpdate;
        Optional<Customer> customerCheck = customerRepository.findById(id);

        if (customerCheck.isPresent()) {
            customerToUpdate = customerCheck.get();
            customerToUpdate.setUsername(customer.getUsername());
            customerToUpdate.setName(customer.getName());
            customerToUpdate.setEmail(customer.getEmail());
            customerToUpdate.setAddress(customer.getAddress());
            customerToUpdate.setPhoneNumber(customer.getPhoneNumber());
            return customerRepository.save(customerToUpdate);
        }

        return null;
    }

    @Override
    public void deleteCustomer(Long id) {
        /*customerRepository.findById(id).orElseThrow();*/
        customerRepository.deleteById(id);
    }
}
