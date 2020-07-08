/**
 * @author Ostrovskiy Dmitriy
 * @created 04.07.2020
 * EjbClient
 * @version v1.0
 */

package ru.dinikos.client;

import ru.geekbrains.service.impl.remote.ProductServiceRemoteInterface;
import ru.geekbrains.service.repr.ProductRepr;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.Future;

public class EjbClient {

    public static void main(String[] args) throws Exception {
        Context context = createInitialContext();

        ProductServiceRemoteInterface service = (ProductServiceRemoteInterface) context.lookup("ejb:/firstapp_jsf/ProductService!ru.geekbrains.service.impl.ProductServiceRemoteInterface");
        service.findAllProduct().forEach(product -> System.out.println(product.getDescription()));

        Future<ProductRepr> future = service.findProductByIdAsync(1L);
        System.out.println(future.get());
    }

    public static Context createInitialContext() throws IOException, NamingException {
        final Properties env = new Properties();
        env.load(EjbClient.class.getClassLoader().getResourceAsStream("wildfly-jndi.properties"));
        return new InitialContext(env);
    }
}
