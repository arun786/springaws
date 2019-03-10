package com.arun.jpa;

import com.arun.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CustomerJpaImpl implements CustomerJpa {


    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Customer findById(String id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public Customer update(Customer customer) {
        return entityManager.merge(customer);
    }
}
