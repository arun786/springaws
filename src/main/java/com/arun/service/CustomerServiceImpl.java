package com.arun.service;

import com.arun.dao.CustomerDao;
import com.arun.jpa.CustomerJpa;
import com.arun.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;
    private CustomerJpa customerJpa;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao, CustomerJpa customerJpa) {
        this.customerDao = customerDao;
        this.customerJpa = customerJpa;
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerDao.getCustomer(id);
    }

    @Override
    public Customer findById(Long id) {
        return customerJpa.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerJpa.save(customer);
    }

    @Override
    public void deleteById(Long id) {
        customerJpa.deleteById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerJpa.getAllCustomers();
    }
}
