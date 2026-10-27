/**
 * @author Ostrovskiy Dmitriy
 * @created 04.07.2020
 * WsClient
 * @version v1.0
 */

package ru.dinikos.wsclient;

import ru.geekbrains.service.ProductService;
import ru.geekbrains.service.ProductServiceWsInterface;
import ru.geekbrains.service.impl.ws.ProductRepr;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class WsClient {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/firstapp_jsf/ProductService/ProductService?wsdl");
        ProductService productService = new ProductService(url);

        ProductServiceWsInterface productServicePort = productService.getProductServicePort();

        System.out.println("=== Find All ===");
        productServicePort.findAllProductWs().forEach(product -> System.out.println(product.getDescription()));

        System.out.println("=== Find ProductByIdWs ===");
        System.out.println(productServicePort.findProductByIdWs(1).toString());

        System.out.println("=== Find ProductByName ===");
        ProductRepr prod = productServicePort.findProductReprByNameWs("Product1");

        System.out.println(toStringS(prod));

        System.out.println("=== Find ProductByCategoryId ===");
        System.out.println("Category= " + productServicePort.findAllProductByCategoryIdWs(1).get(0).getCategoryName());
        List<ProductRepr> prodList = productServicePort.findAllProductByCategoryIdWs(1);
        for (ProductRepr productRepr : prodList) {
            System.out.println(toStringS(productRepr));
        }

    }

    public static String toStringS(ProductRepr prod) {
        return "Product:" +
                "id=" + prod.getId() +
                "name=" + prod.getName() +
                "discription=" + prod.getDescription() +
                "price=" + prod.getPrice() +
                "date=" + prod.getLocalDate() +
                "category=" + prod.getCategoryName();
    }
}
