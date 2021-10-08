package com.example.bankaccountapp.repository;

import com.example.bankaccountapp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {

}
