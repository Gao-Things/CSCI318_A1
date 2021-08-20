package com.example.csci318_a1.controller;

import com.example.csci318_a1.Dao.ContactDao;
import com.example.csci318_a1.Dao.CustomerDao;
import com.example.csci318_a1.domain.Contact;
import com.example.csci318_a1.domain.Customer;
import com.example.csci318_a1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private  CustomerService customerService;
    @RequestMapping("/test1")
    public String test1() {

        return "test case1";
    }
    @RequestMapping("/test2")
    public List<Contact> test2() {
        customerService.test2();
        for(Contact Contact:customerService.findAllContacts())
        {
            Contact.printContact(1);
        };
        return customerService.findAllContacts();
    }

    @RequestMapping("/test3")
    @ResponseBody
    public Customer test3()
    {
        customerService.test3();
        customerService.test1();
        return customerService.findACustomerByCompanyName("Company name 1");
    }

    @RequestMapping("/test4")
    @ResponseBody
    public List<Customer> test4()
    {
        customerService.test3();
        for(Customer customer:customerService.findAllCustomers())
        {
            customer.printCustomer(1);
        };
        return customerService.findAllCustomers();
    }
}
