/**
 * @author Ostrovskiy Dmitriy
 * @created 07.07.2020
 * ProductServiceWsInterface
 * @version v1.0
 */

package ru.geekbrains.service.impl.ws;

import ru.geekbrains.service.repr.ProductRepr;
import ru.geekbrains.service.repr.ProductReprWs;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.PathParam;
import java.util.List;

@WebService
public interface ProductServiceWsInterface {

    @WebMethod
    List<ProductReprWs> findAllProductWs();

    @WebMethod
    void insertProductWs(ProductRepr productRepr);

    @WebMethod
    void updateProductWs(ProductRepr productRepr);

    @WebMethod
    void deleteProductWs(long id);

    @WebMethod
    ProductReprWs findProductByIdWs(long id);

    @WebMethod
    ProductRepr findProductReprByNameWs(String name);

    @WebMethod
    List<ProductRepr> findAllProductByCategoryIdWs(long id);

}
