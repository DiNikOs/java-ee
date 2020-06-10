/**
 * @author Ostrovskiy Dmitriy
 * @created 04.06.2020
 * Controller
 * @version v1.0
 */

package ru.geekbrains.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name ="Controller", urlPatterns =
        {"", "/", "/main", "/catalog", "/product", "/cart", "/order",
                "/product/see","/product/add","/product/edit", "/product/save", "/product/del"})
public class Controller extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(Controller.class);
    private List<Product> products = new ArrayList<>();
    private Product product;
    private long indx = 9;

    @Override
    public void init() throws ServletException {
        products.add(new Product(1L, "Пицца", "4 сыра", 200));
        products.add(new Product(2L, "Суши", "Филаделфия", 150));
        products.add(new Product(3L, "Роллы", "Кирияки", 200));
        products.add(new Product(4L, "Салат", "Цезарь", 180));
        products.add(new Product(5L, "Гарнир", "Картофильное пюре", 80));
        products.add(new Product(6L, "Закуски", "Овощная нарезка", 100));
        products.add(new Product(7L, "Десерт", "Жаренные бананы", 300));
        products.add(new Product(8L, "Напитки", "Коктель молотова", 700));
        products.add(new Product(9L, "Мясо", "Бараний стейк", 500));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        logger.info("Index page start");
        String url = "/WEB-INF/views/";
        switch (req.getServletPath()) {
            case ("/"):
                url +="index.jsp";
                break;
            case ("/main"):
                url +="main.jsp";
                break;
            case ("/catalog"):
                req.setAttribute("products", products);
                url +="catalog.jsp";
                logger.info("Catalog page");
                break;
            case ("/product"):
                url +="product.jsp";
                logger.info("Product page");
                break;
            case ("/product/see"):
                product = products.get(Integer.parseInt(req.getParameter("id"))-1);
                req.setAttribute("product", product);
                url +="product.jsp";
                logger.info("Product see page");
                break;
            case ("/product/add"):
//                long indMax = products.get(products.size()-1).getId();
                product = new Product(++indx,"","", 0);
                products.add(product);
                req.setAttribute("product", product);
                url +="product_edit.jsp";
                logger.info("Product add page");
                break;
            case ("/product/edit"):
                product = products.get(Integer.parseInt(req.getParameter("id"))-1);
                req.setAttribute("product", product);
                url +="product_edit.jsp";
                logger.info("Product edit page");
                break;
            case ("/product/del"):
                product = products.get(Integer.parseInt(req.getParameter("id"))-1);
                products.remove(product);
                req.setAttribute("products", products);
                url +="catalog.jsp";
                logger.info("Product del");
                break;
            case ("/cart"):
                url +="cart.jsp";
                logger.info("Cart page");
                break;
            case ("/order"):
                url +="order.jsp";
                logger.info("Order page");
                break;
            default:
                url +="error.jsp";
                logger.info("Error!");
        }
        req.getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Post msg");
        req.setCharacterEncoding("UTF-8");
        String url = "/WEB-INF/views/";
        int indList = 0;
        if (req.getParameter("id").equals("")) {
            resp.sendRedirect(getServletContext().getContextPath() + "/product/add");
        }
        String indStr = req.getParameter("id");
        long ind = Long.parseLong(indStr);
        Integer price = Integer.valueOf(req.getParameter("price"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        product.setId(ind);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        indList = products.indexOf(product);
        products.set(indList, product);
        resp.sendRedirect(getServletContext().getContextPath() + "/catalog");
    }
}
