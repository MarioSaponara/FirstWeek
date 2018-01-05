package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Compatibility;
import main.model.Gomma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CompatibilityDAO {

    private final String QUERY_INSERT = "insert into compatibility (id_vehicle, id_gomme) values (?,?)";

    public CompatibilityDAO() {
    }

    public boolean insertCompatibility(Compatibility compatibility) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1, compatibility.getId_vehicle());
            preparedStatement.setInt(2, compatibility.getId_gomme());
            return preparedStatement.execute();
        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
}