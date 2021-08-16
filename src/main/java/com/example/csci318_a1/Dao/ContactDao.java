package com.example.csci318_a1.Dao;

import com.example.csci318_a1.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDao extends JpaRepository<Contact,String> {
}
