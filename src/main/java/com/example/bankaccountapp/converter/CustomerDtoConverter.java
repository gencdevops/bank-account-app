package com.example.bankaccountapp.converter;

import com.example.bankaccountapp.dto.CityDTO;
import com.example.bankaccountapp.dto.CustomerDTO;
import com.example.bankaccountapp.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConverter {
    public  CustomerDTO toCustomerDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setCity(CityDTO.valueOf(customer.getCity().name()));
        customerDTO.setName(customer.getName());
        customerDTO.setDateOfBirth(customer.getDateOfBirth());

        return customerDTO;
    }
}
