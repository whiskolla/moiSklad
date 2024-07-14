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

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "item")
public class Item {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotEmpty(message = "Name must not be Empty and NULL")
    @Size(max = 255, message = "Must be less than 255")
    @Column(name = "name")
    private String name;

    @Size(max = 4096, message = "Description must be less than 4096")
    @Column(name = "description")
    private String description;

    @Value("0")
    @Min(0)
    @Column(name = "price")
    private double price;

    @Value("false")
    @Column(name = "is_avaliable")
    private boolean isAvaliable;

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Item {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", isAvaliable=" + isAvaliable +
                '}';
    }
}
