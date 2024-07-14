
/******************************************************
 *   Товар должен содержать следующие поля:
 *        Название товара
 *        Описание товара
 *        Цена товара
 *        В наличии ли товар
 ******************************************************/

package com.testwork.sklad.moySklad.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {
    private int id;
    private String name;
    private String description;
    private double price;
    private boolean isAvaliable;
}
