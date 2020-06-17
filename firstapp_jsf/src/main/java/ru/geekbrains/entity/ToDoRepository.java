package ru.geekbrains.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
@Named
public class ToDoRepository {

    private static final Logger logger = LoggerFactory.getLogger(ToDoRepository.class);

    @PersistenceContext(unitName = "ds")
    private EntityManager entityManager;

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
        entityManager.persist(toDo);
    }

    @Transactional
    public void update(ToDo toDo) {
        entityManager.merge(toDo);
    }

    @Transactional
    public void delete(long id) {
        ToDo toDo = entityManager.find(ToDo.class, id);
        if (toDo != null) {
            entityManager.remove(toDo);
        }
    }

    public ToDo findById(long id) {
        return entityManager.find(ToDo.class, id);
    }

    public List<ToDo> findAll() {
        return entityManager.createQuery("from ToDo", ToDo.class).getResultList();
    }
}
