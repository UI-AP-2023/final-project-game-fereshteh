package controller;

import com.example.clashofclanes.ProfileController;
import detaBase.PlayersConnection;
import exception.InvalidPassword;
import exception.InvalidUsername;

import java.util.ArrayList;

public class LoginC {
    //-----------------------------------
    private static LoginC instance;
    private LoginC() {

    }

    public static LoginC getInstance() {
        if (instance == null) {
            instance = new LoginC() {

            };
        }
        return instance;
    }
    //---------------------------------------------
    public boolean check(String username,String password){
        ArrayList<String> allUserNames= PlayersConnection.getInstance().showUserName();
        for (int i=0;i<allUserNames.size();i++){
            if(username.equals(allUserNames.get(i))){
                if(PlayersConnection.getInstance().getPassword(username).equals(password)){
                    ProfileController.setUsername(username);
                    ProfileController.setPassword(password);

                    return true;
            }}
        }
   return false; }
    //------------------------------------------
    public static void insert(String username,String password,int index,int level){
    PlayersConnection.getInstance().savePlayer(username,password,index,level);
    }
    public static void checkPassword(String password,String username) throws InvalidPassword {
        String pass=PlayersConnection.getInstance().getPassword(username);
        if(pass!=password){
            throw new InvalidPassword("uncorrect password");
        }
    }
    //--------------------------
    public  static void checkUsername(String username)throws InvalidUsername{
        ArrayList<String>usernames=PlayersConnection.getInstance().showUserName();
        for(int i=0;i<usernames.size();i++){
            if(usernames.get(i).equals(username)){
                throw new InvalidUsername("it is  available");
            }
        }
    }
    //---------------------------------
}
