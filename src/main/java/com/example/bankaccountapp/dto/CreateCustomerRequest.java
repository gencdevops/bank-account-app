package com.example.bankaccountapp.dto;

public class CreateCustomerRequest extends BaseCustomerRequest{
    private String id;
    public CreateCustomerRequest() {

    }

    public CreateCustomerRequest(String id) {
        this.id = id;
    }

    public CreateCustomerRequest(String name, Integer dateOfBirth, CityDTO city, String address, String id) {
        super(name, dateOfBirth, city, address);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
