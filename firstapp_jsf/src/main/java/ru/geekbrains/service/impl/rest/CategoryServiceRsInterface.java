/**
 * @author Ostrovskiy Dmitriy
 * @created 05.07.2020
 * CategoryServiceRs
 * @version v1.0
 */

package ru.geekbrains.service.impl.rest;

import ru.geekbrains.entity.Category;
import ru.geekbrains.service.repr.CategoryRepr;
import ru.geekbrains.service.repr.ProductRepr;

import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Local
@Path("/category")
public interface CategoryServiceRsInterface {

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    List<CategoryRepr> findAllCategories();

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    void insertCategory(CategoryRepr categoryRepr);

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    void updateCategory(CategoryRepr categoryRepr);

    @DELETE
    @Path("/{id}/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    void deleteCategory(@PathParam("id") long id);

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    CategoryRepr findCategoryById(@PathParam("id") long id);
}
