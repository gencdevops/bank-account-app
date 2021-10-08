package com.example.bankaccountapp.model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Customer {
    @Id
    private String id;


    private String name;
    private Integer dateOfBirth;
    private City city;
    private String address;

}
