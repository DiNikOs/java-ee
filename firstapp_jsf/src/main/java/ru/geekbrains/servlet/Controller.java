/**
 * @author Ostrovskiy Dmitriy
 * @created 04.06.2020
 * Controller
 * @version v1.0
 */

package ru.geekbrains.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class Controller extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(Controller.class);
    private List<Product> products = new ArrayList<>();
    private Product product;
    private long indx = 9;

    @Override
    public void init() throws ServletException {
//        LocalDateTime localDateTime = LocalDateTime.now();
//        Long data = localDateTime.toEpochSecond(ZoneOffset.UTC);
//        products.add(new Product(1L, "Пицца", "4 сыра", bd(180), null, new Date(data)));
//        products.add(new Product(2L, "Суши", "Филаделфия", bd(150), null, new Date(data)));
//        products.add(new Product(3L, "Роллы", "Кирияки", bd(150), null, new Date(data)));
//        products.add(new Product(4L, "Салат", "Цезарь", bd(150), null, new Date(data)));
//        products.add(new Product(5L, "Гарнир", "Картофильное пюре", bd(150), null, new Date(data)));
//        products.add(new Product(6L, "Закуски", "Овощная нарезка", bd(150), null, new Date(data)));
//        products.add(new Product(7L, "Десерт", "Жаренные бананы", bd(150), null, new Date(data)));
//        products.add(new Product(8L, "Напитки", "Коктель молотова", bd(150), null, new Date(data)));
//        products.add(new Product(9L, "Мясо", "Бараний стейк", bd(150), null, new Date(data)));
    }

    public BigDecimal bd (int big){
        BigDecimal bd = new BigDecimal(big);
        return bd;
    }
}
