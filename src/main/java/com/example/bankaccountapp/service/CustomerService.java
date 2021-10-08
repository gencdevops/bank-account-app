package com.example.bankaccountapp.service;

import com.example.bankaccountapp.converter.CustomerDtoConverter;
import com.example.bankaccountapp.dto.CityDTO;
import com.example.bankaccountapp.dto.CreateCustomerRequest;
import com.example.bankaccountapp.dto.CustomerDTO;
import com.example.bankaccountapp.dto.UpdateCustomerRequest;
import com.example.bankaccountapp.model.City;
import com.example.bankaccountapp.model.Customer;
import com.example.bankaccountapp.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
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

    public CustomerDTO getCustomerById(String id) {
        Optional<Customer> customerOpt = customerRepository.findById(id);
       return customerOpt.map(customerDtoConverter::toCustomerDTO)
               .orElse(new CustomerDTO());
    }

    public void deleteCustomer(String id) {
    customerRepository.deleteById(id);

    }



    public CustomerDTO updateCustomer(String id, UpdateCustomerRequest customerRequest) {
    Optional<Customer> customerOptional = customerRepository.findById(id);

    customerOptional.ifPresent(customer -> {
        customer.setName(customerRequest.getName());
        customer.setDateOfBirth(customerRequest.getDateOfBirth());
        customer.setCity(City.valueOf(customerRequest.getCity().name()));
        customer.setAddress(customerRequest.getAddress());
        customerRepository.save(customer);
    });
    return customerOptional.map(customerDtoConverter::toCustomerDTO)
            .orElse(new CustomerDTO());

    }

    protected Customer getCustomersById(String id) {
        return customerRepository.findById(id).orElse(new Customer());
    }

}
