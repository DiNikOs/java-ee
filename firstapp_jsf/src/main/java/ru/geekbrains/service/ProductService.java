/**
 * @author Ostrovskiy Dmitriy
 * @created 30.06.2020
 * ProductService
 * @version v1.0
 */

package ru.geekbrains.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.entity.Category;
import ru.geekbrains.entity.Product;
import ru.geekbrains.repository.CategoryRepository;
import ru.geekbrains.repository.ProductRepository;
import ru.geekbrains.service.impl.rest.ProductServiceRsInterface;
import ru.geekbrains.service.impl.ws.ProductServiceWsInterface;
import ru.geekbrains.service.repr.ProductRepr;
import ru.geekbrains.service.impl.local.ProductServiceLocalInterface;
import ru.geekbrains.service.impl.remote.ProductServiceRemoteInterface;
import ru.geekbrains.service.repr.ProductReprWs;

import javax.ejb.AsyncResult;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.jws.WebService;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Stateless
@WebService(endpointInterface = "ru.geekbrains.service.impl.ws.ProductServiceWsInterface", serviceName = "ProductService")
public class ProductService implements ProductServiceLocalInterface, ProductServiceRemoteInterface, ProductServiceWsInterface, ProductServiceRsInterface {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @EJB
    private ProductRepository prodRepository;

    @EJB
    private CategoryRepository catRepository;

    @Override
    @TransactionAttribute
    public void insertProduct(ProductRepr productRepr) {
        Category category = catRepository.findCategoryById(productRepr.getCategoryId());
        prodRepository.insertProduct(new Product(null, productRepr.getName(), productRepr.getDescription(), productRepr.getPrice(), category, new Date(productRepr.getLocalDate().getTime())));
    }

    @Override
    @TransactionAttribute
    public void updateProduct(ProductRepr productRepr) {
        Product product = prodRepository.findProductById(productRepr.getId());
        Category category = catRepository.findCategoryById(productRepr.getCategoryId());
        prodRepository.updateProduct(new Product(product.getId(), productRepr.getName(), productRepr.getDescription(), productRepr.getPrice(), category, new Date(productRepr.getLocalDate().getTime())));
    }

    @Override
    @TransactionAttribute
    public void deleteProduct(long id) {
        prodRepository.deleteProduct(id);
    }

    @Override
    public ProductRepr findProductById(long id) {
        return prodRepository.findProductReprById(id);
    }

    @Override
    public List<ProductRepr> findAllProduct() {
        return prodRepository.findAllProductRepr();
    }

    @Override
    public List<ProductRepr> findAllProductByCategoryId(long id) {
        return prodRepository.findAllProductReprByCateoryId(id);
    }

    @Override
    public ProductRepr findProductReprByName(String name) {
        return prodRepository.findProductReprByName(name);
    }

    @Override
    public Future<ProductRepr> findProductByIdAsync(long id) {
                try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>(prodRepository.findProductReprById(id));
    }

    @Override
    public List<ProductReprWs> findAllProductWs() {
        return prodRepository.findAllProduct().stream().map(productRepr -> new ProductReprWs(productRepr)).collect(Collectors.toList());
    }

    @Override
    public ProductReprWs findProductByIdWs(long id) {
        return new ProductReprWs(prodRepository.findProductById(id));
    }

    @Override
    public void insertProductWs(ProductRepr productRepr) {
        Category category = catRepository.findCategoryById(productRepr.getCategoryId());
        prodRepository.insertProduct(new Product(null, productRepr.getName(), productRepr.getDescription(), productRepr.getPrice(), category, new Date(productRepr.getLocalDate().getTime())));
    }

    @Override
    public void updateProductWs(ProductRepr productRepr) {
        Product product = prodRepository.findProductById(productRepr.getId());
        Category category = catRepository.findCategoryById(productRepr.getCategoryId());
        prodRepository.updateProduct(new Product(product.getId(), productRepr.getName(), productRepr.getDescription(), productRepr.getPrice(), category, new Date(productRepr.getLocalDate().getTime())));
    }

    @Override
    public void deleteProductWs(long id) {
        prodRepository.deleteProduct(id);
    }

    @Override
    public ProductRepr findProductReprByNameWs(String name) {
        return prodRepository.findProductReprByName(name);
    }

    @Override
    public List<ProductRepr> findAllProductByCategoryIdWs(long id) {
        return prodRepository.findAllProductReprByCateoryId(id);
    }
}
