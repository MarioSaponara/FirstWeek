package main.service;

import main.dao.CompatibilityDAO;
import main.model.Compatibility;

import java.util.List;

public class CompatibilityService {

    private CompatibilityDAO compatibilityDAO;

    public CompatibilityService() {
        this.compatibilityDAO = new CompatibilityDAO();
    }

    public List<Compatibility> getAllCompatibility () {
        return this.compatibilityDAO.getAllCompatibility();
    }

    public boolean insertCompatibility (Compatibility compatibility) {
        return this.compatibilityDAO.insertCompatibility(compatibility);
    }

    public boolean removeCompatibility (Integer codevehicle, Integer codegomma) {
        return this.compatibilityDAO.removeCompatibility(codevehicle, codegomma);
    }
}
