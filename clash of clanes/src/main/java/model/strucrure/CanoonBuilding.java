package model.strucrure;

import javafx.scene.image.ImageView;

public class CanoonBuilding extends Building{
    public CanoonBuilding(String type, int health, int attack_power) {
        super(type, health, attack_power);
        super.imageView=new ImageView("C:\\Users\\NA\\git Hub Game\\final-project-game-fereshteh\\clash of clanes\\src\\main\\resources\\com\\example\\clashofclanes\\cannon1.png");

    }
}
