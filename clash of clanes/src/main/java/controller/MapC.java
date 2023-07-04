package controller;

import com.example.clashofclanes.Map1;
import detaBase.PlayersConnection;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import model.Player;
import model.hero.Hero;
import model.strucrure.Building;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class MapC {
    private ArrayList<Building> buildings;
    private ArrayList<Hero> heroes;
    private static ArrayList<Player> players = new ArrayList<>();

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(ArrayList<Building> buildings) {
        this.buildings = buildings;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    public static void addPlayer(Player player) {
        players.add(player);
    }

    //------------------------------
    //------------------------------


    int i = 0;

    //--------------------------------------
    void initTimer()  {
        ThreadController thread;
        for (i = 0; i < heroes.size(); i++) {
            thread = new ThreadController();


            thread.setBuildings(buildings);
            thread.setHero(heroes.get(i));
            thread.attckbuilding = attckbuilding;

            // thread.username = heroes.get(i).getName();
//            System.out.println(" thread username ");
//            System.out.println(thread.username);

               thread.start();
        }

    }

    //--------------------------------------


    public void GamePageController()  {
       try {
           initTimer();
       }catch (InterruptedException e){
           e.printStackTrace();
       }

    }

    //-------------------


    //--------------------------
    public Building attckbuilding;

    public static void attackConnection(int index, boolean win) {
        Random rand = new Random();
        int min = 0;
        int max = PlayersConnection.getInstance().attack(index).size();
        int result = rand.nextInt((max - min) + 1) + min;
        String username = (String) PlayersConnection.getInstance().attack(index).get(result);
        String password = (String) PlayersConnection.getInstance().getPassword(username);
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getId().equals(username) && players.get(i).getPassword().equals(password)) {

                if (players.get(i).getSuccess() + players.get(i).getFailure() > 1) {

                    if (win) {
                        players.get(i).setSuccess(players.get(i).getSuccess() + 1);
                        if (players.get(i).getSuccess() - players.get(i).getFailure() >= 3) {
                            players.get(i).setLevel(players.get(i).getLevel() + 1);
                        }

                    } else {
                        players.get(i).setFailure(players.get(i).getFailure() + 1);
                    }

                } else {
                    players.get(i).setMap(0);
                    players.get(i).setLevel(1);
                }
            }
        }
    }

    static int random = 0;

    public static void choosePerson(int indexOfAttack, boolean win) {
        boolean check = true;
        Player player = null;
        ArrayList usernames = PlayersConnection.getInstance().attack(indexOfAttack);
        System.out.println("attack arretlist : " + usernames.size());
        Random rand = new Random();
        int result = rand.nextInt(((usernames.size() - 1)) + 1);
        while (check) {
            if (result < usernames.size() && result >= 0) {
                check = false;
            } else {
                result = rand.nextInt(((usernames.size() - 1)) + 1);
            }
        }
      int success=  PlayersConnection.getInstance().getSucsses((String) usernames.get(result));
        int fail=PlayersConnection.getInstance().getFailure((String) usernames.get(result));

        if (win) {
            PlayersConnection.getInstance().updateSuccess((String) usernames.get(result),success+1 );
        } else {
            PlayersConnection.getInstance().updateFailure((String) usernames.get(result), fail +1);
        }
    }
}







