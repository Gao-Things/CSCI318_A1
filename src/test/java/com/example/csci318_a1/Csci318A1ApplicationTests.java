package com.example.csci318_a1;


import com.example.csci318_a1.controller.TestController;
import com.example.csci318_a1.domain.Customer;
import com.example.csci318_a1.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;


@SpringBootTest
class Csci318A1ApplicationTests {


    @Autowired
    private TestController t1;

    @Test
    void test4()
    {
        Customer temp = t1.test3();
    }

    @Test
    void  test5()
    {
        List<Customer> customerList = t1.test4();
        for(Customer customer:customerList)
        {
            customer.printCustomer(1);
        }
    }
}
