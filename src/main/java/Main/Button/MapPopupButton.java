package Main.Button;

import Main.Asset;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class MapPopupButton extends BaseButton{

    private StackPane overlay;
    private final StackPane root;

    private final MapSelectionButton map1 = new MapSelectionButton(Asset.createImageView("MAP1P",400,400),this,1);
    private final MapSelectionButton map2 = new MapSelectionButton(Asset.createImageView("MAP2P",400,400),this,2);
    private final MapSelectionButton map3 = new MapSelectionButton(Asset.createImageView("MAP3P",400,400),this,3);

    public MapPopupButton(ImageView img, StackPane root) {
        super(img);
        this.root = root;

        deleteThis(map1);
        deleteThis(map2);
        deleteThis(map3);
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

        VBox MapVB = new VBox(map1,map2,map3);

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

    private void deleteThis(MapSelectionButton button) {

        var oldAction = button.getOnAction();
        button.setOnAction(e -> {

            if (oldAction != null) {
                oldAction.handle(e);
            }

            root.getChildren().remove(overlay);
        });
    }

}
