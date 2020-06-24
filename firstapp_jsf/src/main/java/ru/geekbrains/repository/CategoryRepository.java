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
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;
import java.util.List;

@ApplicationScoped
@Named
public class CategoryRepository {

    private static final Logger logger = LoggerFactory.getLogger(CategoryRepository.class);

    @PersistenceContext(unitName = "ds")
    private EntityManager entityManager;

    @Inject
    private UserTransaction userTransaction;

    @PostConstruct
    public void init() {
    }

    @Transactional
    public void insertCategory(Category category) {
        entityManager.persist(category);
    }

    @Transactional
    public void updateCategory(Category category) {
        entityManager.merge(category);
    }

    @Transactional
    public void deleteCategory(long id) {
        Category category = entityManager.find(Category.class, id);
        if (category != null) {
            entityManager.remove(category);
        }
    }

    @Transactional
    public Category findCategoryById(long id) {
        return entityManager.find(Category.class, id);
    }

    @Transactional
    public List<Category> findAllCategories() {
        return entityManager.createQuery("SELECT c FROM Category c", Category.class).getResultList();
    }
}
