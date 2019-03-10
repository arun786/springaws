package com.arun.jpa;

import com.arun.model.Customer;

public interface CustomerJpa {

    Customer findById(String id);

    Customer update(Customer customer);
}
