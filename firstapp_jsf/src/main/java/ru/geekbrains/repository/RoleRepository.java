/**
 * @author Ostrovskiy Dmitriy
 * @created 14.07.2020
 * RoleRepository
 * @version v1.0
 */

package ru.geekbrains.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.entity.Role;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class RoleRepository {

    private Logger logger = LoggerFactory.getLogger(RoleRepository.class);

    @PersistenceContext(unitName = "ds")
    protected EntityManager em;

    @TransactionAttribute
    public Role merge(Role role) {
        return em.merge(role);
    }

    public Role findById(int id) {
        return em.find(Role.class, id);
    }

    public List<Role> getAllRoles() {
        return em.createQuery("from Role ", Role.class).getResultList();
    }

    public long getCount() {
        return em.createQuery("select count(*) from Role", Long.class)
                .getSingleResult();
    }
}