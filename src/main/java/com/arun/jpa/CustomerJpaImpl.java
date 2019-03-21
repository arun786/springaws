package com.arun.jpa;

import com.arun.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CustomerJpaImpl implements CustomerJpa {


    @Autowired
    EntityManager entityManager;

    @Override
    public Customer findById(Long id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public Customer save(Customer customer) {

        /**
         * Insert
         */
        if (customer.getId() == null) {
            entityManager.persist(customer);
        } else {
            /*
            update
             */
            customer = entityManager.merge(customer);
        }
        return customer;
    }

    @Override
    public void deleteById(Long id) {
        Customer customer = entityManager.find(Customer.class, id);
        entityManager.remove(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        TypedQuery<Customer> list_all_customers = entityManager.createNamedQuery("List_All_Customers", Customer.class);
        return list_all_customers.getResultList();
    }
}
