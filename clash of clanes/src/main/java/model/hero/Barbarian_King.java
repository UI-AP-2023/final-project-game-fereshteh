package model.hero;

import javafx.scene.image.ImageView;

public class Barbarian_King extends Hero {
    public Barbarian_King(double power, double speed, double health, ImageView imageView, int radiosOfAttack) {
        super(power, speed, health, imageView, radiosOfAttack);
    }

    @Override
    public boolean Target(Hero hero) {
        if ((Math.abs(this.getImageView().getLayoutX() - hero.getImageView().getLayoutX() )< getRadiosOfAttack())&& (Math.abs(this.getImageView().getLayoutY() - hero.getImageView().getLayoutY())<getRadiosOfAttack()))
            return true;
        else
            return false;
    }
}
