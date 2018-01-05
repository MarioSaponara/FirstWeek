package main.controller;

import main.MainDispatcher;
import main.service.LoginService;

public class HomeController implements Controller {

    public HomeController() {
    }

    public void doControl (Request request) {
        MainDispatcher.getInstance().callView("Home", request);
    }
}
