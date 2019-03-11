package com.arun.service;

import com.arun.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomer(String id);

    Customer findById(String id);

    Customer update(Customer customer);

    void deleteById(Integer id);

    List<Customer> getAllCustomers();
}
