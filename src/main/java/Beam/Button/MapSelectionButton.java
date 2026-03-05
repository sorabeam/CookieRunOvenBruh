package Beam.Button;

import Beam.Asset;
import GameLogic.GameLogic;
import javafx.scene.image.ImageView;


public class MapSelectionButton extends BaseButton{
    private final int mapNo;
    private final MapPopupButton targetButton;

    public MapSelectionButton(ImageView img , MapPopupButton targetButton, int mapNo) {
        super(img);
        this.mapNo = mapNo;
        this.targetButton = targetButton;
    }

    @Override
    public void handleClick() {
        super.handleClick();
        System.out.println(mapNo);
        GameLogic.setMap(mapNo);
        System.out.println(GameLogic.getMap());
        targetButton.setImg(Asset.createImageView("MAP"+mapNo+"P",0,400));
    }
}
