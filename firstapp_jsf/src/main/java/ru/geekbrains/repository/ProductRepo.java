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
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

public class ProductRepo {

    private static final Logger logger = LoggerFactory.getLogger(ProductRepo.class);

    @Inject
    private Category category;

    @Inject
    private ServletContext servletContext;

    @PersistenceContext(unitName = "db_firstapp")
    private EntityManager entityManager;

    public ProductRepo() {
    }

    @PostConstruct
    public void init() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Long data = localDateTime.toEpochSecond(ZoneOffset.UTC);
        if (this.findAll().isEmpty()) {
            this.insert(new Product(-1L, "First", "Discription", bd(150), category, new Date(data)));
            this.insert(new Product(-1L, "Two", "Discription", bd(150), category, new Date(data)));
            this.insert(new Product(-1L, "Three", "Discription", bd(150), category, new Date(data)));
        }
    }

    @Transactional
    public void insert(Product product) {
        entityManager.persist(product);
    }

    @Transactional
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Transactional
    public void delete(long id) {
        Product product = entityManager.find(Product.class, id);
        if (product != null) {
            entityManager.remove(product);
        }
    }

    public Product findById(long id) {
        return entityManager.find(Product.class, id);
    }

    public List<Product> findAll() {
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }

    public BigDecimal bd (int big){
        BigDecimal bd = new BigDecimal(big);
        return bd;
    }
}
