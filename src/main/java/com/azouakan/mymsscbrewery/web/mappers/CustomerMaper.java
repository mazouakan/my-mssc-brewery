package com.azouakan.mymsscbrewery.web.mappers;

import com.azouakan.mymsscbrewery.domain.Customer;
import com.azouakan.mymsscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMaper {
    CustomerDto customerToCustomerDto(Customer customer);
    Customer customerDtoToCustomer(CustomerDto customerDto);
}
