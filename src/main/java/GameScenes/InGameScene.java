package GameScenes;

import components.ScoreBoard;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.paint.Color;

public class InGameScene {
    private Scene scene;

    public InGameScene() {
        AnchorPane root = new AnchorPane();
        ScoreBoard scoreBoard = new ScoreBoard();
        root.setPrefSize(800, 600);
        AnchorPane.setTopAnchor(scoreBoard, 10.0);
        AnchorPane.setRightAnchor(scoreBoard, 20.0);
        root.getChildren().add(scoreBoard);
        this.scene = new Scene(root);
        scene.setFill(Color.BLACK);
    }

    public Scene getScene() {
        return scene;
    }
}
