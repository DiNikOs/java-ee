/**
 * @author Ostrovskiy Dmitriy
 * @created 29.05.2020
 * HeaderServlet
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

@WebFilter(urlPatterns = "/*")
public class HeaderServlet implements Filter {

    private static Logger logger = LoggerFactory.getLogger(HeaderServlet.class);

    private transient FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        logger.info("Filter HeaderServlet");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().printf("<head><meta charset=\"utf-8\"></head>");
        resp.getWriter().printf("<header><h2>HeaderServlet</h2>");
        resp.getWriter().printf("<ul>");
        resp.getWriter().printf("<li><a href=\"" + filterConfig.getServletContext().getContextPath() + "/main\">Главная страница</a></li>");
        resp.getWriter().printf("<li><a href=\"" + filterConfig.getServletContext().getContextPath() + "/catalog\">Каталог</a></li>");
        resp.getWriter().printf("<li><a href=\"" + filterConfig.getServletContext().getContextPath() + "/product\">Товар</a></li>");
        resp.getWriter().printf("<li><a href=\"" + filterConfig.getServletContext().getContextPath() + "/cart\">Корзина</a></li>");
        resp.getWriter().printf("<li><a href=\"" + filterConfig.getServletContext().getContextPath() + "/order\">Оформить заказ</a></li>");
        resp.getWriter().printf("</ul>");
        resp.getWriter().printf("</header>");
        chain.doFilter(req, resp);
        filterConfig.getServletContext().getRequestDispatcher("/footer").include(req, resp);
    }

    @Override
    public void destroy() {

    }
}


