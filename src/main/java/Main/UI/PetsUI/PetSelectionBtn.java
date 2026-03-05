package Main.UI.PetsUI;

import Main.GameLogic.GameState;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import Main.Asset;
import Main.Button.NavigationButton;

public class PetSelectionBtn extends HBox {

    public PetSelectionBtn(Region spacer){

        NavigationButton backBtn = new NavigationButton(Asset.createImageView("BackBtn",100,0), GameState.INTRO);
        NavigationButton cookieBtn = new NavigationButton(Asset.createImageView("SEcookie",100,0),GameState.SELECT_CHAR);

        getChildren().addAll(spacer, cookieBtn, backBtn);
        setSpacing(20);
        setMaxHeight(1);
        setPadding(new Insets(0,20,10,0));

    }
}
