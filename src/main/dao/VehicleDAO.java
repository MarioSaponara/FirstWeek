package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {
    private final String QUERY_ALL = "select * from vehicle";
    private final String QUERY_INSERT = "insert into vehicle (id_vehicle, brand, model, fuel, version, capacity) values (NULL,?,?,?,?,?)";
    private final String QUERY_WITH_PARAMETERS = "select id_vehicle from vehicle where brand=? and model=? and fuel=? and version=? and capacity=?";
    private final String QUERY_REMOVE = "delete from vehicle where id_vehicle=?";

    public VehicleDAO() {

    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_ALL);
            while (resultSet.next()) {
                Integer id_vehicle=resultSet.getInt("id_vehicle");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                String fuel = resultSet.getString("fuel");
                String version = resultSet.getString("version");
                String capacity = resultSet.getString("capacity");
                vehicles.add(new Vehicle(id_vehicle, brand, model, fuel, version, capacity));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    public boolean insertVehicle(Vehicle vehicle) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setString(1, vehicle.getBrand());
            preparedStatement.setString(2, vehicle.getModel());
            preparedStatement.setString(3, vehicle.getFuel());
            preparedStatement.setString(4, vehicle.getVersion());
            preparedStatement.setString(5, vehicle.getCapacity());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }

    public Integer getVehicle(String brand, String model, String fuel, String version, String capacity) {
        Integer id_vehicleR=null;
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_WITH_PARAMETERS);
            preparedStatement.setString(1, brand);
            preparedStatement.setString(2, model);
            preparedStatement.setString(3, fuel);
            preparedStatement.setString(4, version);
            preparedStatement.setString(5, capacity);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id_vehicleR=resultSet.getInt("id_vehicle");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return id_vehicleR;
    }

    public boolean removeVehicle(Integer codevehicle) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_REMOVE);
            preparedStatement.setInt(1, codevehicle);
            return preparedStatement.execute();
        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }
}
