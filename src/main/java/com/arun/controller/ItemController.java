package com.arun.controller;

import com.arun.model.Item;
import com.arun.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("items/v1/item/{id}")
    public ResponseEntity<Item> getItem(@PathVariable long id) {

        Item item = itemService.getItem(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("items/v1/items")
    public ResponseEntity<List<Item>> getListOfItems() {
        List<Item> items = itemService.getItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}
