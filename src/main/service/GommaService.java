package main.service;

import main.dao.GommaDAO;
import main.model.Gomma;

import java.util.List;

public class GommaService {

    private GommaDAO gommaDAO;

    public GommaService() {
        this.gommaDAO = new GommaDAO();
    }

    public List<Gomma> getAllGomme () {
        return this.gommaDAO.getAllGomme();
    }

    public boolean insertGomma (Gomma gomma) {
        return this.gommaDAO.insertGomma(gomma);
    }

    public List<String> getAllManufacturerForType (String type) {
        return this.gommaDAO.getAllManufacturerForType(type);
    }

    public List<Gomma> getAllGommeForManufacturer (String brand, String type) {
        return this.gommaDAO.getAllGommeForManufacturer(brand, type);
    }

    public List<Gomma> getAllGommeForAuto () {
        return this.gommaDAO.getAllGommeForAuto();
    }

    public List<Gomma> allGommaForDimension (String type, double width, double height, double diameter, String season, double weight, String speed) {
        return this.gommaDAO.allGommaForDimension (type, width, height, diameter, season, weight, speed);
    }

    public List<Gomma> allGommaForVehicle(Integer index) {
        return this.gommaDAO.allGommaForVehicle (index);
    }

    public boolean updateQuantity (Integer newquantity, Integer codegomma) {
        return this.gommaDAO.updateQuantity(newquantity, codegomma);
    }

    public boolean removeGomma (Integer codegomma) {
        return this.gommaDAO.removeGomma(codegomma);
    }
}


