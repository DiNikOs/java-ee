/**
 * @author Ostrovskiy Dmitriy
 * @created 07.07.2020
 * CategoryServiceWsInterface
 * @version v1.0
 */

package ru.geekbrains.service.impl.ws;

import ru.geekbrains.service.repr.CategoryRepr;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface CategoryServiceWsInterface {

    @WebMethod
    List<CategoryRepr> findAllCategoryWs();

    @WebMethod
    CategoryRepr findCategoryByIdWs(long id);

}
