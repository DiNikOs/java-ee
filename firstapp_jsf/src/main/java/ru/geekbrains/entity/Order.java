package ru.geekbrains.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.beans.Cart;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "price")
    private BigDecimal price;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    public Order(Cart cart) {
        this.price = cart.getPrice();
        for (OrderItem i : cart.getItems()) {
            i.setOrder(this);
            this.items.add(i);
        }
        cart.clear();
    }

//    public Order(User user) {
//        this.user = user;
//    }
}
