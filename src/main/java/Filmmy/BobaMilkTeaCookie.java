package Filmmy;

import supakorn.Animation.AnimationType;
import supakorn.Asset;

public class BobaMilkTeaCookie extends Player{

    private double pearlTimer;

    public BobaMilkTeaCookie() {
        super(Asset.getImage("Boba_Milk_Tea_Cookie"), 6,4,1,1,
                5,4,1,1,5,400,400,
                1,"Boba Milk Tea Cookie",150,
                "Boba Milk Tea Cookie is a laid-back spirit and the true queen of the boba world.\n" +
                        "Every 10 seconds, she launches the Pearl Beads forward, " +
                        "smashing through obstacles and earning bonus points.");
    }

    @Override
    protected void onUpdate(double dt) {

        pearlTimer += dt;

        while (pearlTimer >= 10) {
            shootPearl();
            pearlTimer -= 10;
        }
    }

    private void shootPearl() {
        Pearl pearl = new Pearl(
                getLayoutX() + getFitWidth(),
                getLayoutY() + getFitHeight() * 0.6
        );

        getParentLayer().getChildren().add(pearl);

        playSkill(0.3);
        changeAnimationState(AnimationType.SKILL);
    }
}
