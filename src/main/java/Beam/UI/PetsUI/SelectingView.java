package Beam.UI.PetsUI;

import Beam.CharactorData;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import Beam.Asset;
import Beam.Button.BaseButton;
import Beam.Image.OutlineText;

import static javafx.geometry.Pos.*;

public class SelectingView extends StackPane {
    public SelectingView(){

        setPrefSize(550, 865);
        setMinSize(550, 550);
        setMaxSize(550, 865);

        Rectangle clip = new Rectangle();
        clip.widthProperty().bind(widthProperty());
        clip.heightProperty().bind(heightProperty());

        setClip(clip);

        ImageView Show = CharactorData.getCurrent_Pet().getView();
        ImageView SelectingBg = CharactorData.getCurrent_Pet().getBg();
        BaseButton DeployBtn = new BaseButton( Asset.createImageView("DeplayBtn",0,330));

        SelectingBg.setPreserveRatio(false);
        SelectingBg.fitHeightProperty().bind(heightProperty());
        StackPane.setAlignment(SelectingBg,CENTER);

        OutlineText PName = new OutlineText(CharactorData.getCurrent_Pet().getName(),'C',40);

        OutlineText description = new OutlineText(CharactorData.getCurrent_Pet().getDesc(),'M',20);
        description.setTextAlignment(TextAlignment.CENTER);

        VBox vbox = new VBox(Show,PName,DeployBtn,description);

        vbox.setAlignment(Pos.CENTER);
        setAlignment(vbox, Pos.CENTER);
        vbox.setSpacing(30);

        getChildren().addAll(SelectingBg, vbox);

    }
}

