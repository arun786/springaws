package com.arun.jpa;

import com.arun.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ItemJpaImpl implements Itemjpa {

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

    @Override
    public List<Item> getItems() {
        TypedQuery<Item> list_of_items = entityManager.createNamedQuery("LIST_OF_ITEMS", Item.class);
        return list_of_items.getResultList();
    }
}
