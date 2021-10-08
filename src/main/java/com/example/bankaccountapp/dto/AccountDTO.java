package com.example.bankaccountapp.dto;


import com.example.bankaccountapp.model.Currency;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class AccountDTO {


    private String id;
    private String customerId;
    private Double balance;
    private Currency currency;



}
