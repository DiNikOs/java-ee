package ru.geekbrains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.geekbrains.entity.OrderItem;
import ru.geekbrains.entity.Product;
import ru.geekbrains.repository.ProductRepository;
import ru.geekbrains.utils.Cart;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;
import java.util.Collection;

@SessionScoped
@Named
public class CartController implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @Inject
    private ProductRepository productRepository;

    private Cart cart;

    private Collection<OrderItem> cartList;

    public void preloadTodoList(ComponentSystemEvent componentSystemEvent) {
        this.cartList = cart.getItems().values();
    }

    public Cart getCart() {
        return cart;
    }

    public void setToDo(Cart cart) {
        this.cart = cart;
    }

    public Collection<OrderItem> getAllTodo() {
        return cartList;
    }

    public String addProductToCart(Product product) {
        cart.addProduct(product);
        return "/cart.xhtml?faces-redirect=true";
    }

    public String removeCart(Product product) {
        cart.removeItem(product);
        return "/index.xhtml?faces-redirect=true";
    }

    public void deleteCart(Cart cart) {
        logger.info("Deleting Cart.");
        cart.clear();
    }
}
