package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Vehicle;
import main.service.VehicleService;

import java.util.List;
import java.util.Scanner;

public class VehicleView implements View {

    private VehicleService vehicleService;
    private String mode;
    private String role;
    private String nome;

    public VehicleView () {
        this.vehicleService = new VehicleService();
        this.mode = "all";
    }

    @Override
    public void showResults(Request request) {
        this.mode  = (String) request.get("mode");
        this.role = (String) request.get("role");
        this.nome = (String) request.get("nome");
    }

    @Override
    public void showOptions() {
        switch (mode) {
            case "all":
                List<Vehicle> vehicles = vehicleService.getAllVehicles();
                System.out.println("----- Veicoli registrati -----");
                System.out.println();
                if (!vehicles.isEmpty())
                    vehicles.forEach(vehicle -> System.out.println(vehicle));
                else
                    System.out.println("Al momento non sono presenti auto registrate");
                break;
            case "insert":
                Scanner scanner = new Scanner(System.in);
                System.out.println("Inserisci veicoli:");
                System.out.println("Marca:");
                String brand = getInput();
                System.out.println("Modello:");
                String model = getInput();
                System.out.println("Alimentazione:");
                String fuel = getInput();
                System.out.println("Versione:");
                String version = getInput();
                System.out.println("Cilindrata:");
                String capacity = getInput();
                vehicleService.insertVehicle(new Vehicle(null, brand, model, fuel, version, capacity));
        }
    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void submit() {
        Request request = new Request();
        request.put("role", role);
        request.put("nome", nome);
        MainDispatcher.getInstance().callAction("Login", "doControl", request);
    }
}
