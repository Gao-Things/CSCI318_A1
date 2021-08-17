package com.example.csci318_a1;

import com.example.csci318_a1.Dao.ContactDao;
import com.example.csci318_a1.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Csci318A1Application {

    public static void main(String[] args) {
        SpringApplication.run(Csci318A1Application.class, args);
    }

}
