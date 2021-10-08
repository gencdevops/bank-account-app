package com.example.bankaccountapp.dto;

import com.example.bankaccountapp.model.City;
import com.example.bankaccountapp.model.Currency;

public class BaseAccountRequest {

    private String customerId;
    private Double balance;
    private City city;
    private Currency currency;

    public BaseAccountRequest() {

    }

    public BaseAccountRequest(String customerId, Double balance, City city, Currency currency) {
        this.customerId = customerId;
        this.balance = balance;
        this.city = city;
        this.currency = currency;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
