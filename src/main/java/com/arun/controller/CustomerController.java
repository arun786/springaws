package com.arun.controller;

import com.arun.service.CustomerService;
import com.arun.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private CustomerService customerService;
    private static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("customer/v1/customer/{id}")
    public ResponseEntity<Customer> getCustomerBasebOnId(@PathVariable Integer id) {
        return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.OK);
    }

    @GetMapping("customer/v2/customer/{id}")
    public ResponseEntity<Customer> findByIdJpa(@PathVariable Integer id) {
        logger.info("Request : " + id);
        return new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
    }

    @PostMapping("customer/v2/customer")
    public ResponseEntity<Customer> insertACustomer(@RequestBody Customer customer) {
        Customer customerUpdated = customerService.update(customer);
        return new ResponseEntity<>(customerUpdated, HttpStatus.OK);
    }

    @DeleteMapping("customer/v2/customer/{id}")
    public ResponseEntity<HttpStatus> deleteByIdJpa(@PathVariable Integer id) {
        logger.info("Request : " + id);
        customerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("customer/v2/customer")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> allCustomers = customerService.getAllCustomers();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }

}
