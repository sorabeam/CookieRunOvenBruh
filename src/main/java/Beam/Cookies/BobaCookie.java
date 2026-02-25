package Beam.Cookies;

import javafx.scene.image.ImageView;
import Beam.Animation.Animate;
import Beam.Asset;

public class BobaCookie extends Cookie{

    public BobaCookie(){
        super(1, "BobaCookie" , 500, "NamBa?");
    }

    public ImageView createCookie(){
        cookie = new Animate(
                Asset.getImage("Boba_Milk_Tea_Cookie"),
                6,4,1,1,
                5,4,1,1,
                5,
                400,400);

        return cookie;
    }

    @Override
    public void useSkill() {

    }
}
