package controller;

import detaBase.PlayersConnection;

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
                if(PlayersConnection.getInstance().getPassword(username).equals(password))
                    return true;
            }
        }
   return false; }
    //------------------------------------------
    public void insert(String username,String password,)
}
