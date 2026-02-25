package SceneRoots;

import Filmmy.BobaMilkTeaCookie;
import supakorn.Animation.Animate;
import Filmmy.Player;
import Components.ScoreBoard;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import supakorn.Animation.AnimationType;
import supakorn.Asset;

import java.util.Objects;

public class InGameRoot extends StackPane {
    //physics setting
    private final double groundH = 80;

    public InGameRoot() {
//        StackPane root = new StackPane();
        Pane gameLayer = new Pane();
        AnchorPane uiLayer = new AnchorPane();
        ScoreBoard scoreBoard = new ScoreBoard();
        this.setPrefSize(800, 600);
        AnchorPane.setTopAnchor(scoreBoard, 10.0);
        AnchorPane.setRightAnchor(scoreBoard, 20.0);
        uiLayer.getChildren().add(scoreBoard);
        this.getChildren().addAll(gameLayer, uiLayer);
        Image backgroundImg = new Image(Objects.requireNonNull(getClass().getResource("/Maps/ParadiseBG.png")).toExternalForm());
        BackgroundSize size = new BackgroundSize(
                100, 100,
                true, true,
                false, true
        );
        BackgroundImage backgroundImage = new BackgroundImage(
                backgroundImg,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                size
        );
        this.setBackground(new Background(backgroundImage));

        //ground
        Rectangle ground = new Rectangle();
        ground.setHeight(groundH);
        ground.setLayoutX(0);
        ground.widthProperty().bind(gameLayer.widthProperty());
        ground.layoutYProperty().bind(gameLayer.heightProperty().subtract(groundH));
        ground.setFill(Color.LIGHTGRAY);
        gameLayer.getChildren().add(ground);

        Player player = new BobaMilkTeaCookie();
        gameLayer.getChildren().add(player);
        player.setFitWidth(200);
        player.setFitHeight(200);
        player.setLayoutX(200);

        AnimationTimer timer = new AnimationTimer() {

            long last = 0;

            @Override
            public void handle(long now) {

                if (last == 0) {
                    last = now;
                    return;
                }

                double dt = (now - last) / 1e9;
                last = now;

                double groundY = getHeight() - groundH;

                player.update(dt, groundY);          // physics + movement
                player.update(dt);         // animation frames
            }
        };

        timer.start();

        setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case SPACE -> player.jump();
                case SHIFT -> player.slide(true);
            }
        });

        setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.SHIFT) {
                player.slide(false);
            }
        });


        setFocusTraversable(true);
        Platform.runLater(this::requestFocus);

    }
}
