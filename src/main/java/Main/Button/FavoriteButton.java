package Main.Button;

import javafx.scene.image.ImageView;
import Main.Asset;

public class FavoriteButton extends BaseButton{

    public FavoriteButton() {
        super(Asset.createImageView("FavIco",30,0));
    }

    public void setHeight(double H){
        ImageView img = (ImageView) getGraphic();
        img.setFitHeight(H);
    }
}
