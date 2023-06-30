package model.hero;

import javafx.scene.image.ImageView;

public class Archer_Queen extends Hero {
    public Archer_Queen(double power, double speed, double health, ImageView imageView,int radios) {
        super(power, speed, health, imageView,radios);
    }

    @Override
    public boolean Target(Hero hero) {
        if ((Math.abs(this.getImageView().getLayoutX() - hero.getImageView().getLayoutX() )<getRadiosOfAttack())&& (Math.abs(this.getImageView().getLayoutY() - hero.getImageView().getLayoutY())<getRadiosOfAttack()))
            return true;
        else
            return false;
    }
    //-------------------------------------------

}
