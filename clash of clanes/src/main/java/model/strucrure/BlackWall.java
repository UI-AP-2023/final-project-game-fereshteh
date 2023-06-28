package model.strucrure;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class BlackWall extends Building  {
    @FXML
    private ImageView blackWall2_img;

    public BlackWall(String type,int health,int power,ImageView imageView,double x,double y) {
        super(type,health,power,imageView,x,y);
        //super.imageView=imageView;
        //super.imageView=new ImageView("C:\\Users\\NA\\git Hub Game\\final-project-game-fereshteh\\clash of clanes\\src\\main\\resources\\com\\example\\clashofclanes\\wall_82.png");
    }

}
