package GameScenes;

import GUI_beam.Animate;
import components.ScoreBoard;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Objects;
import java.util.Set;

public class InGameScene {
    private Scene scene;

    //physics setting
    private final double groundH = 80;
    private final double gravity = 0.4;
    private final double jumpSpeed = -15;
    private double velocity;
    private boolean onGround;

    public void handlePlayerJump() {
        if(!onGround) return;
        velocity = jumpSpeed;
        onGround = false;
    }

    public InGameScene() {
        StackPane root = new StackPane();
        AnchorPane gameLayer = new AnchorPane();
        AnchorPane uiLayer = new AnchorPane();
        ScoreBoard scoreBoard = new ScoreBoard();
        root.setPrefSize(800, 600);
        AnchorPane.setTopAnchor(scoreBoard, 10.0);
        AnchorPane.setRightAnchor(scoreBoard, 20.0);
        uiLayer.getChildren().add(scoreBoard);
        root.getChildren().addAll(gameLayer, uiLayer);
        this.scene = new Scene(root);
        Image backgroundImg = new Image(Objects.requireNonNull(getClass().getResource("/Maps/stage_background2.png")).toExternalForm());
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
        root.setBackground(new Background(backgroundImage));

        //ground
        Rectangle ground = new Rectangle();
        ground.setHeight(groundH);
        ground.setLayoutX(0);
        ground.widthProperty().bind(root.widthProperty());
        ground.layoutYProperty().bind(root.heightProperty().subtract(groundH));
        ground.setFill(Color.LIGHTGRAY);
        gameLayer.getChildren().add(ground);

        Animate player = new Animate(new Image("imgSC.png"), 0,5,120,139);
//        player.setLayoutX(root.getWidth()/2-player.getBoundsInParent().getWidth()/2);
        player.setLayoutX(800/2 - 120/2); // make player at the center with fixed position, will fix later
        gameLayer.getChildren().add(player);

        AnimationTimer playerAnimations = new AnimationTimer() {
            long last = 0;
            @Override
            public void handle(long now) {
                if(last==0) {
                    last = now;
                    return;
                }
                double dt = (now-last)/1e9;
                last = now;
                velocity += gravity;
                player.setLayoutY(player.getLayoutY()+velocity);
                double groundY = root.getHeight()-groundH;
                double playerFeet = player.getLayoutY()+player.getBoundsInParent().getHeight();
                if(playerFeet>groundY) {
                    player.setLayoutY(groundY-player.getBoundsInParent().getHeight());
                    velocity = 0;
                    onGround = true;
                } else {
                    onGround = false;
                }
                player.update(dt);
            }
        };

        playerAnimations.start();

        scene.setOnKeyPressed(e -> {
            if(e.getCode()==KeyCode.SPACE) {
                handlePlayerJump();
            }
        });
    }

    public Scene getScene() {
        return scene;
    }
}
