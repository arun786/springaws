package com.arun.jpa;

import com.arun.model.Customer;

import java.util.List;

public interface CustomerJpa {

    Customer findById(String id);

    Customer update(Customer customer);

    void deleteById(Integer id);

    List<Customer> getAllCustomers();
}
