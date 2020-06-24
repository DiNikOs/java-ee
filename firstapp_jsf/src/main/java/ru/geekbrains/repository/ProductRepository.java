/**
 * @author Ostrovskiy Dmitriy
 * @created 17.06.2020
 * ProductRepo
 * @version v1.0
 */

package ru.geekbrains.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.entity.Category;
import ru.geekbrains.entity.Product;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@ApplicationScoped
@Named
public class ProductRepository {

    private static final Logger logger = LoggerFactory.getLogger(ProductRepository.class);

    @Inject
    private ServletContext servletContext;

    @PersistenceContext(unitName = "ds")
    private EntityManager entityManager;

    public ProductRepository() {
    }

    @PostConstruct
    public void init() {
    }

    @Transactional
    public void insertProduct(Product product) {
        entityManager.persist(product);
    }

    @Transactional
    public void updateProduct(Product product) {
        entityManager.merge(product);
    }

    @Transactional
    public void deleteProduct(long id) {
        Product product = entityManager.find(Product.class, id);
        if (product != null) {
            entityManager.remove(product);
        }
    }

    public Product findProductById(long id) {
        return entityManager.find(Product.class, id);
    }

    public List<Product> findAllProduct() {
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }

    public BigDecimal bd (int big){
        BigDecimal bd = new BigDecimal(big);
        return bd;
    }
}
