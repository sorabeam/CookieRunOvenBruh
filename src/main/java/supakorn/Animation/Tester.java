package supakorn.Animation;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import supakorn.Asset;

import static javafx.application.Application.launch;

public class Tester extends Application {

    private Scene scene;
    private Pane root;
    private Asset asset = new Asset();

    @Override
    public void start(Stage stage) throws Exception {
        root = new StackPane();
        root.setPrefSize(800, 600);
        scene = new Scene(root);

        Animate Tester = new Animate(Asset.getImage("Boba_Milk_Tea_Cookie"),4,4,4,4,4,4,4,4,400,400);

        AnimationTimer at = new AnimationTimer() {

            private long lastTime = 0;

            @Override
            public void handle(long now) {

                if (lastTime == 0) {
                    lastTime = now;
                    return;
                }

                double deltaTime = (now - lastTime) / 1_000_000_000.0;
                lastTime = now;

                Tester.update(deltaTime);
                System.out.println("1");
            }
        };
        at.start();

        root.getChildren().add(Tester);
        stage.setTitle("CEDT Cookie Run -main");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
