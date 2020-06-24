package ru.geekbrains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.entity.Product;
import ru.geekbrains.repository.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class ProductController implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Inject
    private ProductRepository productRepository;

    private Product product;

    private List<Product> productList;

    public void preloadProductList(ComponentSystemEvent componentSystemEvent) {
        this.productList = productRepository.findAllProduct();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getAllProduct() {
        return productRepository.findAllProduct();
    }

    public String doActionProduct() {
        return "products.xhtml";
    }

    public String createProduct() {
        this.product = new Product();
        return "/product.xhtml?faces-redirect=true";
    }

    public String saveProduct() {
        if (product.getId() == null) {
            productRepository.insertProduct(product);
        } else {
            productRepository.updateProduct(product);
        }
        return "products.xhtml";
    }

    public void deleteProduct(Product product) {
        logger.info("Deleting Product.");
        productRepository.deleteProduct(product.getId());
    }

    public String editProduct(Product product) {
        this.product = product;
        return "/product.xhtml?faces-redirect=true";
    }
}
