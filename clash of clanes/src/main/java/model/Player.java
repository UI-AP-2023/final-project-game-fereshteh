package model;

public class Player {
    private String id;
    private   String password;
    private   int level;
    private int success;
    private int failure;
    private int map;
    //------------------------------
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    //-------------------------------

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //-------------------------------

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    //-------------------------------

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }
    //-----------------------------------

    public int getFailure() {
        return failure;
    }

    public void setFailure(int failure) {
        this.failure = failure;
    }
    //------------------------------------

    public int getMap() {
        return map;
    }

    public void setMap(int map) {
        this.map = map;
    }
    //------------------------------------

    public Player(String id, String password, int level, int success, int failure) {
        this.id = id;
        this.password = password;
        this.level = level;
        this.success = success;
        this.failure = failure;
        this.map = map;
    }
}
