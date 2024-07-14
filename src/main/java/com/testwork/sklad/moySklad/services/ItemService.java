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

    public Item add(Item item) {
        return repository.save(item) ;
    }

    public List<Item> getItems() {
        return repository.findAll();
    }
    public List<Item> findListByName(String str) {
        return repository.findListByName(str);
    }

    public List<Item> findListByPrice(Integer price) {
        return repository.findListByPrice(price);
    }
    public List<Item> findListOfAvailable(boolean a) {
        return repository.findListOfAvailable(a);
    }

    public Item getItemById(int id) {
        return repository.findById(id).get();
    }

    public boolean ifExists(int id){return repository.existsById(id);}

    public String deleteItem(int id) {
        repository.delete(repository.findById(id).get());
        return "removed item: " + id;
    }
    public Item update(Item item) {
        return repository.save(item) ;
    }
}
