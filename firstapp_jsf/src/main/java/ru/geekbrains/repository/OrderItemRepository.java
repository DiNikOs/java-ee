/**
 * @author Ostrovskiy Dmitriy
 * @created 17.06.2020
 * OrderItem
 * @version v1.0
 */

package ru.geekbrains.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.entity.OrderItem;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Named
public class OrderItemRepository {

    private static final Logger logger = LoggerFactory.getLogger(OrderItemRepository.class);

    @PersistenceContext(unitName = "ds")
    private EntityManager entityManager;

    @PostConstruct
    public void init() {
    }

    @Transactional
    public void insert(OrderItem orderItem) {
        entityManager.persist(orderItem);
    }

    @Transactional
    public void update(OrderItem orderItem) {
        entityManager.merge(orderItem);
    }

    @Transactional
    public void delete(long id) {
        OrderItem orderItem = entityManager.find(OrderItem.class, id);
        if (orderItem != null) {
            entityManager.remove(orderItem);
        }
    }

    public OrderItem findById(long id) {
        return entityManager.find(OrderItem.class, id);
    }

    public List<OrderItem> findAll() {
        return entityManager.createQuery("from OrderItem", OrderItem.class).getResultList();
    }
}
