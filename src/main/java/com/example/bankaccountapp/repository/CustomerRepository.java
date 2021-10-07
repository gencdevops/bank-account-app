package com.example.bankaccountapp.repository;

import com.example.bankaccountapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {



}
