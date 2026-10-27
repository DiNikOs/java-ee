/**
 * @author Ostrovskiy Dmitriy
 * @created 30.06.2020
 * CartService
 * @version v1.0
 */

package ru.geekbrains.service;

import ru.geekbrains.service.repr.ProductRepr;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class CartService implements Serializable {

    private List<ProductRepr> productRepr = new ArrayList<>();

    public List<ProductRepr> getAllProductRepr() {
        return productRepr;
    }

    public void addCart(ProductRepr repr) {
        productRepr.add(repr);
    }

    public void deliteCart(ProductRepr repr) {
        productRepr.remove(repr);
    }
 }
