/**
 * @author Ostrovskiy Dmitriy
 * @created 29.05.2020
 * FooterServlet
 * @version v1.0
 */

package ru.geekbrains.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;

@WebServlet(name = "footer", urlPatterns = "/footer")
public class FooterServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(FooterServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException {
        logger.info("New GET Request FooterServlet");
        resp.getWriter().printf("<footer><h2>FooterServlet</h2>");
        resp.getWriter().printf("<ul>");
        resp.getWriter().printf("<li><a href=\"" + getServletContext().getContextPath() + "/main\">Главная страница</a></li>");
        resp.getWriter().printf("<li><a href=\"" + getServletContext().getContextPath() + "/catalog\">Каталог</a></li>");
        resp.getWriter().printf("<li><a href=\"" + getServletContext().getContextPath() + "/product\">Товар</a></li>");
        resp.getWriter().printf("<li><a href=\"" + getServletContext().getContextPath() + "/cart\">Корзина</a></li>");
        resp.getWriter().printf("<li><a href=\"" + getServletContext().getContextPath() + "/order\">Оформить заказ</a></li>");
        resp.getWriter().printf("</ul>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException {
        logger.info("New POST Request FooterServlet");
        resp.getWriter().printf("<footer><h1>New POST request FooterServlet</h1>");
        resp.getWriter().printf("</footer>");
    }
}
