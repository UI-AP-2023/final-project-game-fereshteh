package detaBase;

import com.example.clashofclanes.ProfileController;
import javafx.scene.input.MouseEvent;

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
    public ArrayList<String> showUserName() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/game-db", "server", "1234");

            String SQLCom = "SELECT `username` FROM `players`";
            Statement s = connection.prepareStatement(SQLCom);
            ResultSet resultSet = s.executeQuery(SQLCom);
            ArrayList<String> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(resultSet.getString("username"));
            }
            connection.close();
            return users;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //-----------------------------------------------------
    public String getPassword(String username) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/game-db", "server", "1234");

            String SQLCom = String.format("SELECT `password` FROM `players` WHERE (username ='%s')", username);
            Statement s = connection.prepareStatement(SQLCom);
            ResultSet resultSet = s.executeQuery(SQLCom);
            String password = "";
            while (resultSet.next()) {
                password = resultSet.getString("password");
            }

            connection.close();

            return password;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //-------------------------------------------------------

    public int getFailure(String username) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/game-db", "server", "1234");

            String SQLCom = String.format("SELECT `failure` FROM `players` WHERE (username ='%s')", username);
            Statement s = connection.prepareStatement(SQLCom);
            ResultSet resultSet = s.executeQuery(SQLCom);
            int password = 0;
            while (resultSet.next()) {
                password = Integer.parseInt(resultSet.getString("failure"));
            }

            connection.close();

            return password;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int getSucsses(String username) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/game-db", "server", "1234");

            String SQLCom = String.format("SELECT `success` FROM `players` WHERE (username ='%s')", username);
            Statement s = connection.prepareStatement(SQLCom);
            ResultSet resultSet = s.executeQuery(SQLCom);
            int password = 0;
            while (resultSet.next()) {
                password = Integer.parseInt(resultSet.getString("success"));
            }

            connection.close();

            return password;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //-----------------------------------------------------------------
    public void savePlayer(String username, String password, int map, int level) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/game-db", "server", "1234");

            String SQLCom = String.format("INSERT INTO `players`(`username`, `password`,`level`,`success`,`failure`,`map`) VALUES ('%s','%s','%d','%d','%d','%d')", username, password, level, 0, 0, map);
            Statement s = connection.prepareStatement(SQLCom);
            s.execute(SQLCom);
            System.out.println(showUserName().size());
            for (int i = 0; i < showUserName().size(); i++) {
                System.out.println(showUserName().get(i));
            }
            //------------------------
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //---------------------------------------------------------------------
    public ArrayList attack(int index) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/game-db", "server", "1234");

            String SQLCom = String.format("SELECT `username` FROM `players` WHERE (map ='%d')", index);
            Statement s = connection.prepareStatement(SQLCom);
            ResultSet resultSet = s.executeQuery(SQLCom);
            ArrayList<String> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(resultSet.getString("username"));
            }
            connection.close();
            return users;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateFailure(String username,int failure) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/game-db", "server", "1234");

            String SQLCom = String.format("UPDATE players SET failure=%d WHERE username ='%s'", failure,username);
            Statement s = connection.prepareStatement(SQLCom);
            s.execute(SQLCom);

            connection.close();
            ProfileController.result_lbl.setText("you fail");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //-------------------------------------------------------------
    public void updateSuccess(String username,int success) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/game-db", "server", "1234");

            String SQLCom = String.format("UPDATE players SET success=%d WHERE username ='%s'", success,username);
            Statement s = connection.prepareStatement(SQLCom);
           s.execute(SQLCom);
           // ArrayList<String> users = new ArrayList<>();

            connection.close();
            ProfileController.setTextWin(" you win");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
    //------------------------------

