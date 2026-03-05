
package Main.Scene;

import Main.Button.PetsButton;
import Main.UI.PetsUI.PetSelectionBG;
import Main.UI.PetsUI.PetSelectionBtn;
import Main.UI.PetsUI.SelectingView;
import Main.UI.PetsUI.SettingZone;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import Main.CharacterData;
import Main.Image.OutlineTextImage;

public class PetsSelectionScene extends BaseScene {

    ImageView showImage,backGroundImage;
    OutlineTextImage name,description;

    PetsButton ins1, ins2, ins3, ins4;

    private String txt = CharacterData.getCurrent_Pet().getDescription();

    public PetsSelectionScene(){
        super();

        ins1 = new PetsButton(CharacterData.MOJI,28,50);
        ins2 = new PetsButton(CharacterData.Chilly,28,50);
        ins3 = new PetsButton(CharacterData.SALAD,28,50);
        ins4 = new PetsButton(CharacterData.LOCKING,28,50);

        HBox box = new HBox(spacer('H'),ins1, ins2, ins3, ins4);
        box.setSpacing(-15);
        box.setPadding(new Insets(0,0,0,0));

        PetSelectionBtn petSelectionBtn = new PetSelectionBtn(spacer('H'));
        SettingZone settingZone = new SettingZone(root,spacer('H'));
        SelectingView selectingView = new SelectingView(root,this);

        VBox leftVBox = new VBox(selectingView);
        VBox rightVBox = new VBox(settingZone,box,petSelectionBtn);
        VBox.setMargin(settingZone,new Insets(20,20,0,0));
        HBox mainHBox = new HBox(leftVBox,spacer('H'),rightVBox);

        HBox.setMargin(rightVBox,new Insets(8,-12,0,0));

        root.getChildren().addAll(
                new PetSelectionBG(),
                mainHBox
        );

        //root.setBackground(new Background(new BackgroundFill(Color.RED,null,null)));

        enableSwap(ins1);
        enableSwap(ins2);
        enableSwap(ins3);

        leftVBox.setPadding(new Insets(0,0,0,50));
        leftVBox.setAlignment(Pos.CENTER);
        rightVBox.setSpacing(50);

    }

    public ImageView getShowImage() { return showImage; }
    public void setShowImage(ImageView showImage) { this.showImage = showImage; }
    public ImageView getBackGroundImage() { return backGroundImage; }
    public void setBackGroundImage(ImageView backGroundImage) { this.backGroundImage = backGroundImage; }
    public OutlineTextImage getName() { return name; }
    public void setName(OutlineTextImage name) { this.name = name; }
    public OutlineTextImage getDescription() { return description; }
    public void setDescription(OutlineTextImage description) { this.description = description; }
    public PetsButton getIns1() { return ins1; }
    public void setIns1(PetsButton ins1) { this.ins1 = ins1; }
    public PetsButton getIns2() { return ins2; }
    public void setIns2(PetsButton ins2) { this.ins2 = ins2; }
    public PetsButton getIns3() { return ins3; }
    public void setIns3(PetsButton ins3) { this.ins3 = ins3; }
    public PetsButton getIns4() { return ins4; }
    public void setIns4(PetsButton ins4) { this.ins4 = ins4; }
    public String getTxt() { return txt; }
    public void setTxt(String txt) { this.txt = txt; }

    private void enableSwap(PetsButton button) {

        var oldAction = button.getOnAction();

        button.setOnAction(e -> {

            if (oldAction != null) {
                oldAction.handle(e);
            }

            CharacterData.setCurrent_Pet(button.getPet());

            showImage.setImage(button.getPetImage());
            backGroundImage.setImage(button.getBackGround());
            name.setText(button.getName());
            description.setText(button.getDescription());

        });

    }
}
