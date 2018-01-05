package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Gomma;
import main.dao.GommaDAO;
import main.service.GommaService;
import main.service.VehicleService;

import java.util.List;
import java.util.Scanner;

public class GommaView implements View {

    private GommaService gommaService;
    private VehicleService vehicleService;
    private String mode;
    private String role;
    private String nome;

    public GommaView () {
        this.gommaService = new GommaService();
        this.vehicleService = new VehicleService();
        this.mode = "all";
    }

    @Override
    public void showResults(Request request) {
        this.mode  = (String) request.get("mode");
        role = (String) request.get("role");
        nome = (String) request.get("nome");
    }

    @Override
    public void showOptions() {
        switch (mode) {
            case "all":
                List<Gomma> gomme = gommaService.getAllGomme();
                System.out.println("----- Gomme disponibili -----");
                System.out.println();
                if (!gomme.isEmpty())
                    gomme.forEach(gomma -> System.out.println(gomma));
                else
                    System.out.println("Al momento non sono presenti gomme disponibili");
                break;
            case "insert":
                Scanner scanner = new Scanner(System.in);
                System.out.println("Inserisci i dati della nuova gomma:");
                System.out.println("Modello:");
                String model = getInput();
                System.out.println("Produttore:");
                String manufacturer = getInput();
                System.out.println("Prezzo:");
                double price = Double.parseDouble(getInput());
                System.out.println("Larghezza:");
                double width = Double.parseDouble(getInput());
                System.out.println("Altezza:");
                double height = Double.parseDouble(getInput());
                System.out.println("Diametro:");
                double diameter = Double.parseDouble(getInput());
                System.out.println("Carico:");
                double weight = Double.parseDouble(getInput());
                System.out.println("Velocità:");
                String speed = getInput();
                System.out.println("Stagione:");
                String season = getInput();
                System.out.println("Tipo veicolo:");
                String typevehicle = getInput();
                System.out.println("Numeri pezzi:");
                Integer quantity = Integer.parseInt(getInput());
                gommaService.insertGomma(new Gomma (null, model, manufacturer, price, width, height, diameter, weight, speed, season, typevehicle, quantity));
                break;
            case "allGommeForBrandAndTypeVehicle":
                System.out.println("Inserisci il tuo tipo di veicolo(auto-commerciale-moto):");
                String type = getInput();
                List<String> brands = gommaService.getAllManufacturerForType(type);
                if (!brands.isEmpty()){
                    System.out.println("-----Brand disponibili--------");
                    brands.forEach(String -> System.out.println(String));
                    System.out.println("-----Scegli il brand--------");
                    String brand = getInput();
                    List<Gomma> gommeBrand = gommaService.getAllGommeForManufacturer(brand, type);
                    if (!gommeBrand.isEmpty())
                        gommeBrand.forEach(gomma -> System.out.println(gomma));
                    else
                        System.out.println("Hai sbagliato a inserire il nome del brand");
                }else{
                    if(!(type.equals("auto") || type.equals("commerciale") || type.equals("moto")))
                        System.out.println("Tipo di veicolo inserito non correto");
                    else
                        System.out.println("Per il tipo di veicolo "+type+" non sono presenti gomme");
                }
                break;
            case "allGommeForDimension":
                System.out.println("Inserisci il tuo tipo di veicolo(auto-commerciale-moto):");
                String type2 = getInput();
                if(type2.equals("auto") || type2.equals("commerciale") || type2.equals("moto")) {
                    System.out.println("Inserisci le caratteristiche del tuo veicolo");
                    System.out.println("Larghezza:");
                    double width2 = Double.parseDouble(getInput());
                    System.out.println("Altezza:");
                    double height2 = Double.parseDouble(getInput());
                    System.out.println("Diametro:");
                    double diameter2 = Double.parseDouble(getInput());
                    System.out.println("Stagione:");
                    String season2 = getInput();
                    String speed2 = "";
                    double weight2 = 0;
                    if (!type2.equals("auto")) {
                        System.out.println("Velocità:");
                        speed2 = getInput();
                        System.out.println("Carico:");
                        weight2 = Double.parseDouble(getInput());
                    }
                    List<Gomma> gommeForDimension = gommaService.allGommaForDimension(type2, width2, height2, diameter2, season2, weight2, speed2);
                    if (!gommeForDimension.isEmpty())
                        gommeForDimension.forEach(gomma -> System.out.println(gomma));
                    else
                        System.out.println("Non sono presenti gomme con i dati inseriti");
                }else
                    System.out.println("Tipo di veicolo inserito non correto");
                break;
            case "allGommeForVehicle":
                System.out.println("Inserisci le caratteristiche della tua auto");
                System.out.println("Marca:");
                String brand_1 = getInput();
                System.out.println("Modello:");
                String model_1 = getInput();
                System.out.println("Alimentazione:");
                String fuel_1 = getInput();
                System.out.println("Modello:");
                String version_1 = getInput();
                System.out.println("Cilindrata:");
                String capacity_1 = getInput();
                Integer index=vehicleService.getVehicle(brand_1, model_1, fuel_1, version_1, capacity_1);
                if (!(index== null)) {
                    List<Gomma> gommeForVehicle = gommaService.allGommaForVehicle(index);
                    if (!gommeForVehicle.isEmpty())
                        gommeForVehicle.forEach(gomma -> System.out.println(gomma));
                    else
                        System.out.println("Non sono presenti gomme compatibili per questo tipo di macchina");
                }
                else{
                    System.out.println("ATTENZIONE-L'auto inserita non è registrata");
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