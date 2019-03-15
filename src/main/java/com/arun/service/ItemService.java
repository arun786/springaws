package com.arun.service;

import com.arun.model.Item;

import java.util.List;

public interface ItemService {
    Item createItem(Item item);

    Item getItem(long id);

    List<Item> getItems();
}
