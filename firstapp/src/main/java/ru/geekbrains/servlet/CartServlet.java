/**
 * @author Ostrovskiy Dmitriy
 * @created 29.05.2020
 * CartServlet
 * @version v1.0
 */

package ru.geekbrains.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;

@WebServlet(name = "cart", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(CartServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException {
        logger.info("CartServlet");
        resp.getWriter().printf("<h1>CartServlet</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException {
        logger.info("New POST Request CartServlet");
        resp.getWriter().printf("<h1>New POST request CartServlet</h1>");
    }
}
