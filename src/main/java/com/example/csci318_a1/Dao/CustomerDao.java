package com.example.csci318_a1.Dao;

import com.example.csci318_a1.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer,String> {
}
