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
    public String updateCustomerBasic( String companyNameOriginal, String companyNameNew, String address, String country )
    {
        customer = customerDao.findById(companyNameOriginal).orElse(null);
        if(customer != null && !customerDao.existsById(companyNameNew)) {
            if(!companyNameOriginal.equals(companyNameNew))
            {
                customerDao.delete(customer.clone());
            }
            customer.reSetBasicInfo(companyNameNew, address, country);
            customerDao.save(customer);
            return "Update the customer basic information successfully!";
        }
        else
        {
            return "The customer with company name, " + companyNameOriginal + ", is not existed or the customer with " +
                    "company name, " + companyNameOriginal + ", is existed.";
        }

    }

    @Override
    public String createContact(String companyName, String phone, String name, String email, String country)
    {
        customer = customerDao.findById(companyName).orElse(null);
        if(customer != null) {
            if(!contactDao.existsById(phone))
            {
                customer.addContect(phone, name, email, country);
                customerDao.save(customer);
                return "Add a new contact successfully.";
            }
            else
            {
                return "The contact can't be added because the phone number has already been registered by you or another customer.";
            }
        }
        else
        {
            return "The customer with company name, " + companyName + ", is not existed, so you can't add contact to this customer.";
        }
    }

    @Override
    public String updateContact(String companyName, String phoneOriginal, String phoneNew, String name, String email, String position)
    {
        customer = customerDao.findById(companyName).orElse(null);
        if(customer != null) {
            if(contactDao.existsById(phoneOriginal) && !contactDao.existsById(phoneNew))
            {
                Contact contact = customer.findContectByPhone(phoneOriginal);
                if(contact != null)
                {
                    customerDao.delete(customer.clone());
                    contact.reSetContact(phoneNew, name, email, position);
                    customerDao.save(customer);
                    return "Update the contact information successful";
                }
                else
                {
                    return "The customer with company name, " + companyName + " doesn't have the contact with phone number " + phoneOriginal;
                }
            }
            else
            {
                return "The contact with phone number " + phoneOriginal + " isn't existed or the contact with phone number " +
                        phoneNew + " is existed";
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
