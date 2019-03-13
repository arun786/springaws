package com.arun.jpa;

import com.arun.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CustomerJpaImpl implements CustomerJpa {


    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Customer findById(Integer id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public Customer update(Customer customer) {
        return entityManager.merge(customer);
    }

    @Override
    public void deleteById(Integer id) {
        Customer customer = entityManager.find(Customer.class, id);
        entityManager.remove(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        TypedQuery<Customer> list_all_customers = entityManager.createNamedQuery("List_All_Customers", Customer.class);
        return list_all_customers.getResultList();
    }
}
