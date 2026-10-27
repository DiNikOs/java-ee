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
import ru.geekbrains.service.impl.rest.CategoryServiceRsInterface;
import ru.geekbrains.service.impl.ws.CategoryServiceWsInterface;
import ru.geekbrains.service.repr.CategoryRepr;
import ru.geekbrains.service.impl.local.CategoryServiceLocalInterface;
import ru.geekbrains.service.impl.remote.CategoryServiceRemoteInterface;

import javax.ejb.AsyncResult;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.List;
import java.util.concurrent.Future;

@Stateless
@WebService(endpointInterface = "ru.geekbrains.service.impl.ws.CategoryServiceWsInterface", serviceName = "CategoryService")
public class CategoryService  implements CategoryServiceLocalInterface, CategoryServiceRemoteInterface, CategoryServiceWsInterface, CategoryServiceRsInterface {

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
    public CategoryRepr findCategoryById(long id) {
        return catRepository.findCaregoryReprById(id);
    }

    @Override
    public List<CategoryRepr> findAllCategories() {
        return catRepository.findAllCategoryRepr();
    }

    @Override
    public Future<CategoryRepr> findCategoryByIdAsync(long id) {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>(catRepository.findCaregoryReprById(id));
    }

    @Override
    public List<CategoryRepr> findAllCategoryWs() {
        return catRepository.findAllCategoryRepr();
    }

    @Override
    public CategoryRepr findCategoryByIdWs(long id) {
        return catRepository.findCaregoryReprById(id);
    }

}
