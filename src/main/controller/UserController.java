package main.controller;

import main.MainDispatcher;

public class UserController implements Controller{

    @Override
    public void doControl(Request request) {
        int choice = (int) request.get("choice");
        switch (choice) {
            case 1:
                request.put("mode", "login");
                break;
            case 2:
                request.put("mode", "insert");
                break;
            case 5:
                request.put("mode", "all");
                break;
            case 6:
                request.put("mode", "remove");
        }

        if (choice==1) {
            MainDispatcher.getInstance().callView("Login", request);
        }
        else
            MainDispatcher.getInstance().callView("User", request);
    }
}