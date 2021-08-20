package com.example.csci318_a1.service;

import com.example.csci318_a1.domain.Contact;
import com.example.csci318_a1.domain.Customer;

import java.util.List;

public interface CustomerService {
    public void test1();
    public void test2();
    public void test3();
    public String createCustomerBasic(String companyName, String address, String country);
    public String updateCustomerBasic(String companyNameOriginal , String companyNameNew, String address, String country);
    public String createContact(String companyName, String phone, String name, String email, String country);
    public String updateContact(String companyName, String phoneOriginal, String phoneNew, String name, String email, String country);
    public Customer findACustomerByCompanyName(String companyName1);
    public List<Customer> findAllCustomers();
    public Contact findAContactByPhone(String phone);
    public List<Contact> findAllContacts();
}
