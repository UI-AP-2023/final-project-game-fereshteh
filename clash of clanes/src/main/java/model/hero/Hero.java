package model.hero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import model.strucrure.Building;

public abstract class Hero extends ImageView
{
    private double power;
    String name;
    private double speed;
    private double health;
    private  ImageView imageView;
    private int radiosOfAttack;
    private ImageView shotHer0Img;
    private double XOfHero;
    private double YOfHero;

    ///////////////////////////////


    public Hero(double power, double speed, double health,ImageView imageView,int radiosOfAttack) {
        this.power = power;
        this.speed = speed;
        this.health = health;
        this.imageView=imageView;
        this.radiosOfAttack=radiosOfAttack;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public  ImageView getImageView() {
        return imageView;
    }

    public  void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public ImageView getShotHer0Img() {
        return shotHer0Img;
    }

    public void setShotHer0Img(ImageView shotHer0Img) {
        this.shotHer0Img = shotHer0Img;
    }
    //---------------------------


    public int getRadiosOfAttack() {
        return radiosOfAttack;
    }

    public void setRadiosOfAttack(int radiosOfAttack) {
        this.radiosOfAttack = radiosOfAttack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //------------------------------
    public abstract boolean Target(Building building);
    public abstract Hero newHero();
    //-------------------------------
    public  void drag(Node node) {
      }
    //-------------------------------

}
