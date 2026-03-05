package Main.UI.GameOverUI;

import Main.Animation.Animate;
import Main.Animation.AnimationType;
import Main.CharacterData;
import Main.Image.OutlineTextImage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class CharacterShow extends StackPane {

    private final Animate cookieView = CharacterData.getCurrent_Cookie().createCookie();

    public CharacterShow() {
        cookieView.setFitWidth(700);
        cookieView.setPreserveRatio(true);
        cookieView.changeAnimationState(AnimationType.IDLE);
        cookieView.setStyle(
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.6), 40, 0.7, 0, 5);"
        );

        ImageView petView = CharacterData.getCurrent_Pet().getView();

        if(CharacterData.getCurrent_Pet().getName().equals(CharacterData.CHILLY.getName())){
            System.out.println("hhhhhhhh");
            petView.setFitHeight(300);
            petView.setFitWidth(300);
        } else {
            petView.setFitHeight(200);
            petView.setFitWidth(200);
        }

        petView.setStyle(
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.6), 40, 0.7, 0, 5);"
        );
        setAlignment(petView, Pos.TOP_RIGHT);
        setMargin(petView, new Insets(60,-50,0,0));

        OutlineTextImage username = new OutlineTextImage(CharacterData.getCurrent_Cookie().get_Name(), 'C',24);
        setAlignment(username, Pos.TOP_CENTER);
        setMargin(username, new Insets(0,-60,0,0));

        setMaxSize(700,700);
        getChildren().addAll(petView, cookieView, username);
    }

    public Animate getCookie(){
        return cookieView;
    }
}
