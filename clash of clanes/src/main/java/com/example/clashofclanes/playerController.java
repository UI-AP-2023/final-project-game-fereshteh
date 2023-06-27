package com.example.clashofclanes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class playerController {
    public void savePlayer(String id, String password,int map) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/game-db","server","1234");

        String SQLCom  =String.format("INSERT INTO `players`(`userID`, `username`,'level','success','failure','map') VALUES ('%s','%s','%d','%d','%d','%d')",password,id,1,0,0,map);
        Statement s = connection.prepareStatement(SQLCom);
        s.execute(SQLCom);
    }
}
