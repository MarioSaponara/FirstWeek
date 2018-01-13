package main.controller;

import main.MainDispatcher;

public class VehicleController implements Controller{

    @Override
    public void doControl(Request request) {
        int choice = (int) request.get("choice");
        switch (choice) {
            case 7:
                request.put("mode", "insert");
                break;
            case 8:
                request.put("mode", "all");
                break;
            case 9:
                request.put("mode", "remove");
        }
        MainDispatcher.getInstance().callView("Vehicle", request);
    }
}
