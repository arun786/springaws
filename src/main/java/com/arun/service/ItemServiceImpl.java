package com.arun.service;

import com.arun.jpa.Itemjpa;
import com.arun.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    private Itemjpa itemjpa;

    @Autowired
    public ItemServiceImpl(Itemjpa itemjpa) {
        this.itemjpa = itemjpa;
    }

    @Override
    public Item createItem(Item item) {
        return itemjpa.createItem(item);
    }

    @Override
    public Item getItem(long id) {
        return itemjpa.getItem(id);
    }
}
