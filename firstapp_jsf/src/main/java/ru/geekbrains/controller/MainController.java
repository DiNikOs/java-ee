package ru.geekbrains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import java.io.Serializable;

@SessionScoped
@Named
public class MainController implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);


}