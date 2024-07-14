package com.testwork.sklad.moySklad.controllers;

import com.testwork.sklad.moySklad.entities.Item;
import com.testwork.sklad.moySklad.services.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService service;

    @PostMapping("/add")
    public ResponseEntity<String> addItem(@Valid @RequestBody Item item) {
        service.addItem(item);
        return ResponseEntity.ok("Item correct");
    }

    @GetMapping
    public List<Item> findAllItems() {
        return service.getItems();
    }

    @GetMapping("{id}")
    public Item findItemById(@PathVariable int id) {
        return service.getItemById(id);
    }

    @PutMapping("/update/{id}")
    public Item updateItem(@Valid @RequestBody Item item) {
        return service.updateItem(item);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteItem(@PathVariable int id) {
        return service.deleteItem(id);
    }
}
