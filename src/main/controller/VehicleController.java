package main.controller;

import main.MainDispatcher;

public class VehicleController implements Controller{

    @Override
    public void doControl(Request request) {
        int choice = (int) request.get("choice");
        switch (choice) {
            case 6:
                request.put("mode", "insert");
                break;
            case 7:
                request.put("mode", "all");
                break;
            case 8:
                request.put("mode", "remove");
                break;
        }
        MainDispatcher.getInstance().callView("Vehicle", request);
    }
}
