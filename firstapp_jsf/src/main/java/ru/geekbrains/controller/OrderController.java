package ru.geekbrains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.geekbrains.entity.Order;
import ru.geekbrains.repository.OrderRepository;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class OrderController implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Inject
    private OrderRepository orderRepository;

    private Order order;

    private List<Order> orderList;

    public void preloadOrderList(ComponentSystemEvent componentSystemEvent) {
        this.orderList = orderRepository.findAllOrder();
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Order> getAllOrder() {
        return orderList;
    }

    public String createOrder() {
        this.order = new Order();
        return "/order.xhtml?faces-redirect=true";
    }

    public String saveOrder() {
        if (order.getId() == null) {
            orderRepository.insertOrder(order);
        } else {
            orderRepository.updateOrder(order);
        }
        return "/index.xhtml?faces-redirect=true";
    }

    public void deleteOrder(Order order) {
        logger.info("Deleting Order.");
        orderRepository.deleteOrder(order.getId());
    }

    public String editOrder(Order order) {
        this.order = order;
        return "/order.xhtml?faces-redirect=true";
    }
}
