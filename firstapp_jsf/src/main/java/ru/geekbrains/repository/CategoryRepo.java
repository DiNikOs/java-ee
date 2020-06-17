/**
 * @author Ostrovskiy Dmitriy
 * @created 17.06.2020
 * CategoryRepo
 * @version v1.0
 */

package ru.geekbrains.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.entity.Category;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class CategoryRepo {

    private static final Logger logger = LoggerFactory.getLogger(CategoryRepo.class);

    @PersistenceContext(unitName = "db_firstapp")
    private EntityManager entityManager;

    @PostConstruct
    public void init() {
        if (this.findAll().isEmpty()) {
            this.insert(new Category(-1L, "Category1"));
            this.insert(new Category(-1L, "Category2"));
            this.insert(new Category(-1L, "Category3"));
        }
    }

    @Transactional
    public void insert(Category category) {
        entityManager.persist(category);
    }

    @Transactional
    public void update(Category category) {
        entityManager.merge(category);
    }

    @Transactional
    public void delete(long id) {
        Category category = entityManager.find(Category.class, id);
        if (category != null) {
            entityManager.remove(category);
        }
    }

    public Category findById(long id) {
        return entityManager.find(Category.class, id);
    }

    public List<Category> findAll() {
        return entityManager.createQuery("from Category", Category.class).getResultList();
    }
}
