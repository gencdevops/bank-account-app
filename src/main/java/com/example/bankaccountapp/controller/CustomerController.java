package com.example.bankaccountapp.controller;

import com.example.bankaccountapp.dto.CreateCustomerRequest;
import com.example.bankaccountapp.dto.CustomerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {


    @GetMapping
    public ResponseEntity<String> helloTwitch() {
        return ResponseEntity.ok("hi");
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CreateCustomerRequest customerRequest) {

    }


}
