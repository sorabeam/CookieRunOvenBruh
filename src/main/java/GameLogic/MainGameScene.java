package GameLogic;

import Beam.CharacterData;
import Beam.Media.MediaPlayer;
import Beam.Scene.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainGameScene extends Application {

    private StackPane gameRoot;
    private Scene scene;
    private StackPane scalableLayer;

    private static final double BASE_WIDTH = 1600;
    private static final double BASE_HEIGHT = 900;

    @Override
    public void start(Stage stage) {

        GameLogic.setStage(stage);

        gameRoot = new StackPane();
        gameRoot.setPrefSize(BASE_WIDTH, BASE_HEIGHT);

        scalableLayer = new StackPane(gameRoot);

        StackPane root = new StackPane(scalableLayer);
        root.setBackground(new Background(new BackgroundFill(Color.BLACK,null,null)));

        scene = new Scene(root, BASE_WIDTH, BASE_HEIGHT);
        stage.setScene(scene);
        GameLogic.setApp(this);

        scene.widthProperty().addListener((obs, oldVal, newVal) -> {
            updateScale(scalableLayer);
        });

        scene.heightProperty().addListener((obs, oldVal, newVal) -> {
            updateScale(scalableLayer);
        });

        GameLogic.setGameRoot(gameRoot);

        GameLogic.gameStateProperty().addListener((obs, oldState, newState) -> {

            switch (newState) {
                case INTRO -> {
                    gameRoot.getChildren().setAll(new MainMenuScene());
                    playMusic("Lobby",50);
                }

                case SELECTCHAR -> {
                    gameRoot.getChildren().setAll(new CookieSelectionScene());
                    playMusic("Cookies",50);
                }

                case INGAME -> {

                    CharacterData.getCurrent_Cookie().setHp(CharacterData.getCurrent_Cookie().getMaxHp());
                    CharacterData.getCurrent_Cookie().setCooldownTimer(0);
                    CharacterData.getCurrent_Cookie().setSkillCounter(0);
                    CharacterData.getCurrent_Cookie().setDead(false);
                    CharacterData.getCurrent_Cookie().reset();
                    GameLogic.setScore(0);
                    playMusic("SoundMAP" + GameLogic.getMap(),50);

                    GameplayScene inGameScene = new GameplayScene();
                    GameLogic.setCurrentGameScene(inGameScene);
                    gameRoot.getChildren().setAll(inGameScene);
                }
                case SELECTPET -> {
                    gameRoot.getChildren().setAll(new PetsSelectionScene());
                    playMusic("Pets",50);
                }

                case GAMEOVER -> {
                    gameRoot.getChildren().setAll(new GameOverScene());
                    playMusic("GameOver",50);
                }
            }
        });

        GameLogic.setCurScene(scene);
        GameLogic.setGameState(GameState.INTRO);
        stage.show();

        updateScale(scalableLayer);
    }

    private void updateScale(StackPane scalableLayer) {

        double scaleX = scene.getWidth() / BASE_WIDTH;
        double scaleY = scene.getHeight() / BASE_HEIGHT;

        double scale = Math.min(scaleX, scaleY);

        scalableLayer.setScaleX(scale);
        scalableLayer.setScaleY(scale);
    }

    public static void main(String[] args) {
        launch();
    }

    private void playMusic(String key,int v) {
        MediaPlayer.getInstance().playBGM(key, true);
    }
}