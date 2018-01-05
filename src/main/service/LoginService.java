package main.service;

import main.dao.LoginDAO;
import java.util.List;

public class LoginService {

    private LoginDAO loginDAO;

    public LoginService() {
        this.loginDAO = new LoginDAO();
    }

    public List<String> login (String username, String password) {
        return this.loginDAO.login(username, password);
    }
}
