package com.example.bankaccountapp.runner;

import com.example.bankaccountapp.model.Account;
import com.example.bankaccountapp.model.City;
import com.example.bankaccountapp.model.Customer;
import com.example.bankaccountapp.repository.AccountRepository;
import com.example.bankaccountapp.repository.CustomerRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CustomerRunner implements ApplicationRunner {
    AccountRepository accountRepository;
    CustomerRepository customerRepository;

    public CustomerRunner(AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Customer c1 = Customer.builder()
                .id("123456")
                .name("meah lui")
                .city(City.ISTANBUL)
                .dateOfBirth(1994)
                .build();
        Customer c2 = Customer.builder()
                .id("789456")
                .name("harry may")
                .city(City.ANKARA)
                .dateOfBirth(1997)
                .build();
        Customer c3 = Customer.builder()
                .id("456123")
                .name("lui france")
                .city(City.YOZGAT)
                .dateOfBirth(1993)
                .build();

        customerRepository.saveAll(Arrays.asList(c1, c2, c3));


        Account a1 = Account.builder()
                .id("100")
                .customerId("123456")
                .city(City.ISTANBUL)
                .balance(1320.0)
                .build();

        Account a2 = Account.builder()
                .id("200")
                .customerId("323456")
                .city(City.ISTANBUL)
                .balance(1870.0)
                .build();

        Account a3 = Account.builder()
                .id("105")
                .balance(3128.0)
                .customerId("123456")
                .city(City.ISTANBUL)
                .build();


        accountRepository.saveAll(Arrays.asList(a1,a2,a3));
    }
}
