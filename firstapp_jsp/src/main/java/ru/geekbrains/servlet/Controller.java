/**
 * @author Ostrovskiy Dmitriy
 * @created 04.06.2020
 * Controller
 * @version v1.0
 */

package ru.geekbrains.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.rmi.ServerException;

@WebServlet(name ="Controller", urlPatterns = {"", "/", "/main", "/catalog", "/product", "/cart", "/order"})
public class Controller extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String url = "/WEB-INF/views/";
        switch (req.getServletPath()) {
            case ("/"):
                url +="index.jsp";
                break;
            case ("/main"):
                url +="main.jsp";
                break;
            case ("/catalog"):
                url +="catalog.jsp";
                break;
            case ("/product"):
                url +="product.jsp";
                break;
            case ("/cart"):
                url +="cart.jsp";
                break;
            case ("/order"):
                url +="order.jsp";
                break;
            default:
                url +="error.jsp";
        }
        req.getRequestDispatcher(url).forward(req, resp);
    }

}
