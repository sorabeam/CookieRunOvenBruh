package Main.UI.PetsUI;

import Main.CharacterData;
import Main.Scene.PetsSelectionScene;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import Main.Image.OutlineTextImage;

import static javafx.geometry.Pos.*;

public class SelectingView extends StackPane {

    public SelectingView(StackPane root, PetsSelectionScene petsScene){

        setPrefSize(600, 1000);
        setMinSize(400, 550);
        setMaxSize(600, 1000);

        System.out.println(CharacterData.getCurrent_Pet().getViewImage());
        ImageView show = new ImageView( CharacterData.getCurrent_Pet().getViewImage() );
        show.setPreserveRatio(true);

        ImageView selectingBackGround = new ImageView(
                CharacterData.getCurrent_Pet().getBackGroundImage()
        );

        selectingBackGround.setPreserveRatio(false);
        selectingBackGround.setFitWidth(350);
        selectingBackGround.fitHeightProperty().bind(root.heightProperty());
        StackPane.setAlignment(selectingBackGround, CENTER);

        OutlineTextImage pName =
                new OutlineTextImage(CharacterData.getCurrent_Pet().getName(),'C',40);

        OutlineTextImage description =
                new OutlineTextImage(CharacterData.getCurrent_Pet().getDescription(),'M',20);

        description.setTextAlignment(TextAlignment.CENTER);

        show.setFitWidth(450);
        show.setFitHeight(450);

        VBox vbox = new VBox(show, pName, description);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(30);

        setAlignment(vbox, Pos.CENTER);

        // ส่ง reference กลับไป scene
        petsScene.setShowImage(show);
        petsScene.setBackGroundImage(selectingBackGround);
        petsScene.setName(pName);
        petsScene.setDescription(description);

        getChildren().addAll(selectingBackGround, vbox);
    }
}
