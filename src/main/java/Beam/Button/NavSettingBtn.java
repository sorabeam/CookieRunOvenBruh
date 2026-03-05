package Beam.Button;

import GameLogic.GameState;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import Beam.Asset;
import Beam.Image.OutlineTextImage;

public class NavSettingBtn extends NavigationButton {

    private final OutlineTextImage outlineTextImage;
    private final String txt;
    private final SettingsPopUpButton settingsPopupButton;

    public NavSettingBtn(GameState switchState , String txt, SettingsPopUpButton settingsPopupButton) {

        super(Asset.createImageView("SBtnBg",0,400),switchState);
        this.txt = txt;
        DropShadow shadow = setShadow();

        this.settingsPopupButton = settingsPopupButton;
        outlineTextImage = new OutlineTextImage(txt,'C',25);

        outlineTextImage.setDropShadow(shadow);
        outlineTextImage.setMaxWidth(1);
        StackPane buttonPane = new StackPane(Asset.createImageView("SBtnBg", 0, 400), outlineTextImage);

        StackPane.setAlignment(outlineTextImage,Pos.TOP_LEFT);
        setGraphic(buttonPane);

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

        settingsPopupButton.setOpen(false);
    }

    public void setInset(Insets i){
        StackPane.setMargin(outlineTextImage,i);
    }

    public String getTxt() {
        return txt;
    }
}