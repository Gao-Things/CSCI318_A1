package com.CSIT318group2.Task1.controller;

import com.CSIT318group2.Task1.entity.Contact;
import com.CSIT318group2.Task1.entity.Customer;
import com.CSIT318group2.Task1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/customers")
    public List<Customer> fetchCustomerList() {
        return customerService.fetchCustomerList();
    }

    @GetMapping("/customers/{id}")
    public Customer fetchCustomerById(@PathVariable("id") Long customerId) {
        return customerService.fetchCustomerById(customerId);
    }

    @PutMapping("/customers/{id}/contact")
    public Customer saveContact(@PathVariable("id") Long customerId, @RequestBody Contact contact) {
        return customerService.saveContact(customerId, contact);
    }
}
