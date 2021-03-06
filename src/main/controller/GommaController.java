package main.controller;

import main.MainDispatcher;

public class GommaController implements Controller {

    @Override
    public void doControl(Request request) {
        int choice = (int) request.get("choice");
        String role = (String) request.get("role");
        switch (role) {
            case "admin":
                switch (choice) {
                    case 1:
                        request.put("mode", "insert");
                        break;
                    case 2:
                        request.put("mode", "all");
                        break;
                    case 3:
                        request.put("mode", "updatequantity");
                        break;
                    case 4:
                        request.put("mode", "remove");
                        break;
                }
                break;
            case "user":
                switch (choice) {
                    case 1:
                        request.put("mode", "all");
                        break;
                    case 2:
                        request.put("mode", "allGommeForBrandAndTypeVehicle");
                        break;
                    case 3:
                        request.put("mode", "allGommeForDimension");
                        break;
                    case 4:
                        request.put("mode", "allGommeForVehicle");
                        break;
                }
        }
        MainDispatcher.getInstance().callView("Gomma", request);
    }
}

