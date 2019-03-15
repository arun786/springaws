package com.arun.jpa;

import com.arun.model.Item;

import java.util.List;

public interface Itemjpa {
    Item createItem(Item item);

    Item getItem(long id);

    List<Item> getItems();
}
