package Beam.Button;

import Beam.Asset;
import Got.GameLogic.GameLogic;
import javafx.scene.image.ImageView;


public class MapSelectionBtn extends BaseButton{
    private int mapNo;
    private MapPopUpBtn targetBtn;

    public MapSelectionBtn(ImageView img ,MapPopUpBtn targetBtn,int mapNo) {
        super(img);
        this.mapNo = mapNo;
        this.targetBtn = targetBtn;
    }

    @Override
    public void handleClick() {
        super.handleClick();

        GameLogic.setMap(mapNo);
        targetBtn.setImg(Asset.createImageView("MAP"+mapNo+"P",0,400));
    }
}
