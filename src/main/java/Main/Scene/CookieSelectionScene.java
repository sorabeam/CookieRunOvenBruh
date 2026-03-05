
package Main.Scene;

import Main.Animation.Animate;
import Main.Animation.AnimationType;
import Main.Button.BaseButton;
import Main.UI.CookiesUI.*;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import Main.Asset;
import Main.Button.CharacterButton;
import Main.CharacterData;
import Main.Image.OutlineTextImage;

import static javafx.geometry.Pos.BOTTOM_CENTER;

public class CookieSelectionScene extends BaseScene {

    CharacterButton block1 = Asset.createGridButton(CharacterData.BOBA_COOKIE,220,0);
    CharacterButton block2 = Asset.createGridButton(CharacterData.TOMYUM_COOKIE,220,0);
    CharacterButton block3 = Asset.createGridButton(CharacterData.CROSSIANT_COOKIE,220,0);

    BaseButton block4 = new BaseButton(Asset.createImageView("B4",220,0));

    ImageView skillVideo;
    OutlineTextImage name,description,record;
    Animate cookie;
    CharacterButton selectButton = block1;

    GridPane characterBoard = new GridDisplay(block1, block2, block3,block4);
    CharacterDisplay characterDisplay =  new CharacterDisplay(this);

    public CookieSelectionScene(){
        super();
        HBox Setting = new SettingZone(root,spacer('H'));
        String txt = CharacterData.getCurrent_Cookie().get_Desc();
        initCookieBtn();

        HBox MainHBox = new HBox(characterDisplay,new DataDisplay(txt,this),characterBoard);
        MainHBox.setPadding(new Insets(0,30,0,30));

        HBox.setMargin(characterDisplay,new Insets(0,0,-30,0));
        //MainHBox.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
        CharacterSelectButtons Btns = new CharacterSelectButtons();
        VBox MainLayer = new VBox(Setting,MainHBox,Btns);

        root.getChildren().addAll(
                new CookieSelectBG(),
                MainLayer
        );

        cookie.changeAnimationState(AnimationType.IDLE);
        AnimationTimer timer = new AnimationTimer() {

            long last = 0;

            @Override
            public void handle(long now) {

                if (last == 0) {
                    last = now;
                    return;
                }

                double dt = (now - last) / 1e9;
                last = now;

                cookie.update(dt);
            }
        };

        timer.start();

        VBox.setMargin(Btns,new Insets(0,0,30,30));
        MainHBox.setPrefHeight(540);
        MainHBox.setSpacing(20);
        MainHBox.setAlignment(Pos.CENTER);
        MainLayer.setSpacing(50);
        MainLayer.setAlignment(Pos.TOP_RIGHT);
        VBox.setMargin(Setting,new Insets(20,20,0,0));

    }

    private void initCookieBtn() {
        enableShow(block1);
        enableShow(block2);
        enableShow(block3);
    }

    private void enableShow (CharacterButton button) {

        var oldAction = button.getOnAction();

        button.setOnAction(e -> {

            if (oldAction != null) {
                oldAction.handle(e);
            }

            skillVideo.setImage(button.getImage());
            name.setText(button.getName());
            description.setText(button.getDescription());
            record.setText(button.getRecord());
            selectButton = button;

            Animate newCookie = button.getCookie().createCookie();

            if (newCookie != null) {

                if (cookie != null) {
                    characterDisplay.getChildren().remove(cookie);
                }

                cookie = newCookie;
                cookie.changeAnimationState(AnimationType.IDLE);

                characterDisplay.getChildren().add(cookie);
                StackPane.setAlignment(cookie, BOTTOM_CENTER);

                CharacterData.setCurrent_Cookie(button.getCookie());
            }System.out.println("Current_Cookie change to " + CharacterData.getCurrent_Cookie().get_Name());
        });


    }

    public void setSkillVideo(ImageView skillVideo) { this.skillVideo = skillVideo; }
    public void setName(OutlineTextImage name) { this.name = name; }
    public void setDescription(OutlineTextImage description) { this.description = description; }
    public void setRecord(OutlineTextImage record) { this.record = record; }
    public void setCookie(Animate cookie) { this.cookie = cookie; }

    public ImageView getSkillVideo() { return skillVideo; }
    public OutlineTextImage getName() { return name; }
    public OutlineTextImage getDescription() { return description; }
    public OutlineTextImage getRecord() { return record; }
    public Animate getCookie() { return cookie; }
}
