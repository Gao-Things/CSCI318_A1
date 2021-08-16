package com.example.csci318_a1.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @Column (unique = true)
    private String companyName;
    @Column
    private String address;
    @Column
    private String country;
    /*test updating db by JPA (spring.jpa.hibernate.ddl-auto=update) automatically (adding an attribute)
    @Column
    private String testAttribute;*/
    @OneToMany(mappedBy = "clz")
    private List<Contact> contactList;


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public Contact findContectByPhone(String phone)
    {
        for(Contact contact:contactList)
        {
            if(contact.getPhone().equals(phone))
            {
                return contact;
            }
        }
        return null;
    }

    public void reSetContact(String phone1, String phone2, String name, String email, String position)
    {
        Contact contact = findContectByPhone(phone1);
        if(contact != null)
        {
            contact.setContact(phone2, name, email, position);
        }
        else
        {
            System.out.println("No contact information is found by phone number" + phone1);
        }
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
}
