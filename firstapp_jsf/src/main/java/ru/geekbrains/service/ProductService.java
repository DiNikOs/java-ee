/**
 * @author Ostrovskiy Dmitriy
 * @created 30.06.2020
 * ProductService
 * @version v1.0
 */

package ru.geekbrains.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.entity.Category;
import ru.geekbrains.entity.Product;
import ru.geekbrains.repository.CategoryRepository;
import ru.geekbrains.repository.ProductRepository;
import ru.geekbrains.service.repr.ProductRepr;
import ru.geekbrains.service.impl.ProductServiceLocalInterface;
import ru.geekbrains.service.impl.ProductServiceRemoteInterface;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ProductService implements ProductServiceLocalInterface {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @EJB
    private ProductRepository prodRepository;

    @EJB
    private CategoryRepository catRepository;

    @Override
    @TransactionAttribute
    public void insertProduct(ProductRepr productRepr) {
        Category category = catRepository.findCategoryById(productRepr.getCategoryId());
        prodRepository.insertProduct(new Product(null, productRepr.getName(), productRepr.getDescription(), productRepr.getPrice(), category, productRepr.getLocalDate()));
    }

    @Override
    @TransactionAttribute
    public void updateProduct(ProductRepr productRepr) {
        Product product = prodRepository.findProductById(productRepr.getId());
        Category category = catRepository.findCategoryById(productRepr.getCategoryId());
        prodRepository.updateProduct(new Product(product.getId(), productRepr.getName(), productRepr.getDescription(), productRepr.getPrice(), category, productRepr.getLocalDate()));
    }

    @Override
    @TransactionAttribute
    public void deleteProduct(long id) {
        prodRepository.deleteProduct(id);
    }

    @Override
    public ProductRepr findById(long id) {
        return prodRepository.findProductReprById(id);
    }

    @Override
    public List<ProductRepr> findAll() {
        return prodRepository.findAllProductRepr();
    }
}
