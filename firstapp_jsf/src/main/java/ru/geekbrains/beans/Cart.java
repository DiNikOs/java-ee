package ru.geekbrains.beans;

import lombok.Data;
import ru.geekbrains.entity.OrderItem;
import ru.geekbrains.entity.Product;

import javax.annotation.PostConstruct;
import javax.inject.Scope;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {
    private List<OrderItem> items;
    private BigDecimal price;

    @PostConstruct
    public void init() {
        items = new ArrayList<>();
    }

    public void clear() {
        items.clear();
        recalculate();
    }

    public void add(Product product) {
        for (OrderItem i : items) {
            if (i.getProduct().getId().equals(product.getId())) {
                i.setQuantity(i.getQuantity() + 1);
                i.setPrice(new BigDecimal(i.getQuantity() * i.getProduct().getPrice().doubleValue()));
                recalculate();
                return;
            }
        }
        items.add(new OrderItem(product));
        recalculate();
    }

    public void removeByProductId(Long productId) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct().getId().equals(productId)) {
                items.remove(i);
                recalculate();
                return;
            }
        }
    }

    public void recalculate() {
        price = new BigDecimal(0.0);
        for (OrderItem i : items) {
            price = price.add(i.getPrice());
        }
    }
}
