package com.azouakan.mymsscbrewery.services;

import com.azouakan.mymsscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CutomerService {
    CustomerDto getCustomerById(UUID customerId);
    
    CustomerDto saveNewCustomer(CustomerDto customerDto);


    void updateCustomer(UUID customerId, CustomerDto customerDto);

    void deleteCustomerById(UUID customerId);
}
