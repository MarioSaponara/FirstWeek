package main.controller;

import main.MainDispatcher;
import main.service.LoginService;

import java.util.List;

public class LoginController implements Controller {

    private LoginService loginService;

    public LoginController() {
        loginService = new LoginService();
    }

    public void doControl(Request request) {
        if ((request != null) && ((request.get("role")==null))) {
            String nomeUtente = request.get("nomeUtente").toString();
            String password = request.get("password").toString();
            List<String> data= loginService.login(nomeUtente, password);
            if (!data.isEmpty()) {
                String nome=data.get(0);
                request.put("nome", nome);
                String role=data.get(1);
                request.put("role", role);
                MainDispatcher.getInstance().callView("Menu", request);
            }
            else
                MainDispatcher.getInstance().callView("Login", request);
        } else
            MainDispatcher.getInstance().callView("Menu", request);
    }
}
