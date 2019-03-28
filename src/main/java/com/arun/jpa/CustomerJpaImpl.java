package com.arun.jpa;

import com.arun.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class CustomerJpaImpl implements CustomerJpa {


    @Qualifier("awsEntityManagerFactory")
    @Autowired
    EntityManager awsEntityManager;

    @Override
    public Customer findById(Long id) {
        return awsEntityManager.find(Customer.class, id);
    }

    @Override
    public Customer save(Customer customer) {
        Map<String, Object> properties = awsEntityManager.getProperties();

        /**
         * Insert
         */
        if (customer.getId() == null) {
            awsEntityManager.persist(customer);
        } else {
            /*
            update
             */
            customer = awsEntityManager.merge(customer);
        }
        return customer;
    }

    @Override
    public void deleteById(Long id) {
        Customer customer = awsEntityManager.find(Customer.class, id);
        awsEntityManager.remove(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        TypedQuery<Customer> list_all_customers = awsEntityManager.createNamedQuery("List_All_Customers", Customer.class);
        return list_all_customers.getResultList();
    }
}
