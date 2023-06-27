package model.strucrure;

import javafx.scene.image.ImageView;

public class BlueWall extends Building {
    public BlueWall(String type,int health,int power) {
        super(type,health,power);
        super.imageView=new ImageView("C:\\Users\\NA\\git Hub Game\\final-project-game-fereshteh\\clash of clanes\\src\\main\\resources\\com\\example\\clashofclanes\\giga_tesla_4.png");

    }
}
