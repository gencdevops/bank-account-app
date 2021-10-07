package com.example.bankaccountapp.dto;




public class UpdateCustomerRequest extends BaseCustomerRequest{


    public UpdateCustomerRequest() {
    }

    public UpdateCustomerRequest(String name, Integer dateOfBirth, CityDTO city, String address) {
        super(name, dateOfBirth, city, address);
    }
}
