package Beam.Cookies;

import Beam.Asset;

public class TomYumCookie extends Cookie {

    private boolean rainReady = false;

    public TomYumCookie() {
        super(2, "TomYum", 170,
                """
                        Every 15 seconds, Tom Yum Cookie
                        summons Ingredient Rain.
                        Shrimp, Galangal, Lemongrass,
                        and Kaffir Lime Leaf
                        Jellies fall from the sky,
                        granting bonus points.""");
        setImgURL("TomYum_Cookie_sheet");
        setProfileImg(Asset.getImage("Profile_Tomyum"));
        setScore(133000);
        setHasCooldown(true);
        setCooldownTimer(0);
        setSkillCooldown(15);
    }

    @Override
    public void useSkill() {
        if (isDead()) return;

        playSkill(0.5);
        setCooldownTimer(0);
        setInvincible(2.0);
        rainReady = true;
    }

    public void updateSkill(double dt){

        setCooldownTimer(getCooldownTimer() + dt);

        if(getCooldownTimer() >= getSkillCooldown()){
            useSkill();
        }
    }

    @Override
    public double getCooldownProgress(){
        return Math.min(cooldownTimer / skillCooldown, 1.0);
    }

    public boolean isSkillReady(){
        return rainReady;
    }

    public void consumeRain(){
        rainReady = false;
    }
}
