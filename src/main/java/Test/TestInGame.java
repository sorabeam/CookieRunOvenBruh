package Test;

import GUI_beam.Animate;
import GameScenes.GameOverScene;
import GameScenes.InGameScene;
import GameScenes.IntroScene;
import Media.JooxBox;
import components.ScoreBoard;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TestInGame extends Application {
    private Scene introScene;
    private Scene inGameScene;
    private Scene gameOverScene;
    private void initScenes() {
        this.introScene = new IntroScene().getScene();
        this.inGameScene = new InGameScene().getScene();
//        this.gameOverScene = new GameOverScene().getScene();
    }
    @Override
    public void start(Stage stage) {
        initScenes();
        stage.setScene(introScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
