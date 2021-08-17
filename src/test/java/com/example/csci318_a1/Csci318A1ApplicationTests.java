package com.example.csci318_a1;

import com.example.csci318_a1.Dao.ContactDao;
import com.example.csci318_a1.Dao.CustomerDao;
import com.example.csci318_a1.domain.Contact;
import com.example.csci318_a1.domain.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Csci318A1ApplicationTests {

    @Autowired
    ContactDao contactDao;
    @Test
    void test1() {
        Contact contact1 = new Contact("9553121", "test_name", "test_email", "test_position");
        contact1.printContact(0);
        contactDao.save(contact1);
        List<Contact> list = contactDao.findAll();
        System.out.println(list.size());
    }
    @Test
    void test2() {
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
    }
    @Autowired
    CustomerDao customerDao;
    @Test
    void test3()
    {
        Customer customer1 = new Customer("Company name 1", "Address1", "Country 1");
        customerDao.save(customer1);
    }


}
