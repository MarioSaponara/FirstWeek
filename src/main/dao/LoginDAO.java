package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO {

    private final String QUERY_LOGIN = "select * from users where username = ? and password = ?";

    public List<String> login(String username, String password) {
        List<String> data= new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                String name=resultSet.getString("firstname")+" "+resultSet.getString("lastname");
                data.add(name.toUpperCase());
                data.add(resultSet.getString("role"));
                return  data;
            }
            else
                return data;
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return null;
        }
    }
}
