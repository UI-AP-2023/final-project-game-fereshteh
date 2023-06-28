package detaBase;

import java.sql.*;
import java.util.ArrayList;

public class PlayersConnection {
    //-----------------------------------------

    private static PlayersConnection instance;
    private PlayersConnection() {

    }

    public static PlayersConnection getInstance() {
        if (instance == null) {
            instance = new PlayersConnection() {

            };
        }
        return instance;
    }
    //----------------------------------------------
    public ArrayList<String> showUserName(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/game-db","server","1234");

            String SQLCom  ="SELECT `username` FROM `players`";
            Statement s = connection.prepareStatement(SQLCom);
            ResultSet resultSet =  s.executeQuery(SQLCom);
            ArrayList<String> users = new ArrayList<>();
            while (resultSet.next()){
                users.add(resultSet.getString("username"));
            }
            connection.close();
            return users;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //-----------------------------------------------------
    public String getPassword(String username){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/game-db","server","1234");

            String SQLCom  =String.format("SELECT `password` FROM `players` WHERE (username ='%s')",username);
            Statement s = connection.prepareStatement(SQLCom);
            ResultSet resultSet =  s.executeQuery(SQLCom);
            String password="";
            while (resultSet.next()){
                password = resultSet.getString("password");
            }

            connection.close();

            return password;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
