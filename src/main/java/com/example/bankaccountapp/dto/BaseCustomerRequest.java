package com.example.bankaccountapp.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class BaseCustomerRequest {

    private String name;
    private Integer dateOfBirth;
    private CityDTO city;
    private String address;

    public BaseCustomerRequest() {

    }

    public BaseCustomerRequest(String name, Integer dateOfBirth, CityDTO city, String address) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Integer dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
