package model.hero;

import javafx.scene.image.ImageView;
import model.strucrure.Building;

public class Barbarian_King extends Hero {
    public Barbarian_King(double power, double speed, double health, ImageView imageView, int radiosOfAttack) {
        super(power, speed, health, imageView, radiosOfAttack);
        super.setName("barbarian");
    }

    @Override
    public boolean Target(Building hero) {
        if ((Math.abs(this.getImageView().getLayoutX() - hero.getImageView().getLayoutX() )< getRadiosOfAttack())&& (Math.abs(this.getImageView().getLayoutY() - hero.getImageView().getLayoutY())<getRadiosOfAttack()))
            return true;
        else
            return false;
    }
    @Override
    public Hero newHero() {
        return new Barbarian_King(this.getPower(),this.getSpeed(),this.getHealth(),this.getImageView(),this.getRadiosOfAttack());

    }
}
