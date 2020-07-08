/**
 * @author Ostrovskiy Dmitriy
 * @created 05.06.2020
 * Product
 * @version v1.0
 */

package ru.geekbrains.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="prod_name", length = 4096,  nullable = false)
    private String name;

    @Column()
    private String description;

    @Column()
    private BigDecimal price;

//    @JoinColumn()
//    optional = false
    @ManyToOne()
    private Category category;

    @Column(nullable = false)
    private Date localDate;

    public Product(){

    }

    public Product(Long id, String name, String description, BigDecimal price, Category category, Date localDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.localDate = localDate;
    }

    public Product(Long id, String name, String description, BigDecimal price, Long categoryId, Date localDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category.setId(categoryId);
        this.localDate = localDate;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getLocalDate() {
        return localDate;
    }

    public void setLocalDate(Date localDate) {
        this.localDate = localDate;
    }
}
