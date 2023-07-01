package model.hero;

import javafx.scene.image.ImageView;
import model.strucrure.Building;

public class Wizard extends Hero {
    public Wizard(double power, double speed, double health, ImageView imageView, int radiosOfAttack) {
        super(power, speed, health, imageView, radiosOfAttack);
        super.setName("wizard");
    }

    @Override
    public boolean Target(Building hero) {
        if ((Math.abs(this.getImageView().getLayoutX() - hero.getImageView().getLayoutX() )< getRadiosOfAttack())&& (Math.abs(this.getImageView().getLayoutY() - hero.getImageView().getLayoutY())<getRadiosOfAttack()))
            return true;
        else
            return false;
    }
    public Wizard newHero(){
        return new Wizard(super.getPower(),super.getSpeed(),super.getHealth(),super.getImageView(),super.getRadiosOfAttack());
    }

}
