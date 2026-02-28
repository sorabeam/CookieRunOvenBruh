package Beam.Pets;

import Beam.Asset;

public class Moji extends Pet {

    public Moji() {
        super(1, "Moji Niga", " au ai ah ");

        setView(Asset.createImageView("Moji",0,480));
        setBg(Asset.createImageView("Selecting_Boba",0,350));
        setBtnView(Asset.createImageView("UnSelect_Boba",0,230));
    }

    @Override
    public void useSkill() {

    }
}
