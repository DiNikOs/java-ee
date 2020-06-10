/**
 * @author Ostrovskiy Dmitriy
 * @created 05.06.2020
 * Product
 * @version v1.0
 */

package ru.geekbrains.servlet;

import java.math.BigDecimal;

public class Product {

    private Long id;

    private String name;

    private String description;

    private Integer price;

    public Product(){

    }

    public Product(Long id, String name, String description, Integer price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
