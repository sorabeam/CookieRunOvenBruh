package Main.UI.CookiesUI;

import Main.GameLogic.GameState;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import Main.Asset;
import Main.Button.NavigationButton;

public class CharacterSelectButtons extends HBox {
    public  CharacterSelectButtons(){
        NavigationButton BackBtn = new NavigationButton(Asset.createImageView("BackBtn",0,200), GameState.INTRO);
        NavigationButton PetsBtn = new NavigationButton(Asset.createImageView("CSPetsBtn",0,200),GameState.SELECT_PET);

        getChildren().addAll(BackBtn, PetsBtn);
        setSpacing(20);
        setAlignment(Pos.BOTTOM_LEFT);

        setPadding(new Insets(10, 0, 0, 30));
    }
}
