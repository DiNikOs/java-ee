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
import java.sql.Date;

@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name", length = 4096,  nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @ManyToOne(optional = false)
    private Category category;

    @Column(name = "localDate")
    private Date localDate;

//    public Product(long l, String пицца, String s, double v, Object o, Date date){
//
//    }

    public Product(Long id, String name, String description, double price, Category category, Date localDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getLocalDate() {
        return localDate;
    }

    public void setLocalDate(Date localDate) {
        this.localDate = localDate;
    }
}
