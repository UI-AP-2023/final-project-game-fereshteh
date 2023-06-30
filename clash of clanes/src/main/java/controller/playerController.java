package controller;

import com.example.clashofclanes.ProfileController;
import detaBase.PlayersConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class playerController {
    public String attackToPlayer() {
        int result;
        ArrayList usernames = PlayersConnection.getInstance().attack(ProfileController.getIndexOfAttack());
        int min = 0;
        int max = usernames.size()-1;
        Random rand = new Random();
        result = rand.nextInt((max - min) + 1) + min;
        return (String) usernames.get(result);
    }
}
