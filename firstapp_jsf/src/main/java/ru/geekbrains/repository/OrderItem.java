/**
 * @author Ostrovskiy Dmitriy
 * @created 17.06.2020
 * OrderItem
 * @version v1.0
 */

package ru.geekbrains.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.entity.ToDo;
import ru.geekbrains.entity.ToDoRepository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public class OrderItem {

    private static final Logger logger = LoggerFactory.getLogger(ToDoRepository.class);

    @PersistenceContext(unitName = "db_firstapp")
    private EntityManager em;

    @PostConstruct
    public void init() {
        if (this.findAll().isEmpty()) {
            this.insert(new ToDo(-1L, "First", LocalDate.now()));
            this.insert(new ToDo(-1L, "Second", LocalDate.now().plusDays(1)));
            this.insert(new ToDo(-1L, "Third", LocalDate.now().plusDays(2)));
        }
    }

    @Transactional
    public void insert(ToDo toDo) {
        em.persist(toDo);
    }

    @Transactional
    public void update(ToDo toDo) {
        em.merge(toDo);
    }

    @Transactional
    public void delete(long id) {
        ToDo toDo = em.find(ToDo.class, id);
        if (toDo != null) {
            em.remove(toDo);
        }
    }

    public ToDo findById(long id) {
        return em.find(ToDo.class, id);
    }

    public List<ToDo> findAll() {
        return em.createQuery("from ToDo", ToDo.class).getResultList();
    }
}
