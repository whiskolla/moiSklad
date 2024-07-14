package com.testwork.sklad.moySklad.services;

import com.testwork.sklad.moySklad.entities.Item;
import com.testwork.sklad.moySklad.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repository;

    public Item addItem(Item item) {
        return repository.add(item);
    }

    public List<Item> getItems() {
        return repository.getAllItems();
    }

    public Item getItemById(int id) {
        return repository.findById(id);
    }

    public String deleteItem(int id) {
        repository.delete(id);
        return "removed item: " + id;
    }

    public Item updateItem(Item item) {
        return repository.update(item);
    }
}
