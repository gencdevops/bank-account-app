package com.example.bankaccountapp.controller;

import com.example.bankaccountapp.dto.CreateCustomerRequest;
import com.example.bankaccountapp.dto.CustomerDTO;
import com.example.bankaccountapp.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }




    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CreateCustomerRequest customerRequest) {
    return ResponseEntity.ok(customerService.createCustomer(customerRequest));
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
       return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable String id) {
    return ResponseEntity.ok(customerService.getCustomerById(id));
    }



}
