/**
 * @author Ostrovskiy Dmitriy
 * @created 14.07.2020
 * RoleRepr
 * @version v1.0
 */

package ru.geekbrains.service.repr;

import ru.geekbrains.entity.Role;

import java.io.Serializable;
import java.util.Objects;

public class RoleRepr implements Serializable {

    private long id;

    private String name;

    public RoleRepr() {
    }

    public RoleRepr(Role r) {
        this.id = r.getId();
        this.name = r.getName();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleRepr roleRepr = (RoleRepr) o;
        return name.equals(roleRepr.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}