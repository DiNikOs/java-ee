/**
 * @author Ostrovskiy Dmitriy
 * @created 30.06.2020
 * CategoryService
 * @version v1.0
 */

package ru.geekbrains.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.entity.Category;
import ru.geekbrains.repository.CategoryRepository;
import ru.geekbrains.service.repr.CategoryRepr;
import ru.geekbrains.service.impl.CategoryServiceLocalInterface;
import ru.geekbrains.service.impl.CategoryServiceRemoteInterface;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.Future;

@Stateless
public class CategoryService  implements CategoryServiceLocalInterface {

    private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @EJB
    private CategoryRepository catRepository;


    @Override
    public void insertCategory(CategoryRepr categoryRepr) {
        catRepository.insertCategory(new Category(null, categoryRepr.getCategoryName(), categoryRepr.getDescription()));

    }

    @Override
    public void updateCategory(CategoryRepr categoryRepr) {
        Category category = catRepository.findCategoryById(categoryRepr.getId());
        catRepository.updateCategory(new Category(category.getId(), categoryRepr.getCategoryName(), categoryRepr.getDescription()));
    }

    @Override
    public void deleteCategory(long id) {
        catRepository.deleteCategory(id);
    }

    @Override
    public CategoryRepr findById(long id) {
        return null;
    }

    @Override
    public List<CategoryRepr> findAll() {
        return null;
    }

}
