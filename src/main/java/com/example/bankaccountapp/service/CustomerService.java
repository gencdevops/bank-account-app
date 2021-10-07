package com.example.bankaccountapp.service;

import com.example.bankaccountapp.converter.CustomerDtoConverter;
import com.example.bankaccountapp.dto.CityDTO;
import com.example.bankaccountapp.dto.CreateCustomerRequest;
import com.example.bankaccountapp.dto.CustomerDTO;
import com.example.bankaccountapp.model.City;
import com.example.bankaccountapp.model.Customer;
import com.example.bankaccountapp.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter customerDtoConverter) {
        this.customerRepository = customerRepository;
        this.customerDtoConverter = customerDtoConverter;
    }

    public CustomerDTO createCustomer(CreateCustomerRequest customerRequest) {
    Customer customer = new Customer();
    customer.setId(customerRequest.getId());
    customer.setName(customerRequest.getName());
    customer.setAddress(customerRequest.getAddress());
    customer.setDateOfBirth(customerRequest.getDateOfBirth());
    customer.setCity(City.valueOf(customerRequest.getCity().name()));

    customerRepository.save(customer);

    return customerDtoConverter.toCustomerDTO(customer);

    }

    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();

        return customerList.stream()
                .map(customerDtoConverter::toCustomerDTO)
                .collect(Collectors.toList());
    }

}
