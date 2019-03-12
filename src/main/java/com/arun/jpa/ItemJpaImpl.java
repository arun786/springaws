package com.arun.jpa;

import com.arun.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ItemJpaImpl implements Itemjpa {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Item createItem(Item item) {
        return entityManager.merge(item);
    }
}
