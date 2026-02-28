package Beam.Button;

import javafx.scene.image.ImageView;
import Beam.Asset;

public class FavBtn extends BaseButton{

    private boolean isFav = true;

    public FavBtn() {
        super(Asset.createImageView("FavIco",30,0));
    }

    public void setHeight(double H){
        ImageView img = (ImageView) getGraphic();
        img.setFitHeight(H);
    }
}
