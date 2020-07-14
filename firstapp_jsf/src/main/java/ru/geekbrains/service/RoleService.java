/**
 * @author Ostrovskiy Dmitriy
 * @created 14.07.2020
 * RoleService
 * @version v1.0
 */

package ru.geekbrains.service;

import ru.geekbrains.repository.RoleRepository;
import ru.geekbrains.service.repr.RoleRepr;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class RoleService implements Serializable {

    @Inject
    private RoleRepository roleRepository;

    @TransactionAttribute
    public List<RoleRepr> getAllRoles() {
        return roleRepository.getAllRoles().stream()
                .map(RoleRepr::new)
                .collect(Collectors.toList());
    }
}
