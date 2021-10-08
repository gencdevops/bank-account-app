package com.example.bankaccountapp.converter;

import com.example.bankaccountapp.dto.AccountDTO;
import com.example.bankaccountapp.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDtoConverter {
    public AccountDTO toAccountDTO(Account account) {

        return AccountDTO.builder()
                .id(account.getId())
                .balance(account.getBalance())
                .currency(account.getCurrency())
                .customerId(account.getCustomerId())
                .build();

    }

}
