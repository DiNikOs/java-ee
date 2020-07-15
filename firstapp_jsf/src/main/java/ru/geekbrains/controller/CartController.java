package ru.geekbrains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.geekbrains.entity.OrderItem;
import ru.geekbrains.entity.Product;
import ru.geekbrains.repository.ProductRepository;
import ru.geekbrains.service.CartService;
import ru.geekbrains.service.repr.ProductRepr;
import ru.geekbrains.utils.Cart;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@SessionScoped
@Named
public class CartController implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @EJB
    private CartService cartService;

    private ProductRepository productRepository;

    private Cart cart;

//    private Collection<OrderItem> cartList;

//    public void preloadCartList(ComponentSystemEvent componentSystemEvent) {
//        this.cartList = cart.getItems().values();
//    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

//    public Collection<OrderItem> getAllToCart() {
//        return cartList;
//    }

        public List<ProductRepr> getAllToCart() {
        return cartService.getAllProductRepr();
    }


    public String addProductToCart(ProductRepr prodRepr) {
        cartService.addCart(prodRepr);
        return "/cart.xhtml?faces-redirect=true";
    }

    public String removeCart(ProductRepr prodRepr) {
        cartService.deliteCart(prodRepr);
//        cart.removeItem(product);
        return "/cart.xhtml?faces-redirect=true";
    }

    public void deleteCart(Cart cart) {
        logger.info("Deleting Cart.");
        cart.clear();
    }
}
