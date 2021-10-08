package com.example.bankaccountapp.dto;

import com.example.bankaccountapp.model.City;
import com.example.bankaccountapp.model.Currency;

public class UpdateAccountRequest extends BaseAccountRequest{
    public UpdateAccountRequest() {
    }

    public UpdateAccountRequest(String customerId, Double balance, City city, Currency currency) {
        super(customerId, balance, city, currency);
    }
}
