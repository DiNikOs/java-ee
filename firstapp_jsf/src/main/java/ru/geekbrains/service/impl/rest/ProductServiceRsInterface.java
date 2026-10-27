/**
 * @author Ostrovskiy Dmitriy
 * @created 07.07.2020
 * ProductServiceRsInterface
 * @version v1.0
 */

package ru.geekbrains.service.impl.rest;

import ru.geekbrains.service.repr.ProductRepr;

import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Local
@Path("/product")
public interface ProductServiceRsInterface {

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    List<ProductRepr> findAllProduct();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    void insertProduct(ProductRepr productRepr);

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    void updateProduct(ProductRepr productRepr);

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    void deleteProduct(@PathParam("id") long id);

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    ProductRepr findProductById(@PathParam("id") long id);

    @GET
    @Path("/name/{name}")
    @Consumes("text/html")
    @Produces(MediaType.APPLICATION_JSON)
    ProductRepr findProductReprByName(@PathParam("name") String name);


    @GET
    @Path("/{id}/category")
    @Produces(MediaType.APPLICATION_JSON)
    List<ProductRepr> findAllProductByCategoryId(@PathParam("id") long id);
}