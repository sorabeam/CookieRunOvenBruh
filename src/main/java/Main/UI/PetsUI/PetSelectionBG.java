package Main.UI.PetsUI;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import Main.Asset;
import Main.Image.FloorFade;

public class PetSelectionBG extends StackPane {

    public PetSelectionBG(){

        ImageView MBg = Asset.createBackgroundView("RedStage",1,1);

        MBg.setPreserveRatio(false);
        MBg.fitWidthProperty().bind(widthProperty());
        MBg.fitHeightProperty().bind(heightProperty());

        ImageView ryd = Asset.createImageView("Royaldec",250 ,100);
        ryd.fitWidthProperty().bind(widthProperty());

        FloorFade fade = new FloorFade(200);
        StackPane.setAlignment(fade, Pos.BOTTOM_CENTER);
        StackPane.setAlignment(ryd, Pos.BOTTOM_CENTER);

        getChildren().addAll(MBg , ryd , fade);
    }

}
