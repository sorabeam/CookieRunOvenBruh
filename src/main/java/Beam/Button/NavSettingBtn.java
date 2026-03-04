package Beam.Button;

import Got.GameLogic.GameLogic;
import Got.GameLogic.GameState;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import Beam.Asset;
import Beam.Image.OutlineText;

public class NavSettingBtn extends NavBtn {

    private StackPane Rimg;
    private DropShadow shadow;
    private OutlineText outl;
    private String txt;

    public NavSettingBtn(GameState switchState , String txt) {

        super(Asset.createImageView("SBtnBg",0,400),switchState);
        this.txt = txt;
        shadow = setShadow();

        outl = new OutlineText(txt,'C',25);

        outl.setDropShadow(shadow);
        outl.setMaxWidth(1);
        Rimg = new StackPane(Asset.createImageView("SBtnBg",0,400),outl);

        StackPane.setAlignment(outl,Pos.TOP_LEFT);
        setGraphic(Rimg);

    }

    private DropShadow setShadow(){
        DropShadow shadow = new DropShadow();
        shadow.setRadius(10);
        shadow.setBlurType(BlurType.GAUSSIAN);
        shadow.setColor(Color.rgb(255,255,255,0.3));
        return shadow;
    }

    @Override
    public void handleClick() {
        super.handleClick();
    }

    public void setInset(Insets i){
        StackPane.setMargin(outl,i);
    }

    public String getTxt() {
        return txt;
    }
}