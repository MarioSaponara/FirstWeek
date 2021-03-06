package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Compatibility;
import main.model.Gomma;
import main.model.Vehicle;
import main.service.CompatibilityService;
import main.service.GommaService;
import main.service.VehicleService;

import java.util.List;
import java.util.Scanner;

public class CompatibilityView implements View {

    private VehicleService vehicleService;
    private GommaService gommaService;
    private CompatibilityService compatibilityService;
    private String mode;
    private String role;
    private String nome;

    public CompatibilityView () {
        this.vehicleService = new VehicleService();
        this.gommaService = new GommaService();
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
            case "insert":
                List<Vehicle> vehicles = vehicleService.getAllVehicles();
                List<Gomma> gomme = gommaService.getAllGommeForAuto();
                if (!vehicles.isEmpty() && !gomme.isEmpty()) {
                    System.out.println("----- Veicoli registrati -----");
                    System.out.println();
                    vehicles.forEach(vehicle -> System.out.println(vehicle));
                    System.out.println("Scegli il codice del veicolo per assegnarli una compatibilità:");
                    Integer codevehicle = Integer.parseInt(getInput());
                    System.out.println("----- Gomme per auto disponibili -----");
                    System.out.println();
                    gomme.forEach(gomma -> System.out.println(gomma));
                    System.out.println("Scegli il codice del gomma per assegnarli una compatibilità:");
                    Integer codegomma = Integer.parseInt(getInput());
                    Compatibility newcompatibility = new Compatibility(codevehicle, codegomma);
                    List<Compatibility> allcompatibility = compatibilityService.getAllCompatibility();
                    boolean trovato = false;
                    if (!allcompatibility.isEmpty()) {
                        for (Compatibility compatibility : allcompatibility) {
                            if (compatibility.equals(newcompatibility)) {
                                trovato = true;
                            }
                        }
                    }
                    if (allcompatibility.isEmpty() || !trovato) {
                        compatibilityService.insertCompatibility(newcompatibility);
                        System.out.println("Compatibilità inserita");
                    } else
                        System.out.println("Compatibilità già DB");
                }else
                    System.out.println("Non è possibili inserire una compatibilità");
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
