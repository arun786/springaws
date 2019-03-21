package com.arun.service;

import com.arun.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomer(Long id);

    Customer findById(Long id);

    Customer save(Customer customer);

    void deleteById(Long id);

    List<Customer> getAllCustomers();
}
