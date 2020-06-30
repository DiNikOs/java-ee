package ru.geekbrains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.entity.Category;
import ru.geekbrains.entity.Product;
import ru.geekbrains.repository.CategoryRepository;
import ru.geekbrains.service.ProductService;
import ru.geekbrains.service.impl.ProductServiceLocalInterface;
import ru.geekbrains.service.repr.ProductRepr;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class ProductController implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @EJB
    private ProductServiceLocalInterface prodService;

    @EJB
    private CategoryRepository catRepository;

    private List<ProductRepr> prodList;

    private ProductRepr prodRepr;

    public void preloadProductList(ComponentSystemEvent componentSystemEvent) {
        this.prodList = prodService.findAll();
    }

    public ProductRepr getProductRepr() {
        return prodRepr;
    }

    public void setProduct(ProductRepr prodRepr) {
        this.prodRepr = prodRepr;
    }

    public List<ProductRepr> getAllProduct() {
        return prodList;
//        return productRepository.findAllProduct();
    }

    public String doActionProduct() {
        return "products.xhtml";
    }

    public String createProduct() {
        this.prodRepr = new ProductRepr();
        return "/product.xhtml?faces-redirect=true";
    }

    public String saveProductRepr() {
        if (prodRepr.getId() == null) {
            prodService.insertProduct(prodRepr);
        } else {
            prodService.updateProduct(prodRepr);
        }
        return "products.xhtml";
    }

    public void deleteProduct(ProductRepr prodRepr) {
        logger.info("Deleting Product.");
        prodService.deleteProduct(prodRepr.getId());
    }

    public String editProductRepr(ProductRepr prodRepr) {
        this.prodRepr = prodRepr;
        return "/product.xhtml?faces-redirect=true";
    }

    public List<Category> getAllCategories() {
        return catRepository.findAllCategories();
    }
}
