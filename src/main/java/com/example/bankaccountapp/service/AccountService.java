package com.example.bankaccountapp.service;

import com.example.bankaccountapp.converter.AccountDtoConverter;
import com.example.bankaccountapp.dto.AccountDTO;
import com.example.bankaccountapp.dto.CreateAccountRequest;
import com.example.bankaccountapp.dto.UpdateAccountRequest;
import com.example.bankaccountapp.model.Account;
import com.example.bankaccountapp.model.Customer;
import com.example.bankaccountapp.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountDtoConverter accountDtoConverter;


    public AccountService(AccountRepository accountRepository,
                          CustomerService customerService,
                          AccountDtoConverter accountDtoConverter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.accountDtoConverter = accountDtoConverter;
    }

    public AccountDTO createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.getCustomersById(createAccountRequest.getCustomerId());
        if (customer.getId() == null || customer.getId().equals(""))
            return AccountDTO.builder().build();

        Account account = Account.builder()
                .id(createAccountRequest.getId())
                .balance(createAccountRequest.getBalance())
                .currency(createAccountRequest.getCurrency())
                .customerId(createAccountRequest.getCustomerId())
                .city(createAccountRequest.getCity())
                .build();
        return accountDtoConverter.toAccountDTO(accountRepository.save(account));
    }

    public AccountDTO updateAccount(String id, UpdateAccountRequest request) {
        Customer customer = customerService.getCustomersById(request.getCustomerId());
        if (customer.getId() == null || customer.getId().equals(""))
            return AccountDTO.builder().build();

        Optional<Account> accountOptional = accountRepository.findById(id);
        accountOptional.ifPresent(account -> {
            account.setBalance(request.getBalance());
            account.setCity(request.getCity());
            account.setCurrency(request.getCurrency());
            account.setCustomerId(request.getCustomerId());
            accountRepository.save(account);
        });

        return accountOptional.map(accountDtoConverter::toAccountDTO).orElse(new AccountDTO());
    }

    public List<AccountDTO> getAllAccounts() {
        List<Account> accountList = accountRepository.findAll();

        return accountList.stream()
                .map(accountDtoConverter::toAccountDTO)
                .collect(Collectors.toList());

    }

    public AccountDTO getAccountById(String id) {
        return accountRepository.findById(id)
                .map(accountDtoConverter::toAccountDTO)
                .orElse(new AccountDTO());
    }

    public void deleteAccount(String id) {
        accountRepository.deleteById(id);
    }

    public AccountDTO withdrawMoney(String id, Double amount) {
        Optional<Account> accountOpt = accountRepository.findById(id);
        accountOpt.ifPresent(account -> {
            if (account.getBalance() > amount) {
                account.setBalance(account.getBalance() - amount);
                accountRepository.save(account);
            }

        });

        return accountOpt.map(accountDtoConverter::toAccountDTO).orElse(new AccountDTO());
    }

    public AccountDTO addMoney(String id, Double amount) {
        Optional<Account> accountOpt = accountRepository.findById(id);
        accountOpt.ifPresent(account -> {
            account.setBalance(account.getBalance() + amount);
            accountRepository.save(account);
        });

        return accountOpt.map(accountDtoConverter::toAccountDTO).orElse(new AccountDTO());
    }


}
