package Beam.Scene;

import Got.GameLogic.GameLogic;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;

public abstract class BaseRoot extends StackPane{

    protected Scene scene;
    protected StackPane root = this;

    public BaseRoot() {

        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();

        double screenWidth = bounds.getWidth();
        double screenHeight = bounds.getHeight();

        setMaxSize(screenWidth, screenHeight);
        scene = GameLogic.getCurScene();
        Rectangle clip = new Rectangle(screenWidth, screenHeight);
        clip.setArcWidth(0);
        clip.setArcHeight(0);

        setBackground(new Background(new BackgroundFill(Color.GREEN,null,null)));

        setClip(clip);
    }

    public Region spacer(char c){
        Region space = new Region();
        if(c == 'V'){
            VBox.setVgrow(space, Priority.ALWAYS);
        } else if (c == 'H') {
            HBox.setHgrow(space, Priority.ALWAYS);
        }
        return space;
    }
}