package com.arun.service;

import com.arun.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomer(Integer id);

    Customer findById(Integer id);

    Customer update(Customer customer);

    void deleteById(Integer id);

    List<Customer> getAllCustomers();
}
