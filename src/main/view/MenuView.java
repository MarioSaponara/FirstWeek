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
        switch(role)
        {
            case "admin":
                System.out.println("");
                System.out.println("---------MENU ADMIN---------");
                System.out.println("1) Inserisci nuova gomma");
                System.out.println("2) Visualizza tutte le gomme");
                System.out.println("3) Aggiorna quantità gomma");
                System.out.println("4) Rimuovi gomma");
                System.out.println("5) Visualizza tutti gli utenti");
                System.out.println("6) Elimina utente");
                System.out.println("7) Inserisci nuovo veicolo");
                System.out.println("8) Visualizza tutti i veicoli");
                System.out.println("9) Rimuovi veicolo");
                System.out.println("10) Inserisci compatibilità");
                System.out.println("11) Logout");
                System.out.println("Scelta:");
                break;
            case "user":
                System.out.println(nome+" Benvenuto in ContraderFramework");
                System.out.println("");
                System.out.println("----------------MENU----------------");
                System.out.println("1) Visualizza tutte le gomme");
                System.out.println("2) Visualizza gomme per brand");
                System.out.println("3) Visualizza gomme per dimensione");
                System.out.println("4) Visualizza gomme per tipo di auto");
                System.out.println("5) Logout");
                System.out.println("Scelta:");
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
                switch(choice)
                {
                    case 1:
                    case 2:
                    case 3:
                    case 4:{
                        Request request = new Request();
                        request.put("choice", choice);
                        request.put("role", role);
                        request.put("nome", nome);
                        MainDispatcher.getInstance().callAction("Gomma", "doControl", request);
                    }
                        break;
                    case 5:
                    case 6:{
                        Request request = new Request();
                        request.put("choice", choice);
                        request.put("role", role);
                        request.put("nome", nome);
                        MainDispatcher.getInstance().callAction("User", "doControl", request);
                    }
                        break;
                    case 7:
                    case 8:
                    case 9:{
                        Request request = new Request();
                        request.put("choice", choice);
                        request.put("role", role);
                        request.put("nome", nome);
                        MainDispatcher.getInstance().callAction("Vehicle", "doControl", request);
                    }
                        break;
                    case 10: {
                        Request request = new Request();
                        request.put("choice", choice);
                        request.put("role", role);
                        request.put("nome", nome);
                        MainDispatcher.getInstance().callAction("Compatibility", "doControl", request);
                    }
                        break;
                    case 11:{
                        MainDispatcher.getInstance().callAction("Home", "doControl", null);
                    }
                        break;
                    default:{
                        Request request = new Request();
                        request.put("role", role);
                        request.put("nome", nome);
                        MainDispatcher.getInstance().callAction("Login", "doControl", request);
                    }
                }
                break;

            case "user":
                switch(choice)
                {
                    case 1:
                    case 2:
                    case 3:
                    case 4: {
                        Request request = new Request();
                        request.put("choice", choice);
                        request.put("role", role);
                        request.put("nome", nome);
                        MainDispatcher.getInstance().callAction("Gomma", "doControl", request);
                    }
                    break;
                    case 5:{
                        MainDispatcher.getInstance().callAction("Home", "doControl", null);
                    }
                    break;
                    default:{
                        Request request = new Request();
                        request.put("role", role);
                        request.put("nome", nome);
                        MainDispatcher.getInstance().callAction("Login", "doControl", request);
                    }
                }
                break;
        }
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}