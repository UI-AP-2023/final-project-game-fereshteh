package model.hero;

import javafx.scene.image.ImageView;
import model.hero.Hero;
import model.strucrure.Building;

public class Royal_Champion extends Hero {
    public Royal_Champion(double power, double speed, double health, ImageView imageView, int radiosOfAttack) {
        super(power, speed, health, imageView, radiosOfAttack);
    }

    @Override
    public boolean Target(Building hero) {
        if ((Math.abs(this.getImageView().getLayoutX() - hero.getImageView().getLayoutX() )< getRadiosOfAttack())&& (Math.abs(this.getImageView().getLayoutY() - hero.getImageView().getLayoutY())<getRadiosOfAttack()))
            return true;
        else
            return false;
    }
}
