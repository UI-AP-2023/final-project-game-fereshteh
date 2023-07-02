package model.strucrure;

import javafx.scene.image.ImageView;

public  class Building extends ImageView {
    private String type;
    private double health;
    private double Attack_power;
   private double x,y;
    //----------------------------
    ImageView imageView = new ImageView();
    //------------------------------

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    //----------------------------
    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }
    //----------------------------
    public double getAttack_power() {
        return Attack_power;
    }

    public void setAttack_power(double attack_power) {
        Attack_power = attack_power;
    }
    //----------------------------
    public Building(String type, int health, int attack_power,ImageView imageView,double x,double y) {
        this.type = type;
        this.health = health;
        Attack_power = attack_power;
        this.x=x;
        this.y=y;
        this.imageView=imageView;
        //set image
        //x,y
    }
    //---------------------------------------
    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
    //-----------------------
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
