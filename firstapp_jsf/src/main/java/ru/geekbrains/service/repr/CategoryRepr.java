/**
 * @author Ostrovskiy Dmitriy
 * @created 30.06.2020
 * CategoryRepr
 * @version v1.0
 */

package ru.geekbrains.service.repr;

import java.io.Serializable;
import java.util.List;

public class CategoryRepr implements Serializable {

    private Long id;

    private String categoryName;

    private String description;

    private List<Long> productsId;

    public CategoryRepr(){

    }

    public CategoryRepr(Long id, String categoryName, String description, List<Long> productsId) {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
        this.productsId = productsId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getProductsId() {
        return productsId;
    }

    public void setProductsId(List<Long> productsId) {
        this.productsId = productsId;
    }
}
