package com.arun.jpa;

import com.arun.model.Customer;

import java.util.List;

public interface CustomerJpa {

    Customer findById(Long id);

    Customer save(Customer customer);

    void deleteById(Long id);

    List<Customer> getAllCustomers();
}
