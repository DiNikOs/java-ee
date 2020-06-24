/**
 * @author Ostrovskiy Dmitriy
 * @created 17.06.2020
 * Order
 * @version v1.0
 */

package ru.geekbrains.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.entity.Order;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Named
public class OrderRepository {

    private static final Logger logger = LoggerFactory.getLogger(OrderRepository.class);

    @PersistenceContext(unitName = "ds")
    private EntityManager entityManager;

    @PostConstruct
    public void init() {
    }

    @Transactional
    public void insertOrder(Order order) {
        entityManager.persist(order);
    }

    @Transactional
    public void updateOrder(Order order) {
        entityManager.merge(order);
    }

    @Transactional
    public void deleteOrder(long id) {
        Order order = entityManager.find(Order.class, id);
        if (order != null) {
            entityManager.remove(order);
        }
    }

    public Order findOrderById(long id) {
        return entityManager.find(Order.class, id);
    }

    public List<Order> findAllOrder() {
        return entityManager.createQuery("from Order", Order.class).getResultList();
    }
}
