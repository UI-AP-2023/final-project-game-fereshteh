package model.hero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import model.strucrure.Building;

public class Grand_Warden extends Hero {
    public Grand_Warden(double power, double speed, double health, ImageView imageView, int radiosOfAttack) {
        super(power, speed, health, imageView, radiosOfAttack);
        super.setName("grand");
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
        return new Grand_Warden(this.getPower(),this.getSpeed(),this.getHealth(),this.getImageView(),this.getRadiosOfAttack());

    }
    //-------------------------------

}
