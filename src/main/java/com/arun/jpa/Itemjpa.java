package com.arun.jpa;

import com.arun.model.Item;

public interface Itemjpa {
    Item createItem(Item item);

    Item getItem(long id);
}
