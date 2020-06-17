/**
 * @author Ostrovskiy Dmitriy
 * @created 04.06.2020
 * Register
 * @version v1.0
 */

package ru.geekbrains.servlet;

public class Register {

    private String user;
    private String pass;

    public Register() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
