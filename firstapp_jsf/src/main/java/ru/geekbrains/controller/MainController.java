package ru.geekbrains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.service.RoleService;
import ru.geekbrains.service.UserService;
import ru.geekbrains.service.repr.RoleRepr;
import ru.geekbrains.service.repr.UserRepr;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SessionScoped
@Named
public class MainController implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @EJB
    private UserService userService;

    @EJB
    private RoleService roleRepository;

    private UserRepr user;

    private List<RoleRepr> roles;

    private List<UserRepr> users;

    public void preloadNewUser(ComponentSystemEvent componentSystemEvent) {
        this.user = new UserRepr();
    }

    public String registerUser() {
        this.user = new UserRepr();
        return "/user.xhtml?faces-redirect=true";
    }

    public String saveUser() {
        if (roles==null) {
            Set<RoleRepr> roleReprs =  new HashSet<>();
            roleReprs.add(roleRepository.getAllRoles().get(1));
            this.user.setRoles(roleReprs);
        }
        userService.merge(this.user);
        return "/login.xhtml?faces-redirect=true";
    }

    public String logout() {
        ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
        return "/index.xhtml?faces-redirect=true";
    }

    public UserRepr getUser() {
        return user;
    }

    public void setUser(UserRepr user) {
        this.user = user;
    }
}