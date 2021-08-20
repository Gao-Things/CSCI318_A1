package com.example.csci318_a1.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Contact")
public class Contact implements Cloneable {
    @Id
    private String phone;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyName")
    private Customer customer;

    public Contact() { }

    public Contact(String phone, String name, String email, String position) {
        this.phone = phone;
        this.name = name;
        this.email = email;
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPosition() {
        return position;
    }

    public void setPhone(String phone) {
        try {
            this.phone = phone;
        }catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("The phone number should be unique");
        }
    }

    public void setName(String name) {
        if(name != null && !name.equals(""))
        {
            this.name = name;
        }
    }

    public void setEmail(String email) {
        if(email != null && !email.equals(""))
        {
            this.email = email;
        }
    }

    public void setPosition(String position) {
        if(position != null && !position.equals(""))
        {
            this.position = position;
        }
    }

    /*public Customer getCustomer() {
        return customer;
    }*/

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Contact clone()
    {
        Contact c = null;
        try {
            c = (Contact) super.clone();
        }catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("The contact with phone = /'" + phone + "/' clone fails");
        }
        return c;
    }

    public void reSetContact(String phone, String name, String email, String position)
    {
        setPhone(phone);
        setName(name);
        setEmail(email);
        setPosition(position);
    }

    public static Contact findContectByPhone(String phone, List<Contact> List)
    {
        for(Contact contact:List)
        {
            if(contact.getPhone().equals(phone))
            {
                return contact;
            }
        }
        return null;
    }

    public void printContact(int numOfTab)
    {
        String tab = "";
        for(int i = 0; i < numOfTab; i++)
        {
            tab += "\t";
        }
        System.out.println(tab + "Phone: \t\t" + phone );
        System.out.println(tab + "Name: \t\t" + name);
        System.out.println(tab + "E-mail: \t" + email);
        System.out.println(tab + "Position: \t" + position);
    }
}
