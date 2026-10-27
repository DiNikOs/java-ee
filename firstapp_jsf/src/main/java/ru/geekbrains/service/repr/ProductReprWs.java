/**
 * @author Ostrovskiy Dmitriy
 * @created 04.07.2020
 * ProductReprWs
 * @version v1.0
 */

package ru.geekbrains.service.repr;

import ru.geekbrains.entity.Product;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductReprWs {

    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private Long categoryId;

    private String categoryName;


    public ProductReprWs() {

    }

    public ProductReprWs(Product productRepr) {
        this.id = productRepr.getId();
        this.name = productRepr.getName();
        this.description = productRepr.getDescription();
        this.price = productRepr.getPrice();
        this.categoryId = productRepr.getCategory().getId();
        this.categoryName = productRepr.getCategory().getCategoryName();
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

//    public LocalDate getLocalDate() {
//        return localDate;
//    }
//
//    public void setLocalDate(LocalDate localDate) {
//        this.localDate = localDate;
//    }
}
