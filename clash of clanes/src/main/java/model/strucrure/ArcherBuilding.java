package model.strucrure;

import javafx.scene.image.ImageView;

public class ArcherBuilding extends Building{
    private ImageView shot;

    public ImageView getShot() {
        return shot;
    }

    public void setShot(ImageView shot) {
        this.shot = shot;
    }

    public ArcherBuilding(String type, int health, int attack_power, ImageView imageView, double x, double y) {
        super(type, health, attack_power,imageView,x,y);
        //super.imageView=imageView;
    }
}
