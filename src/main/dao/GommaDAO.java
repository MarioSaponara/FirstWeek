package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Gomma;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GommaDAO {

    private final String QUERY_ALL = "select * from gomme";
    private final String QUERY_INSERT = "insert into gomme (id_gomme, model, manufacturer, price, width, height, diameter, weight, speed, season, typevehicle, quantity) values (NULL,?,?,?,?,?,?,?,?,?,?,?)";
    private final String QUERY_QUANTITY = "update gomme set quantity = ? where id_gomme=?";
    private final String QUERY_REMOVE = "delete from gomme where id_gomme=?";

    public GommaDAO() {
    }

    public List<Gomma> getAllGomme() {
        List<Gomma> gomme = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
           while (resultSet.next()) {
               Integer id_gomme=resultSet.getInt("id_gomme");
               String model = resultSet.getString("model");
               String manufacturer = resultSet.getString("manufacturer");
               double price = resultSet.getDouble("price");
               double width = resultSet.getDouble("width");
               double height = resultSet.getDouble("height");
               double diameter = resultSet.getDouble("diameter");
               double weight = resultSet.getDouble("weight");
               String speed = resultSet.getString("speed");
               String season = resultSet.getString("season");
               String typevehicle = resultSet.getString("typevehicle");
               Integer quantity = resultSet.getInt("quantity");
               gomme.add(new Gomma(id_gomme, model, manufacturer, price, width, height, diameter, weight, speed, season, typevehicle, quantity));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return gomme;
    }

    public boolean insertGomma(Gomma gomma) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setString(1, gomma.getModel());
            preparedStatement.setString(2, gomma.getManufacturer());
            preparedStatement.setDouble(3, gomma.getPrice());
            preparedStatement.setDouble(4, gomma.getWidth());
            preparedStatement.setDouble(5, gomma.getHeight());
            preparedStatement.setDouble(6, gomma.getDiameter());
            preparedStatement.setDouble(7, gomma.getWeight());
            preparedStatement.setString(8, gomma.getSpeed());
            preparedStatement.setString(9, gomma.getSeason());
            preparedStatement.setString(10, gomma.getTypevehicle());
            preparedStatement.setInt(11, gomma.getQuantity());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }

    public boolean updateQuantity(Integer newquantity, Integer codegomma) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_QUANTITY);
            preparedStatement.setInt(1, newquantity);
            preparedStatement.setInt(2, codegomma);

            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }

    public boolean removeGomma(Integer codegomma) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_REMOVE);
            preparedStatement.setInt(1, codegomma);

            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }

    public List<Gomma> getAllGommeForManufacturer(String brand, String type){
        List<Gomma> gomme = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        String query="select * from gomme where manufacturer=\""+brand+"\" and typevehicle=\""+type+"\"";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Integer id_gomme=resultSet.getInt("id_gomme");
                String model = resultSet.getString("model");
                String manufacturer = resultSet.getString("manufacturer");
                double price = resultSet.getDouble("price");
                double width = resultSet.getDouble("width");
                double height = resultSet.getDouble("height");
                double diameter = resultSet.getDouble("diameter");
                double weight = resultSet.getDouble("weight");
                String speed = resultSet.getString("speed");
                String season = resultSet.getString("season");
                String typevehicle = resultSet.getString("typevehicle");
                Integer quantity = resultSet.getInt("quantity");
                gomme.add(new Gomma(id_gomme, model, manufacturer, price, width, height, diameter, weight, speed, season, typevehicle, quantity));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return gomme;
    }

    public List<Gomma> getAllGommeForAuto(){
        List<Gomma> gomme = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        String query="select * from gomme where typevehicle=\"auto\"";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Integer id_gomme=resultSet.getInt("id_gomme");
                String model = resultSet.getString("model");
                String manufacturer = resultSet.getString("manufacturer");
                double price = resultSet.getDouble("price");
                double width = resultSet.getDouble("width");
                double height = resultSet.getDouble("height");
                double diameter = resultSet.getDouble("diameter");
                double weight = resultSet.getDouble("weight");
                String speed = resultSet.getString("speed");
                String season = resultSet.getString("season");
                String typevehicle = resultSet.getString("typevehicle");
                Integer quantity = resultSet.getInt("quantity");
                gomme.add(new Gomma(id_gomme, model, manufacturer, price, width, height, diameter, weight, speed, season, typevehicle, quantity));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return gomme;
    }


    public  List<String> getAllManufacturerForType(String type){
        List<String> manufacturers = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        String query="select distinct manufacturer from gomme where typevehicle=\""+type+"\"";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String manufacturer = resultSet.getString("manufacturer");
                manufacturers.add(manufacturer);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return manufacturers;
    }

    public List<Gomma> allGommaForDimension(String type, double width, double height, double diameter, String season, double weight, String speed) {
        List<Gomma> gomme = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {

            if (type.equals("auto")){
                String query = "select * from gomme where width = ? and height= ? and diameter= ? and season= ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setDouble(1, width);
                preparedStatement.setDouble(2, height);
                preparedStatement.setDouble(3, diameter);
                preparedStatement.setString(4, season);

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Integer id_gommes=resultSet.getInt("id_gomme");
                    String models = resultSet.getString("model");
                    String manufacturers = resultSet.getString("manufacturer");
                    double prices = resultSet.getDouble("price");
                    double widths = resultSet.getDouble("width");
                    double heights = resultSet.getDouble("height");
                    double diameters = resultSet.getDouble("diameter");
                    double weights = resultSet.getDouble("weight");
                    String speeds = resultSet.getString("speed");
                    String seasons = resultSet.getString("season");
                    String typevehicles = resultSet.getString("typevehicle");
                    Integer quantitys = resultSet.getInt("quantity");
                    gomme.add(new Gomma(id_gommes, models, manufacturers, prices, widths, heights, diameters, weights, speeds, seasons, typevehicles, quantitys));
                }
            }else{
                String query = "select * from gomme where width = ? and height= ? and diameter= ? and season= ? and weight= ? and speed= ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setDouble(1, width);
                preparedStatement.setDouble(2, height);
                preparedStatement.setDouble(3, diameter);
                preparedStatement.setString(4, season);
                preparedStatement.setDouble(5, weight);
                preparedStatement.setString(6, speed);

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Integer id_gommes=resultSet.getInt("id_gomme");
                    String models = resultSet.getString("model");
                    String manufacturers = resultSet.getString("manufacturer");
                    double prices = resultSet.getDouble("price");
                    double widths = resultSet.getDouble("width");
                    double heights = resultSet.getDouble("height");
                    double diameters = resultSet.getDouble("diameter");
                    double weights = resultSet.getDouble("weight");
                    String speeds = resultSet.getString("speed");
                    String seasons = resultSet.getString("season");
                    String typevehicles = resultSet.getString("typevehicle");
                    Integer quantitys = resultSet.getInt("quantity");
                    gomme.add(new Gomma(id_gommes, models, manufacturers, prices, widths, heights, diameters, weights, speeds, seasons, typevehicles, quantitys));
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return gomme;
    }

    public List<Gomma> allGommaForVehicle(Integer index) {
        List<Gomma> gomme = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {

            String query = "select * from tire.gomme inner join tire.compatibility on compatibility.id_gomme=gomme.id_gomme and compatibility.id_vehicle=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, index);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id_gommes=resultSet.getInt("id_gomme");
                String models = resultSet.getString("model");
                String manufacturers = resultSet.getString("manufacturer");
                double prices = resultSet.getDouble("price");
                double widths = resultSet.getDouble("width");
                double heights = resultSet.getDouble("height");
                double diameters = resultSet.getDouble("diameter");
                double weights = resultSet.getDouble("weight");
                String speeds = resultSet.getString("speed");
                String seasons = resultSet.getString("season");
                String typevehicles = resultSet.getString("typevehicle");
                Integer quantitys = resultSet.getInt("quantity");
                gomme.add(new Gomma(id_gommes, models, manufacturers, prices, widths, heights, diameters, weights, speeds, seasons, typevehicles, quantitys));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return gomme;
    }

}
