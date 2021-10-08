package com.example.bankaccountapp.dto;


import com.example.bankaccountapp.model.City;
import com.example.bankaccountapp.model.Currency;
import lombok.Builder;



public class CreateAccountRequest extends BaseAccountRequest{
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
