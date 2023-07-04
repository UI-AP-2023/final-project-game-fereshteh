package model.strucrure;

import javafx.scene.image.ImageView;

public class CanoonBuilding extends Building{
    private ImageView shot;

    public ImageView getShot() {
        return shot;
    }

    public void setShot(ImageView shot) {
        this.shot = shot;
    }

    public CanoonBuilding(String type, int health, int attack_power, ImageView imageView, double x, double y) {
        super(type, health, attack_power,imageView,x,y);
       // super.imageView=imageView;
//        super.imageView=new ImageView("C:\\Users\\NA\\git Hub Game\\final-project-game-fereshteh\\clash of clanes\\src\\main\\resources\\com\\example\\clashofclanes\\cannon1.png");
    }
}
