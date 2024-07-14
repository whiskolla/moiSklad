package com.testwork.sklad.moySklad.repositories;

import com.testwork.sklad.moySklad.entities.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/******************************************************
* Заказчик хочет получить полный CRUD по товарам:
*    Получать список товаров
*    Получать отдельный товар
*    Создавать товар
*    Изменять товар
*    Удалять товар
 ******************************************************/

@Repository
public class ItemRepository {
    List<Item> list = new ArrayList<>(List.of(
            new Item(1, "item 1", "first", 10, true),
            new Item(2, "item 2", "second", 20, true),
            new Item(3, "item 3", "third", 30, false)
    ));
    public List<Item> getAllItems() {
        return list;
    }

    public Item findById(int id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (id)) {
                return list.get(i);
            }
        }
        return null;
    }

    public List<Item> search(String name) {
        return list.stream().filter(x -> x.getName().startsWith(name)).collect(Collectors.toList());
    }
    public Item add(Item p) {
        Item item = new Item();
        item.setId(p.getId());
        item.setName(p.getName());
        item.setName(p.getDescription());
        item.setAvaliable(p.isAvaliable());
        item.setPrice(p.getPrice());
        list.add(item);
        return item;
    }
    public Item update(Item item) {
        int idx = 0;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (item.getId())) {
                id = item.getId();
                idx = i;
                break;
            }
        }

        Item newItem = new Item();
        newItem.setId(id);
        newItem.setName(item.getName());
        newItem.setDescription(item.getDescription());
        newItem.setPrice(item.getPrice());
        newItem.setAvaliable(item.isAvaliable());
        list.set(idx, item);
        return newItem;
    }
    public String delete(Integer id) {
        list.removeIf(x -> x.getId() == (id));
        return null;
    }
}
