package com.example.bankaccountapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {

    private String id;
    private String name;
    private Integer dateOfBirth;
    private CityDTO city;
    private String address;

}
