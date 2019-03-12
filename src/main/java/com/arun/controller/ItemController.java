package com.arun.controller;

import com.arun.model.Item;
import com.arun.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PutMapping("items/v1/item")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item itemCreated = itemService.createItem(item);
        return new ResponseEntity<>(itemCreated, HttpStatus.CREATED);
    }
}
