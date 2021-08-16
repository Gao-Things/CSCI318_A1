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
    //test updating db by JPA (spring.jpa.hibernate.ddl-auto=update) automatically (adding an attribute)
    @Column
    private String testAttribute;
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
}
