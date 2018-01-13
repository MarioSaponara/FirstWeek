package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Gomma;
import main.model.Vehicle;
import main.service.CompatibilityService;
import main.service.VehicleService;

import java.util.List;
import java.util.Scanner;

public class VehicleView implements View {

    private VehicleService vehicleService;
    private CompatibilityService compatibilityService;
    private String mode;
    private String role;
    private String nome;

    public VehicleView () {
        this.vehicleService = new VehicleService();
        this.compatibilityService = new CompatibilityService();
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
            case "all": {
                List<Vehicle> vehicles = vehicleService.getAllVehicles();
                if (!vehicles.isEmpty()) {
                    System.out.println("----- Veicoli registrati -----");
                    System.out.println();
                    vehicles.forEach(vehicle -> System.out.println(vehicle + "\n"));
                }
                else
                    System.out.println("Al momento non sono presenti auto registrate");
            }
                break;
            case "insert": {
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
                Vehicle newvehicle=new Vehicle(null, brand, model, fuel, version, capacity);
                List<Vehicle> vehicles = vehicleService.getAllVehicles();
                boolean trovato=false;
                if (!vehicles.isEmpty()) {
                    for (Vehicle vehicle : vehicles) {
                        if (vehicle.equals(newvehicle)){
                            trovato=true;
                        }
                    }
                }
                if(vehicles.isEmpty() || !trovato) {
                    vehicleService.insertVehicle(newvehicle);
                    System.out.println("Veicolo inserito nel DB");
                }
                else
                    System.out.println("Veicolo già presente nel DB");
            }
                break;
            case "remove":{
                List<Vehicle> vehicles = vehicleService.getAllVehicles();
                System.out.println("----- Veicoli disponibili -----");
                System.out.println();
                if (!vehicles.isEmpty()) {
                    vehicles.forEach(vehicle -> System.out.println(vehicle + "\n"));
                    System.out.println("Inserisci codice veicolo da rimuovere:");
                    Integer codevehicle = Integer.parseInt(getInput());
                    compatibilityService.removeCompatibility(codevehicle, 0);
                    vehicleService.removeVehicle(codevehicle);
                }else
                    System.out.println("Al momento non sono presenti auto registrate");
            }
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
