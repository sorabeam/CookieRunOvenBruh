package Beam.UI.InGameUI;

import Beam.Asset;
import Beam.Image.FloorFade;
import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class InGameBG extends StackPane {

    private ImageView bg1;
    private ImageView bg2;

    private double speed = 0.5;
    private double width;

    public InGameBG(StackPane root){

        Pane bgLayer = new Pane();

        bg1 = Asset.createBackgroundView("Bglevel1",1,1);
        bg2 = Asset.createBackgroundView("Bglevel1",1,1);

        bg1.fitWidthProperty().bind(root.widthProperty());
        bg1.fitHeightProperty().bind(root.heightProperty());

        bg2.fitWidthProperty().bind(root.widthProperty());
        bg2.fitHeightProperty().bind(root.heightProperty());

        bgLayer.getChildren().addAll(bg1, bg2);

        FloorFade fade = new FloorFade(200);
        StackPane.setAlignment(fade, Pos.BOTTOM_CENTER);

        getChildren().addAll(bgLayer, fade);

        root.widthProperty().addListener((obs, oldVal, newVal) -> {
            width = newVal.doubleValue();
            recalculatePositions();
        });

        startLoop();
    }

    private void startLoop(){
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                bg1.setTranslateX(bg1.getTranslateX() - speed);
                bg2.setTranslateX(bg2.getTranslateX() - speed);

                if (bg1.getTranslateX() + width <= 0) {
                    bg1.setTranslateX(bg2.getTranslateX() + width);
                }

                if (bg2.getTranslateX() + width <= 0) {
                    bg2.setTranslateX(bg1.getTranslateX() + width);
                }
            }
        };

        timer.start();
    }

    private void recalculatePositions(){

        double x1 = bg1.getTranslateX();
        double x2 = bg2.getTranslateX();

        if (x1 == 0 && x2 == 0){
            bg1.setTranslateX(0);
            bg2.setTranslateX(width);
            return;
        }
        if (x1 <= x2) {
            bg2.setTranslateX(x1 + width);
        } else {
            bg1.setTranslateX(x2 + width);
        }
    }
}