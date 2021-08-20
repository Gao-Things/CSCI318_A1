package com.example.csci318_a1.service.impl;

import com.example.csci318_a1.Dao.ContactDao;
import com.example.csci318_a1.Dao.CustomerDao;
import com.example.csci318_a1.domain.Contact;
import com.example.csci318_a1.domain.Customer;
import com.example.csci318_a1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private ContactDao contactDao;
    private Customer customer = new Customer();

    @Override
    public void test1() {
        Contact contact1 = new Contact("9553121", "test_name", "test_email", "test_position");
        customer.addContect(contact1);
        contactDao.save(contact1);
    }

    @Override
    public void test2() {
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


    @Override
    public void test3(){
        customer.reSetBasicInfo("Company name 1", "Address1", "Country 1");
        customer.addContect("123456789", "test_name1", "test_email1", "test_position1");
        customer.addContect("987654321", "test_name2", "test_email2", "test_position2");
        customerDao.save(customer);
    }

    @Override
    public String createCustomerBasic( String companyName, String address, String country)
    {
        customer = customerDao.findById(companyName).orElse(null);
        if(customer == null) {
            customerDao.save(new Customer(companyName, address, country));
            customerDao.flush();
            return "Create a customer successfully!";
        }
        else
        {
            return ("The customer with company name, " + companyName + ", has already been registered.");
        }
    }

    @Override
    public String updateCustomerBasic( String companyNameOriginal , String companyNameNew, String address, String country )
    {
        customer = customerDao.findById(companyNameOriginal).orElse(null);
        if(customer != null) {
            if(companyNameOriginal.equals(companyNameNew))
            {
                customerDao.delete(customer);
            }
            customer.reSetBasicInfo(companyNameNew, address, country);
            customerDao.save(customer);
            return "Update the customer basic information successfully!";
        }
        else
        {
            return "The customer with company name, " + companyNameOriginal + ", is not existed.";
        }

    }

    @Override
    public String createContact(String companyName, String phone, String name, String email, String country)
    {
        customer = customerDao.findById(companyName).orElse(null);
        if(customer != null) {
            Contact contact =  contactDao.findById(phone).orElse(null);
            if(contact != null)
            {
                customer.addContect(phone, name, email, country);
                customerDao.save(customer);
                return "Add a new contact successfully.";
            }
            else
            {
                return "The contact can't be added because the phone number has already been registered by another contact.";
            }
        }
        else
        {
            return "The customer with company name, " + companyName + ", is not existed, so you can't add contact to this customer.";
        }
    }

    @Override
    public String updateContact(String companyName, String phoneOriginal, String phoneNew, String name, String email, String country)
    {
        customer = customerDao.findById(companyName).orElse(null);
        if(customer != null) {
            int flag = customer.addContect()
            if(contact != null)
            {
                contact.reSetContact(phoneNew, name, email, country);
                contactDao.save(contact);
                return "Update the contact information successful";
            }
            else
            {
                return "The customer with company name, " + companyName + "doesn't have the contact with phone number " + phoneOriginal;
            }
        }
        else
        {
            return "The customer with company name, " + companyName + ", is not existed, so you can't add contact to this customer.";
        }
    }


    public Customer findACustomerByCompanyName(String companyName)
    {
        Customer result = customerDao.findById(companyName).orElse( new Customer() );
        result.printCustomer(1);
        return result;
    }

    @Override
    public List<Customer> findAllCustomers()
    {
        return customerDao.findAll();
    }

    @Override
    public Contact findAContactByPhone(String phone)
    {
        return contactDao.findById(phone).orElse( new Contact() );
    }

    @Override
    public List<Contact> findAllContacts()
    {
        return contactDao.findAll();
    }

}
