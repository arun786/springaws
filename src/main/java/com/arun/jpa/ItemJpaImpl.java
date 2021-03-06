package com.arun.jpa;

import com.arun.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ItemJpaImpl implements Itemjpa {

    @Qualifier("awsEntityManagerFactory")
    @Autowired
    private EntityManager entityManager;

    @Override
    public Item createItem(Item item) {
        return entityManager.merge(item);
    }

    @Override
    public Item getItem(long id) {
        return entityManager.find(Item.class, id);
    }

    /**
     * Use of Typed Query
     *
     * @return
     */
    @Override
    public List<Item> getItems() {
        TypedQuery<Item> list_of_items = entityManager.createQuery("select c from Item c", Item.class);
        return list_of_items.getResultList();
    }
}
