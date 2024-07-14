package com.testwork.sklad.moySklad.repositories;

import com.testwork.sklad.moySklad.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/******************************************************
* Заказчик хочет получить полный CRUD по товарам:
*    Получать список товаров
*    Получать отдельный товар
*    Создавать товар
*    Изменять товар
*    Удалять товар
 ******************************************************/

/******************************************************
 * Должны уметь фильтровать:
 *   по названию или части названия товара
 *   по цене товара, а также больше или меньше заданной цены
 *   по наличию товара
 Нужно уметь сортировать:
 *   по имени товара
 *   по цене товара
 ******************************************************/

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    @Query("SELECT i FROM Item i WHERE i.name LIKE CONCAT('%', :searchText, '%') ORDER BY i.name")
    List<Item> findListByName(@Param("searchText") String searchText);

    @Query("SELECT i FROM Item i WHERE i.price = :serchPrice ORDER BY i.price")
    List<Item> findListByPrice(@Param("serchPrice") Integer serchPrice);
    @Query("SELECT i FROM Item i WHERE i.isAvaliable = :isAvaliable")
    List<Item> findListOfAvailable(@Param("isAvaliable") boolean isAvaliable);

}