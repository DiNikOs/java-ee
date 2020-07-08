/**
 * @author Ostrovskiy Dmitriy
 * @created 30.06.2020
 * CategoryServiceLocalInterface
 * @version v1.0
 */

package ru.geekbrains.service.impl.local;

import ru.geekbrains.entity.Category;
import ru.geekbrains.service.repr.CategoryRepr;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CategoryServiceLocalInterface {

    void insertCategory(CategoryRepr categoryRepr);

    void updateCategory(CategoryRepr categoryRepr);

    void deleteCategory(long id);

    CategoryRepr findCategoryById(long id);

    List<CategoryRepr> findAllCategories();
}
