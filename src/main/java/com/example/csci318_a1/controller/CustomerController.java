package com.example.csci318_a1.controller;


import com.example.csci318_a1.domain.Customer;
import com.example.csci318_a1.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private  CustomerService customerService;


    /*@RequestMapping("/test5")
    @ResponseBody
    public List<Customer> test5()
    {
        customerService.createCustomerBasic("companyName", "address", "country");
        customerService.createCustomerBasic("companyNameA", "addressA", "countryA");
        return customerService.findAllCustomers();
    }
    @RequestMapping("/test5-1")
    @ResponseBody
    public String test51()
    {
        return customerService.createCustomerBasic("companyName", "address", "country");
    }

    @RequestMapping("/test6")
    @ResponseBody
    public List<Customer> test6()
    {
        customerService.updateCustomerBasic("companyName", "companyName","addressNew", "country");
        return customerService.findAllCustomers();
    }

    @RequestMapping("/test6-1")
    @ResponseBody
    public String test61()
    {
        return customerService.updateCustomerBasic("companyName1", "companyName","addressNew", "country");
    }
    //if this one is tested, the later ones would not be successful because the companyName has been changed
    @RequestMapping("/test6-2")
    @ResponseBody
    public String test62()
    {
        return customerService.updateCustomerBasic("companyName", "companyNameNew","address", "country");
    }

    @RequestMapping("/test7")
    @ResponseBody
    public List<Customer> test7()
    {
        customerService.createContact("companyName", "phone", "name", "email", "position");
        customerService.createContact("companyNameA", "phoneA", "nameA", "emailA", "positionA");
        return customerService.findAllCustomers();
    }

    @RequestMapping("/test7-1")
    @ResponseBody
    public String test71()
    {
        return  customerService.createContact("companyName1", "phone", "name1", "email", "position");
    }

    @RequestMapping("/test7-2")
    @ResponseBody
    public String test72()
    {
        return  customerService.createContact("companyName", "phoneA", "name1", "email", "position");
    }

    @RequestMapping("/test8")
    @ResponseBody
    public List<Customer> test8()
    {
        customerService.updateContact("companyName", "phone", "phone", "nameNew", "email", "position");
        return customerService.findAllCustomers();
    }

    @RequestMapping("/test8-1")
    @ResponseBody
    public String test81()
    {
        return customerService.updateContact("companyName1", "phone", "phone", "nameNew", "email", "position");
    }
    @RequestMapping("/test8-2")
    @ResponseBody
    public String test82()
    {
        return customerService.updateContact("companyName", "phone1", "phone", "nameNew", "email", "position");
    }

    @RequestMapping("/test8-3")
    @ResponseBody
    public String test83()
    {
        return customerService.updateContact("companyName", "phoneA", "phone", "nameNew", "email", "position");
    }

    @RequestMapping("/test8-4")
    @ResponseBody
    public String test84()
    {
        return customerService.updateContact("companyName", "phone", "phoneNew", "nameNew", "email", "position");
    }*/

    @GetMapping(path = "/createCustomerBasic", params = {"companyName", "address", "country"})
    public String createCustomerBasic(String companyName, String address, String country)
    {
        return customerService.createCustomerBasic(companyName, address, country);
    }

    @GetMapping(name = "/updateCustomerBasic", params = {"companyNameOriginal", "companyName", "address", "country"})
    public String updateCustomerBasic(String companyNameOriginal, String companyName, String address, String country)
    {
        return customerService.updateCustomerBasic(companyNameOriginal, companyName, address, country);
    }

    @GetMapping(name = "/createContact", params = {"companyName", "phone", "name", "email", "position"})
    public String createContact(String companyName, String phone, String name, String email, String position)
    {
        return customerService.createContact(companyName, phone, name, email, position);
    }

    @GetMapping(name = "/updateContact", params = {"companyName", "phoneOriginal", "phone", "name", "email", "position"})
    public String updateContact(String companyName, String phoneOriginal, String phone, String name, String email, String position)
    {
        return customerService.updateContact(companyName, phoneOriginal, phone, name, email, position);
    }

    @RequestMapping
    @ResponseBody
    public List<Customer> outputAllCustomerInfo()
    {
        return customerService.findAllCustomers();
    }
}
