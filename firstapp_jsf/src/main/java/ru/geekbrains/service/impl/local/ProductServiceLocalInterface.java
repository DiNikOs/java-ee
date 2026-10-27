/**
 * @author Ostrovskiy Dmitriy
 * @created 30.06.2020
 * ProductServiceLocalInterface
 * @version v1.0
 */

package ru.geekbrains.service.impl.local;

import ru.geekbrains.service.repr.ProductRepr;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProductServiceLocalInterface {

    void insertProduct(ProductRepr productRepr);

    void updateProduct(ProductRepr productRepr);

    void deleteProduct(long id);

    ProductRepr findProductById(long id);

    ProductRepr findProductReprByName(String name);

    List<ProductRepr> findAllProduct();

    List<ProductRepr> findAllProductByCategoryId(long id);
}
