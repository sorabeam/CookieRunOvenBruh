package Main.Cookies;

import Main.Animation.AnimationType;
import Main.ObjectInGame.Items.Pearl;
import Main.Animation.Animate;
import Main.Asset;

public class BobaCookie extends Cookie{

    public BobaCookie(){

        super(1, "Boba" , 150,
                """
                        Every 10 seconds Boba Cookie
                        launches the Pearl Beads forward,
                        smashing through obstacles and
                        earning bonus points.""");

        setImgURL("Boba_Milk_Tea_Cookie");
        setProfileImg(Asset.getImage("Profile_Boba"));
        setScore(23500);
        setCooldownTimer(0);
        setSkillCooldown(10);
        setHasCooldown(true);
    }

    @Override
    public Animate createCookie(){
        return super.createCookie();
    }

    @Override
    public void update(double deltaTime) {
        super.update(deltaTime);

        if (isDead()) return;

        setCooldownTimer(getCooldownTimer() + deltaTime);

        if (getCooldownTimer() >= getSkillCooldown()) {
            useSkill();
            setCooldownTimer(0);
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

        playSkill(0.6);
        cookie.changeAnimationState(AnimationType.SKILL);
    }

    @Override
    public double getCooldownProgress(){
        return Math.min(getCooldownTimer() / getSkillCooldown(), 1.0);
    }
}
