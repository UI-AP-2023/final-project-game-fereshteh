package model.hero;

import javafx.scene.image.ImageView;
import model.strucrure.Building;

public class Archer_Queen extends Hero {
    public Archer_Queen(double power, double speed, double health, ImageView imageView,int radios) {
        super(power, speed, health, imageView,radios);
        super.setName("archer");
    }

    @Override
    public boolean Target(Building hero) {
        if ((Math.abs(this.getImageView().getLayoutX() - hero.getImageView().getLayoutX() )<getRadiosOfAttack())&& (Math.abs(this.getImageView().getLayoutY() - hero.getImageView().getLayoutY())<getRadiosOfAttack()))
            return true;
        else
            return false;
    }
    //-------------------------------------------
    @Override
    public Hero newHero() {
        return new Archer_Queen(this.getPower(),this.getSpeed(),this.getHealth(),this.getImageView(),this.getRadiosOfAttack());

    }
}
