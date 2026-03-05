package Main.Pets;

import Main.Asset;

public class SamplePet extends Pet{

    public SamplePet(int id, String name, String description,String imageKey) {
        super(id, name, description);

        setView(Asset.createImageView("Selecting_Boba",0,480));
        setViewImage(Asset.getImage(imageKey));
        setBackGroundImage(Asset.getImage("Selecting_Boba"));
        setButtonImage(Asset.getImage(imageKey));
    }

    @Override
    public void useSkill() {

    }
}
