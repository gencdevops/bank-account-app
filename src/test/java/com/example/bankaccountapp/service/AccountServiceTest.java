package com.example.bankaccountapp.service;

import com.example.bankaccountapp.converter.AccountDtoConverter;
import com.example.bankaccountapp.dto.AccountDTO;
import com.example.bankaccountapp.dto.CreateAccountRequest;
import com.example.bankaccountapp.model.Account;
import com.example.bankaccountapp.model.City;
import com.example.bankaccountapp.model.Currency;
import com.example.bankaccountapp.model.Customer;
import com.example.bankaccountapp.repository.AccountRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AccountServiceTest {
    private AccountService accountService;
    private AccountRepository accountRepository;
    private CustomerService customerService;
    private AccountDtoConverter accountDtoConverter;


    @org.junit.Before
    public void setUp() throws Exception {
        accountRepository = Mockito.mock(AccountRepository.class);
        customerService = Mockito.mock(CustomerService.class);
        accountDtoConverter = Mockito.mock(AccountDtoConverter.class);

        accountService = new AccountService(accountRepository, customerService, accountDtoConverter);

    }

    @Test
    public void whenCreateAccountCalledWithValidRequest_itShouldReturnValidAccountDto() {
        CreateAccountRequest createAccountRequest = new CreateAccountRequest();
        createAccountRequest.setId("1234");
        createAccountRequest.setCustomerId("12345");
        createAccountRequest.setBalance(100.0);
        createAccountRequest.setCity(City.ISTANBUL);
        createAccountRequest.setCurrency(Currency.TRY);

        Customer customer = Customer.builder()
                .id("1234")
                .address("Adres")
                .city(City.ISTANBUL)
                .dateOfBirth(2001)
                .name("Selius Kui")
                .build();

        Account account = Account.builder()
                .id(createAccountRequest.getId())
                .balance(createAccountRequest.getBalance())
                .currency(createAccountRequest.getCurrency())
                .customerId(createAccountRequest.getCustomerId())
                .city(createAccountRequest.getCity())
                .build();

        AccountDTO accountDTO = AccountDTO.builder()
                .id("1234")
                .customerId("12345")
                .currency(Currency.TRY)
                .balance(100.0)
                .build();

        Mockito.when(customerService.getCustomersById("12345")).thenReturn(customer);
        Mockito.when(accountRepository.save(account)).thenReturn(account);
        Mockito.when(accountDtoConverter.toAccountDTO(account)).thenReturn(accountDTO);

        AccountDTO result = accountService.createAccount(createAccountRequest);
        Assert.assertEquals(result, accountDTO);

        Mockito.verify(customerService).getCustomersById("12345");
        Mockito.verify(accountRepository).save(account);
        Mockito.verify(accountDtoConverter).toAccountDTO(account);




    }


}