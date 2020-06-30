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
import ru.geekbrains.service.repr.CategoryRepr;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;
import java.util.List;

@Stateless
public class CategoryRepository {

    private static final Logger logger = LoggerFactory.getLogger(CategoryRepository.class);

    @PersistenceContext(unitName = "ds")
    private EntityManager entityManager;

    @PostConstruct
    public void init() {
    }

    @TransactionAttribute
    public void insertCategory(Category category) {
        entityManager.persist(category);
    }

    @TransactionAttribute
    public void updateCategory(Category category) {
        entityManager.merge(category);
    }

    @TransactionAttribute
    public void deleteCategory(long id) {
        Category category = entityManager.find(Category.class, id);
        if (category != null) {
            entityManager.remove(category);
        }
    }

    public Category findCategoryById(long id) {
        return entityManager.find(Category.class, id);
    }

    public List<Category> findAllCategories() {
        return entityManager.createQuery("SELECT cat FROM Category cat", Category.class).getResultList();
    }

}
