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
import ru.geekbrains.service.repr.CategoryRepr;
import ru.geekbrains.service.repr.ProductRepr;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

@Stateless
public class ProductRepository {

    private static final Logger logger = LoggerFactory.getLogger(ProductRepository.class);

    @PersistenceContext(unitName = "ds")
    private EntityManager entityManager;

    public ProductRepository() {
    }

    @PostConstruct
    public void init() {
    }

    @TransactionAttribute
    public void insertProduct(Product product) {
        entityManager.persist(product);
    }

    @TransactionAttribute
    public void updateProduct(Product product) {
        entityManager.merge(product);
    }

    @TransactionAttribute
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
        return entityManager.createQuery("SELECT prod FROM Product prod", Product.class).getResultList();
    }

    public BigDecimal bd (int big){
        BigDecimal bd = new BigDecimal(big);
        return bd;
    }

    public List<ProductRepr> findAllProductReprByCateoryId(long id) {
        return entityManager.createQuery("SELECT new ru.geekbrains.service.repr.ProductRepr(" +
                "p.id, p.name, p.description, p.price, p.category.id, p.category.categoryName, p.localDate) " +
                "FROM Product p WHERE p.category.id = : id", ProductRepr.class).setParameter("id", id)
                .getResultList();
    }

    public ProductRepr findProductReprByName(String name) {
        return entityManager.createQuery("SELECT new ru.geekbrains.service.repr.ProductRepr(" +
                "p.id, p.name, p.description, p.price, p.category.id, p.category.categoryName, p.localDate) " +
                "FROM Product p WHERE p.name = :name", ProductRepr.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    public ProductRepr findProductReprById(long id) {
        return entityManager.createQuery("SELECT new ru.geekbrains.service.repr.ProductRepr(" +
                "p.id, p.name, p.description, p.price, p.category.id, p.category.categoryName, p.localDate) " +
                "FROM Product p WHERE p.id = :id", ProductRepr.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public List<ProductRepr> findAllProductRepr() {
        return entityManager.createQuery("SELECT new ru.geekbrains.service.repr.ProductRepr(" +
                "p.id, p.name, p.description, p.price, p.category.id, p.category.categoryName, p.localDate) " +
                "FROM Product p", ProductRepr.class)
                .getResultList();
    }
}
