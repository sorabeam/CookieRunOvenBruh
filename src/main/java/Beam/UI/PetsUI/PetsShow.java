package Beam.UI.PetsUI;

import Beam.CharactorData;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import Beam.Asset;
import Beam.Button.SelectPBtn;

public class PetsShow extends HBox {

    public PetsShow(Region spacer){

        SelectPBtn ins1 =new SelectPBtn(CharactorData.MOJINIGA.getBtnView(),"Moji Niga",28,50);
        SelectPBtn ins2 =new SelectPBtn(CharactorData.KANGFUNIGA.getBtnView() ,"KANGFUNIGA",28,50);
        SelectPBtn ins3 =new SelectPBtn(CharactorData.PANDAFANG.getBtnView(),"PANDAFANG",28,50);
        SelectPBtn ins4 =new SelectPBtn(CharactorData.LOCKING.getBtnView(),"LOCKING",28,50);

        SelectPBtn ins5 =new SelectPBtn(Asset.createImageView("Pancake",0,230),"Pancake",28,50);

        getChildren().addAll(spacer, ins1, ins2, ins3, ins4);
        setSpacing(-15);
        setPadding(new Insets(0,10,0,0));

    }
}
