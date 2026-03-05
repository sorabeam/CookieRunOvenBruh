package Beam.Scene;

import Beam.Animation.Animate;
import Beam.CharacterData;
import Beam.UI.MainUI.*;

import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class MainMenuScene extends BaseScene {

    public MainMenuScene() {
        super();

        StackPane profile = new MainMenuProfile(CharacterData.getCurrent_Cookie().get_Name(), CharacterData.getCurrent_Cookie().get_Score() + "",root);
        HBox setting = new SettingZone(root,spacer('H'));
        StackPane mainMenuButtons = new MainMenuButtons();
        StackPane glassDecoration = new GlassDecoration();

        CharactorShow imgShow = new CharactorShow();
        Animate cookie = imgShow.getCookie();

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

        root.getChildren().addAll(
                new MainMenuBG(),
                profile,
                setting,
                imgShow,
                mainMenuButtons,
                glassDecoration
        );

        StackPane.setAlignment(glassDecoration,Pos.CENTER_RIGHT);
        StackPane.setAlignment(mainMenuButtons, Pos.BOTTOM_CENTER);
        StackPane.setAlignment(setting, Pos.TOP_RIGHT);
        StackPane.setMargin(setting,new Insets(20,20,0,0));
        StackPane.setAlignment(profile, Pos.TOP_LEFT);
    }
}