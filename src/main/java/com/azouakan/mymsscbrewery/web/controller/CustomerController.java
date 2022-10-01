package com.azouakan.mymsscbrewery.web.controller;

import com.azouakan.mymsscbrewery.services.CutomerService;
import com.azouakan.mymsscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CutomerService cutomerService;

    public CustomerController(CutomerService cutomerService) {
        this.cutomerService = cutomerService;
    }
    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerId){
        return new ResponseEntity<>(cutomerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDto customerDto){
        CustomerDto savedCustomer = cutomerService.saveNewCustomer(customerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("location","/api/v1/customer/" +savedCustomer.getId().toString());
        return new ResponseEntity<>(headers,HttpStatus.CREATED);
    }

    @PutMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@PathVariable UUID customerId, @RequestBody CustomerDto customerDto){
        cutomerService.updateCustomer(customerId,customerDto);
    }

    @DeleteMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void DeleteCustomer(@PathVariable UUID customerId){
        cutomerService.deleteCustomerById(customerId);
    }
}
