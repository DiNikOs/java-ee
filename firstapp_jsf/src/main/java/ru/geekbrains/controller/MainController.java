package ru.geekbrains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import java.io.Serializable;

@SessionScoped
@Named
public class MainController implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    public String logout() {
        ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
        return "/index.xhtml?faces-redirect=true";
    }
}