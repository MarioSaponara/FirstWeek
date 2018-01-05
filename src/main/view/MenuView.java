package main.view;

import main.MainDispatcher;
import main.controller.Request;

import java.util.Scanner;

public class MenuView implements View {
    private int choice;
    private String role;
    private String nome;


    public void showResults(Request request) {
        if (request!=null) {
            role = (String) request.get("role");
            nome = (String) request.get("nome");
        }
    }

    public void showOptions() {
        System.out.println("");
        switch(role)
        {
            case "admin":
                System.out.println("");
                System.out.println("-------MENU ADMIN-------");
                System.out.println("");
                System.out.println("1) Inserisci nuova gomma");
                System.out.println("2) Visualizza tutte le gomme");
                System.out.println("3) Visualizza tutti gli utenti");
                System.out.println("4) Inserisci nuovo veicolo");
                System.out.println("5) Visualizza tutti i veicoli");
                System.out.println("6) Inserisci compatibilità");
                System.out.println("7) Logout");
                break;
            case "user":
                System.out.println(nome+" Benvenuto in ContraderFramework");
                System.out.println("");
                System.out.println("----------MENU-----------");
                System.out.println("");
                System.out.println("1) Visualizza tutte le gomme");
                System.out.println("2) Visualizza gomme per brand");
                System.out.println("3) Visualizza gomme per dimensione");
                System.out.println("4) Visualizza gomme per tipo di auto");
                System.out.println("5) Logout");
        }

        boolean flag;
        do {
            flag=false;
            try{
                this.choice = Integer.parseInt(getInput());
            }
            catch (NumberFormatException e){
                flag=true;
                Request request = new Request();
                request.put("role", role);
                request.put("nome", nome);
                MainDispatcher.getInstance().callAction("Login", "doControl", request);
            }
        }while(flag);
    }

    public void submit() {
        switch(role)
        {
            case "admin":
                if (choice < 1 || choice > 7) {
                    Request request = new Request();
                    request.put("role", role);
                    request.put("nome", nome);
                    MainDispatcher.getInstance().callAction("Login", "doControl", request);
                }
                else if (choice == 3){
                    Request request = new Request();
                    request.put("choice", choice);
                    request.put("role", role);
                    request.put("nome", nome);
                    MainDispatcher.getInstance().callAction("User", "doControl", request);
                }
                else if ((choice == 4) || (choice == 5)){
                    Request request = new Request();
                    request.put("choice", choice);
                    request.put("role", role);
                    request.put("nome", nome);
                    MainDispatcher.getInstance().callAction("Vehicle", "doControl", request);
                }
                else if (choice == 6){
                    Request request = new Request();
                    request.put("choice", choice);
                    request.put("role", role);
                    request.put("nome", nome);
                    MainDispatcher.getInstance().callAction("Compatibility", "doControl", request);
                }
                else if (choice == 7)
                    MainDispatcher.getInstance().callAction("Home", "doControl", null);
                else{
                    Request request = new Request();
                    request.put("choice", choice);
                    request.put("role", role);
                    request.put("nome", nome);
                    MainDispatcher.getInstance().callAction("Gomma", "doControl", request);
                }
                break;

            case "user":
                if (choice < 1 || choice > 5) {
                    Request request = new Request();
                    request.put("role", role);
                    request.put("nome", nome);
                    MainDispatcher.getInstance().callAction("Login", "doControl", request);
                }
                else if (choice == 5)
                    MainDispatcher.getInstance().callAction("Home", "doControl", null);
                else {
                    Request request = new Request();
                    request.put("choice", choice);
                    request.put("role", role);
                    request.put("nome", nome);
                    MainDispatcher.getInstance().callAction("Gomma", "doControl", request);
                }
        }
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}