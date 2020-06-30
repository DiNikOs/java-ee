/**
 * @author Ostrovskiy Dmitriy
 * @created 30.06.2020
 * CategoryServiceRemoteInterface
 * @version v1.0
 */

package ru.geekbrains.service.impl;

import ru.geekbrains.service.repr.CategoryRepr;

import javax.ejb.Asynchronous;
import javax.ejb.Remote;
import java.util.List;
import java.util.concurrent.Future;

@Remote
public interface CategoryServiceRemoteInterface {

    List<CategoryRepr> findAll();

    @Asynchronous
    Future<CategoryRepr> findByIdAsync(long id);
}
