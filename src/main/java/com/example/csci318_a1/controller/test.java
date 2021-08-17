package com.example.csci318_a1.controller;

import com.example.csci318_a1.Dao.ContactDao;
import com.example.csci318_a1.Dao.CustomerDao;
import com.example.csci318_a1.domain.Contact;
import com.example.csci318_a1.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
class test {

    @Autowired
    ContactDao contactDao;
    @Autowired
    CustomerDao customerDao;
    @RequestMapping("/test1")
    public String test1() {
        Contact contact1 = new Contact("9553121", "test_name", "test_email", "test_position");
        contact1.printContact(0);
        contactDao.save(contact1);
        List<Contact> list = contactDao.findAll();
        System.out.println(list.size());
        return "test case1";
    }
    @RequestMapping("/test2")
    public String test2() {
        Contact contact1 = new Contact("123454321", "test_name", "test_email", "test_position");
        Contact contact2 = new Contact("123454321", "test_name2", "test_email2", "test_position2");
        contact1.printContact(0);
        contact2.printContact(0);
        contactDao.save(contact1);
        contactDao.save(contact2);
        List<Contact> list = contactDao.findAll();
        for(Contact contact : list)
        {
            contact.printContact(1);
        }
        return "test case2";
    }

    @RequestMapping("/test3")
    public String test3()
    {
        Customer customer1 = new Customer("Company name 1", "Address1", "Country 1");
        customerDao.save(customer1);
        return "test case3";
    }
}
