/******************************************************
*   Товар должен содержать следующие поля:
*        Название товара
*        Описание товара
*        Цена товара
*        В наличии ли товар


* Tests for item:
*    name <= 255 & not null
*    desc <= 4096
*    price >= 0, def price = 0
*    def isAvailable = false
*
******************************************************/

package com.testwork.sklad.moySklad.entities;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    private int id;

    @NotEmpty(message = "Name must not be Empty and NULL")
    @Size(max = 255, message = "Must be less than 255")
    private String name;

    @Size(max = 4096, message = "Description must be less than 4096")
    private String description;

    @Value("0")
    @Size(min = 0, message = "Price must be more than 0")
    private double price;

    @Value("false")
    private boolean isAvaliable;
}
