/**
 * @author Ostrovskiy Dmitriy
 * @created 29.05.2020
 * OrderServlet
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

@WebServlet(name = "order", urlPatterns = "/order")
public class OrderServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(OrderServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException {
        logger.info("New GET Request OrderServlet");
        resp.getWriter().printf("<h1>OrderServlet</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException {
        logger.info("New POST Request OrderServlet");
        resp.getWriter().printf("<h1>New POST request OrderServlet</h1>");
    }
}
