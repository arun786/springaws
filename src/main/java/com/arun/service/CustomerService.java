package com.arun.service;

import com.arun.model.Customer;

public interface CustomerService {
    Customer getCustomer(String id);

    Customer findById(String id);

    Customer update(Customer customer);

    void deleteById(Integer id);
}
