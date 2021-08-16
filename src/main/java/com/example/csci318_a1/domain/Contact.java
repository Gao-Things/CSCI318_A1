package com.example.csci318_a1.domain;

import javax.persistence.*;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String phone;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String position;
    @ManyToOne
    @JoinColumn(name = "companyName")
    private Customer clz;

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
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setContact(String phone, String name, String email, String position)
    {
        if(phone != null && phone != "")
        {
            setPhone(phone);
        }
        if(name != null && name != "")
        {
            setPhone(name);
        }
        if(email != null && email != "")
        {
            setPhone(email);
        }
        if(position != null && position != "")
        {
            setPhone(position);
        }
    }

    public void printContact(int numOfTab)
    {
        String tab = "";
        for(int i = 0; i < numOfTab; i++)
        {
            tab += "\t";
        }
        System.out.println(tab + "Phone: \t" + name );
        System.out.println(tab + "Name: \t" + phone);
        System.out.println(tab + "E-mail: \t" + email);
        System.out.println(tab + "Position: \t" + position);
    }
}
