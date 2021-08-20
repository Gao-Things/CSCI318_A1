package com.CSIT318group2.Task1.service;

import com.CSIT318group2.Task1.entity.Contact;
import com.CSIT318group2.Task1.entity.Customer;

import java.util.List;

public interface CustomerServiceInterface {

    public Customer saveCustomer(Customer customer);

    public List<Customer> fetchCustomerList();

    public Customer fetchCustomerById(Long customerId);

    public Customer fetchCustomerContact(Long customerId);

    public Customer saveContact(Long customerId, Contact contact);
}
