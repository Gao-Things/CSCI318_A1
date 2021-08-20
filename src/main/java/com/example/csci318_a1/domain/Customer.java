package com.example.csci318_a1.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer implements Cloneable {
    @Id
    private String companyName;
    @Column
    private String address;
    @Column
    private String country;
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Contact> contactList;

    public Customer() {contactList = new ArrayList<>();}

    public Customer(String companyName, String address, String country) {
        this.companyName = companyName;
        this.address = address;
        this.country = country;
        contactList = new ArrayList<Contact>() {};
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        if(companyName != null && !companyName.equals(""))
        {
            this.companyName = companyName;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if(address != null && !address.equals(""))
        {
            this.address = address;
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if(country != null && !country.equals(""))
        {
            this.country = country;
        }
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public Customer clone()
    {
        Customer c = null;
        try {
            c = (Customer) super.clone();
            c.setContactList(new ArrayList<>());
            for(Contact contact:contactList)
            {
                c.getContactList().add(contact.clone());
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("The customer with company name = /'" + companyName + "/' clone fails");
        }
        return c;
    }

    public Contact findContectByPhone(String phone)
    {
        return Contact.findContectByPhone(phone, contactList);
    }

    public void addContect(Contact contact)
    {
        Contact contact1 = findContectByPhone(contact.getPhone());
        if(contact1 == null)
        {
            contact.setCustomer(this);
            contactList.add(contact);
        }
        else
        {
            System.out.println("The contact has already been added to the customer.");
            contact.printContact(1);
        }
    }

    public void addContect(String phone, String name, String email, String position)
    {
        Contact contact = new Contact(phone, name, email, position);
         addContect(contact);
    }

    public void reSetBasicInfo(String companyName, String address, String country)
    {
        setCompanyName(companyName);
        setAddress(address);
        setCountry(country);
    }

    public void printBasicInfo(int numOfTab)
    {
        String tab = tab(numOfTab);
        System.out.println(tab + "Company: \t" + companyName );
        System.out.println(tab + "Address: \t" + address);
        System.out.println(tab + "Country: \t" + country);
    }

    public void printContactList(int numOfTab)
    {
        String tab = tab(numOfTab);
        numOfTab++;
        System.out.println(tab + "Contect List: ");
        for (Contact contact:contactList)
        {
            contact.printContact(numOfTab);
        }
    }

    public void printCustomer(int numOfTab)
    {
        printBasicInfo(numOfTab);
        printContactList(numOfTab);
    }

    private String tab (int numOfTab)
    {
        String tab = "";
        for(int i = 0; i < numOfTab; i++)
        {
            tab += "\t";
        }
        return tab;
    }

    //not sure if they would be useful in the next assignment
    /*
    //一定一定不能叫get方法 不然会错误执行
    public Customer findBasicInfo()
    {
        return new Customer(companyName, address, country);
    }

    public void reSetCustomer(String companyName, String address, String country, List<Contact> list)
    {
        reSetBasicInfo(companyName, address, country);
        contactList.clear();
        for(Contact contact : list)
        {
            addContect(contact);
        }
    }

    public static Customer findCustomerByCompanyName(String companyName, List<Customer> List)
    {
        for(Customer customer:List)
        {
            if(customer.getCompanyName().equals(companyName))
            {
                return customer;
            }
        }
        return null;
    }

    public void reSetContact(String phone1, String phone2, String name, String email, String position)
    {
        Contact contact1 = findContectByPhone(phone1);
        Contact contact2 = findContectByPhone(phone1);
        if(contact1 != null && contact2 == null)
        {
            contact1.reSetContact(phone2, name, email, position);
        }
        else
        {
            System.out.println("No contact information is found by phone number" + phone1 + " or the contact with phone " +
                    "number " + phone2 + "has been added to the account");
        }
    }

    public void reSetCustomer(String companyName, String address, String country, String[] phone, String[] name, String[] email, String[] position)
    {
        if(phone.length == name.length && phone.length == email.length && phone.length == position.length)
        {
            reSetBasicInfo(companyName, address, country);
            contactList.clear();
            for(int i = 0; i < phone.length; i++)
            {
                addContect(phone[i], name[i], email[i], position[i]);
            }
        }
        else
        {
            System.out.println("There are some errors with the inputs of the contact information.");
        }
    }
    */
}
