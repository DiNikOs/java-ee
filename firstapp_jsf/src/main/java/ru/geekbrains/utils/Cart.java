package ru.geekbrains.utils;

import ru.geekbrains.entity.OrderItem;
import ru.geekbrains.entity.Product;
import ru.geekbrains.repository.ProductRepository;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

@ApplicationScoped
@Named
public class Cart {
    private Map<Long, OrderItem> items;
    private BigDecimal totalPrice;

    public Map<Long, OrderItem> getItems() {
        return items;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    @Inject
    private ProductRepository productRepository;

    @PostConstruct
    public void init() {
        items = new LinkedHashMap<>();
    }

    public void addProduct(Product product) {
        OrderItem item = items.get(product.getId());
        if (item == null) {
            item = new OrderItem();
            item.setPrice(product.getPrice());
            item.setProduct(product);
            item.setQuantity(0);
        }
        item.setQuantity(item.getQuantity() + 1);
        item.setTotalPrice(item.getItemPrice().multiply(new BigDecimal(item.getQuantity())));
        items.put(product.getId(), item);
        recalculate();
    }

    public void removeItem(Product product) {
        items.remove(product.getId());
        recalculate();
    }

    public void clear() {
        items.clear();
        totalPrice = new BigDecimal(0);
    }

    private void recalculate() {
        totalPrice = new BigDecimal(0);
        items.values().stream().forEach(oi -> totalPrice = totalPrice.add(oi.getTotalPrice()));
    }
}
