/**
 * @author Ostrovskiy Dmitriy
 * @created 05.07.2020
 * CartServiceRs
 * @version v1.0
 */

package ru.geekbrains.service.impl.rest;

import ru.geekbrains.beans.Cart;
import ru.geekbrains.service.repr.CategoryRepr;
import ru.geekbrains.service.repr.ProductRepr;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public interface CartServiceRsInterface {

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    List<Cart> findAllCart();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    void insertCart(Cart cart);

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    void updateCart(Cart cart);

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    void deleteCart(@PathParam("id") long id);

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Cart findCartById(@PathParam("id") long id);
}
