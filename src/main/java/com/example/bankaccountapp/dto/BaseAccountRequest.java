package com.example.bankaccountapp.dto;

import com.example.bankaccountapp.model.City;
import com.example.bankaccountapp.model.Currency;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BaseAccountRequest {
    @NotBlank(message = "Customer id must not be null")
    private String customerId;

    @NotNull
    @Min(0)
    private Double balance;

    @NotNull(message = "Currency must not be null")
    private Currency currency;

    @NotNull(message = "City must not be null")
    private City city;


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
