package com.example.bankaccountapp.dto;


import com.example.bankaccountapp.model.City;
import com.example.bankaccountapp.model.Currency;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class CreateAccountRequest extends BaseAccountRequest {

    @NotBlank(message = "Account id must be empty")
    private String id;

    public CreateAccountRequest() {

    }

    public CreateAccountRequest(String customerId, Double balance, City city, Currency currency, String id) {
        super(customerId, balance, city, currency);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
