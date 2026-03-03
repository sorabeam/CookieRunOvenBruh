package Beam.UI.MainUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import Beam.Asset;
import Beam.Image.FloorFade;
import Beam.Image.OutlineText;
import javafx.scene.paint.Color;

public class MainMenuBG extends StackPane {

    public MainMenuBG(){

        ImageView MBg = Asset.createBackgroundView("BgLobby",1,1);

        // bind กับตัวเอง
        MBg.fitWidthProperty().bind(widthProperty());
        MBg.fitHeightProperty().bind(heightProperty());

        FloorFade fade = new FloorFade(200);
        StackPane.setAlignment(fade, Pos.BOTTOM_CENTER);

        OutlineText name = new OutlineText("sorabeam",'M',18);
        StackPane.setAlignment(name, Pos.BOTTOM_LEFT);
        StackPane.setMargin(name,new Insets(0,0,20,40));
        name.setMaxWidth(50);

        getChildren().addAll(MBg, fade, name);
    }
}

