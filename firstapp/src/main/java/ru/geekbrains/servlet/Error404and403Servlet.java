/**
 * @author Ostrovskiy Dmitriy
 * @created 29.05.2020
 * ExceptionServlet
 * @version v1.0
 */

package ru.geekbrains.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*", dispatcherTypes = {DispatcherType.ERROR})
public class Error404and403Servlet implements Filter {

    private static Logger logger = LoggerFactory.getLogger(Error404and403Servlet.class);
    private transient FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        Integer statusCode = (Integer) req.getAttribute("javax.servlet.error.status_code");
        logger.info("code error" + statusCode.toString());
        switch (statusCode) {
            case (404):
                resp.getWriter().printf("<h1>Code error 404!</h1>");
                resp.getWriter().printf("<a href=\"" + filterConfig.getServletContext().getContextPath()
                        + "/main\">Вернуться на главную страницу.</a>");
                break;
            case (403):
                resp.getWriter().printf("<h1>Code error 403!</h1>");
                resp.getWriter().printf("<a href=\"" + filterConfig.getServletContext().getContextPath()
                        + "/main\">Вернуться на главную страницу.</a>");
                break;
            default:
                resp.getWriter().printf("<h1>Unknown Error!</h1>");
        }
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
