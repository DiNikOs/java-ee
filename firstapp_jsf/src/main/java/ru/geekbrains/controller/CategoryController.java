/**
 * @author Ostrovskiy Dmitriy
 * @created 23.06.2020
 * CategoryController
 * @version v1.0
 */

package ru.geekbrains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.entity.Category;
import ru.geekbrains.repository.CategoryRepository;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class CategoryController implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @EJB
    private CategoryRepository categoryRepository;

    private List<Category> categoryList;

    private Category category;

    public void preloadCategoryList(ComponentSystemEvent componentSystemEvent) {
        this.categoryList = categoryRepository.findAllCategories();
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Category> getAllCategory() {
//        return categoryRepository.findAllCategories();
        return categoryList;
    }

    public String doActionCategory() {
        return "categories.xhtml";
    }

    public String createCategory() {
        this.category = new Category();
        return "/category.xhtml?faces-redirect=true";
    }

    public String saveCategory() {
        if (category.getId() == null) {
            categoryRepository.insertCategory(category);
        } else {
            categoryRepository.updateCategory(category);
        }
        return "categories.xhtml";
    }

    public void deleteCategory(Category category) {
        logger.info("Deleting category.");
        categoryRepository.deleteCategory(category.getId());
    }

    public String editCategory(Category category) {
        this.category = category;
        return "/category.xhtml?faces-redirect=true";
    }
}
