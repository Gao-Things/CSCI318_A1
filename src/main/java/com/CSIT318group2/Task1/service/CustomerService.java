package com.CSIT318group2.Task1.service;

import com.CSIT318group2.Task1.entity.Contact;
import com.CSIT318group2.Task1.entity.Customer;
import com.CSIT318group2.Task1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements CustomerServiceInterface {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> fetchCustomerList() {
        return customerRepository.findAll();
    }

    @Override
    public Customer fetchCustomerById(Long customerId) {
        return customerRepository.findById(customerId).get();
    }

    @Override
    public Customer fetchCustomerContact(Long customerId) {
        return customerRepository.findById(customerId).get();
    }

    @Override
    public Customer saveContact(Long customerId, Contact contact) {
        Customer customer = customerRepository.findById(customerId).get();
        customer.setContact(contact);
        return customerRepository.save(customer);
    }
}