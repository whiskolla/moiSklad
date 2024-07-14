package com.testwork.sklad.moySklad.repositories;

import com.testwork.sklad.moySklad.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/******************************************************
* Заказчик хочет получить полный CRUD по товарам:
*    Получать список товаров
*    Получать отдельный товар
*    Создавать товар
*    Изменять товар
*    Удалять товар
 ******************************************************/

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}