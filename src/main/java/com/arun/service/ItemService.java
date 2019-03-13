package com.arun.service;

import com.arun.model.Item;

public interface ItemService {
    Item createItem(Item item);

    Item getItem(long id);
}
