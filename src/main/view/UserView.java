package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.User;
import main.service.UserService;

import java.util.List;
import java.util.Scanner;

public class UserView implements View {

    private UserService userService;
    private String mode;
    private String role;
    private String nome;

    public UserView(){
        this.userService = new UserService();
    }
    @Override
    public void showResults(Request request) {
        this.mode  = (String) request.get("mode");
        this.role = (String) request.get("role");
    }

    @Override
    public void showOptions() {
        switch (mode) {
            case "all":
                List<User> users = userService.getAllUsers();
                System.out.println("----- Utenti registrati -----");
                System.out.println();
                users.forEach(user -> System.out.println(user));
                break;
            case "insert":
                Scanner scanner = new Scanner(System.in);
                System.out.println("Registrati:");
                System.out.println("Username:");
                String username = getInput();
                System.out.println("Password:");
                String password = getInput();
                System.out.println("Nome:");
                String firstname = getInput();
                System.out.println("Cognome:");
                String lastname = getInput();
                System.out.println("Data Nascita:");
                String dateofbirth = getInput();
                System.out.println("Codice Fiscale:");
                String fiscalcode = getInput();
                System.out.println("Regione Sociale:");
                String businessname = getInput();
                System.out.println("P.IVA:");
                String vat = getInput();
                System.out.println("Comune:");
                String municipality = getInput();
                System.out.println("CAP:");
                String post = getInput();
                System.out.println("Provincia:");
                String city = getInput();
                System.out.println("Indirizzo:");
                String address = getInput();
                System.out.println("Telefono:");
                String telephone = getInput();
                System.out.println("Fax:");
                String fax = getInput();
                userService.insertUser(new User(username, password, firstname, lastname, dateofbirth, fiscalcode, businessname, vat, municipality, post, city, address, telephone, fax, "user"));
        }
    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void submit() {
        if (mode.equals("insert")) {
            MainDispatcher.getInstance().callView("Home", null);
        }else if (mode.equals("all")) {
            Request request = new Request();
            request.put("role", role);
            //request.put("nome", nome);
            MainDispatcher.getInstance().callAction("Login", "doControl", request);
        }
    }
}


