package com.testwork.sklad.moySklad.controllers;

import com.testwork.sklad.moySklad.entities.Item;
import com.testwork.sklad.moySklad.services.ItemService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.rmi.ServerException;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService service;
    private final Logger logger = LoggerFactory.getLogger(ItemController.class);
    @PostMapping(path = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Item addItem(@Valid @RequestBody Item item1) throws ServerException {

        Item item = service.add(item1);
        if (item != null) {
            logger.info("body: " + item);
            return item;
        } else {
            throw new ServerException("Error in creating. Try Again.");
        }
    }

    @GetMapping
    public List<Item> findAllItems() {
        List<Item> items = service.getItems();
        logger.info("List of items: " + items);
        return items;
    }
    @GetMapping("list/by/name/{name}")
    public List<Item> findListByName(@PathVariable String name) {
        List<Item> items = service.findListByName(name);
        logger.info("List of items: " + items);
        return items;
    }

    @GetMapping("list/by/price/{price}")
    public List<Item> findListByPrice(@PathVariable Integer price) {
        List<Item> items = service.findListByPrice(price);
        logger.info("List of items: " + items);
        return items;
    }
    @GetMapping("list/of/available?={isAvailable}")
    public List<Item> findListByPrice(@PathVariable boolean isAvailable) {
        List<Item> items = service.findListOfAvailable(isAvailable);
        logger.info("List of items: " + items);
        return items;
    }

    @GetMapping("{id}")
    public Item findItemById(@PathVariable int id) {
        return service.getItemById(id);
    }

    @PutMapping(path="/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Item updateItem(@Valid @RequestBody Item item1) throws ServerException {

        Item item = service.update(item1);
        if (item != null) {
            logger.info("body: " + item);
            return item;
        } else {
            throw new ServerException("Error in updating. Try Again.");
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteItem(@PathVariable int id) throws ServerException {
        if (service.ifExists(id)) {
            logger.info("Item to delete: " + service.getItemById(id));
            return service.deleteItem(id);
        } else {
            throw new ServerException("Error in deleting. Try Again.");
        }
    }
}
