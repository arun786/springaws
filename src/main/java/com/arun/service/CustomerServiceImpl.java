package com.arun.service;

import com.arun.dao.CustomerDao;
import com.arun.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public Customer getCustomer(String id) {
        return customerDao.getCustomer(id);
    }
}
