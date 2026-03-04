package Beam.Cookies;

import Beam.Animation.AnimationType;
import Filmmy.Pearl;
import Beam.Animation.Animate;
import Beam.Asset;

public class BobaCookie extends Cookie{

    protected double cooldownTimer = 0;
    protected double skillCooldown = 10;

    public BobaCookie(){

        super(1, "BobaCookie" , 150,
                "Boba Milk Tea Cookie is a laid-back spirit " +"\n"+
                      "and the true queen of the boba world." +"\n"+
                      "Every 10 seconds, she launches the Pearl "+ " \n " +
                      "Beads forward, smashing through obstacles "+ " \n " +
                      "and earning bonus points.?");

        setImgURL("Boba_Milk_Tea_Cookie");
    }

    @Override
    public Animate createCookie(){
        return super.createCookie();
    }

    @Override
    public void update(double deltaTime) {
        super.update(deltaTime);

        cooldownTimer += deltaTime;

        if (cooldownTimer >= skillCooldown) {
            useSkill();
            cooldownTimer = 0;
        }
    }

    @Override
    public void useSkill() {
        setInvincible(2.0);

        Pearl pearl = new Pearl(
                cookie.getLayoutX() + cookie.getFitWidth(),
                cookie.getLayoutY() + cookie.getFitHeight() * 0.6
        );

        getParentLayer().getChildren().add(pearl);

        playSkill(0.3);
        cookie.changeAnimationState(AnimationType.SKILL);
    }

    @Override
    public double getCooldownProgress(){
        return Math.min(cooldownTimer / skillCooldown, 1.0);
    }

}
