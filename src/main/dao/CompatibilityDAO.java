package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Compatibility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompatibilityDAO {

    private final String QUERY_ALL = "select * from compatibility";
    private final String QUERY_INSERT = "insert into compatibility (id_vehicle, id_gomme) values (?,?)";
    private final String QUERY_REMOVE = "delete from compatibility where id_vehicle=? or id_gomme=?;";

    public CompatibilityDAO() {
    }

    public List<Compatibility> getAllCompatibility() {
        List<Compatibility> compatibility = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_ALL);
            while (resultSet.next()) {
                Integer id_vehicle=resultSet.getInt("id_vehicle");
                Integer id_gomme=resultSet.getInt("id_gomme");
                compatibility.add(new Compatibility(id_vehicle, id_gomme));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return compatibility;
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

    public boolean removeCompatibility(Integer codevehicle, Integer codegomma) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_REMOVE);
            preparedStatement.setInt(1, codevehicle);
            preparedStatement.setInt(2, codegomma);
            return preparedStatement.execute();
        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
}