package main.controller;

import main.MainDispatcher;

public class CompatibilityController implements Controller{

    @Override
    public void doControl(Request request) {
        int choice = (int) request.get("choice");
        switch (choice) {
            case 9:
                request.put("mode", "insert");
                break;
        }
        MainDispatcher.getInstance().callView("Compatibility", request);
    }
}
