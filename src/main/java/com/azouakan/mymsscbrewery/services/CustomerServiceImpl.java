package com.azouakan.mymsscbrewery.services;

import com.azouakan.mymsscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements  CutomerService{
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("first Customer")
                .build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        log.info("Customer updated !!");
    }

    @Override
    public void deleteCustomerById(UUID customerId) {
        log.info("Deleting Customer...");
    }
}
