package Beam.Button;

import Beam.Asset;
import Got.GameLogic.GameLogic;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class MapPopUpBtn extends BaseButton{

    private StackPane overlay;
    private StackPane root;

    private MapSelectionBtn m1 = new MapSelectionBtn(Asset.createImageView("MAP1P",400,400),this,1);
    private MapSelectionBtn m2 = new MapSelectionBtn(Asset.createImageView("MAP2P",400,400),this,2);
    private MapSelectionBtn m3 = new MapSelectionBtn(Asset.createImageView("MAP3P",400,400),this,3);

    public MapPopUpBtn(ImageView img,StackPane root) {
        super(img);
        this.root = root;

        deleteThis(m1);
        deleteThis(m2);
        deleteThis(m3);
    }

    public void setImg(ImageView img){
        setGraphic(img);
    }

    @Override
    public void handleClick() {
        super.handleClick();

        showMap();
    }

    private void showMap() {
        overlay = new StackPane();
        ImageView BgPane = Asset.createImageView("MBGS",0,440);

        VBox MapVB = new VBox(m1,m2,m3);

        MapVB.setMaxHeight(400);
        MapVB.setMaxWidth(400);
        MapVB.setSpacing(10);

        overlay.getChildren().addAll(BgPane,MapVB);

        overlay.setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        overlay.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        overlay.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        StackPane.setMargin(overlay,new Insets(-80,0,0,-80));
        StackPane.setMargin(MapVB,new Insets(20,0,0,0));
        root.getChildren().addAll(overlay);
    }

    private void deleteThis(MapSelectionBtn button) {

        var oldAction = button.getOnAction();
        button.setOnAction(e -> {

            if (oldAction != null) {
                oldAction.handle(e);
            }

            root.getChildren().remove(overlay);
        });
    }

}
