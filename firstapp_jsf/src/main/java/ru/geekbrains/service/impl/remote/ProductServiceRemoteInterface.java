/**
 * @author Ostrovskiy Dmitriy
 * @created 30.06.2020
 * ProductServiceRemoteInterface
 * @version v1.0
 */

package ru.geekbrains.service.impl.remote;

import ru.geekbrains.service.repr.ProductRepr;

import javax.ejb.Asynchronous;
import javax.ejb.Remote;
import java.util.List;
import java.util.concurrent.Future;

@Remote
public interface ProductServiceRemoteInterface {

    List<ProductRepr> findAllProduct();

    @Asynchronous
    Future<ProductRepr> findProductByIdAsync(long id);
}
