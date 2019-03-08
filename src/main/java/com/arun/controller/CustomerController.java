package com.arun.controller;

import com.arun.service.CustomerService;
import com.arun.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("customer/v1/customer/{id}")
    public ResponseEntity<Customer> getCustomerBasebOnId(@PathVariable String id) {

        return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.OK);
    }
}
