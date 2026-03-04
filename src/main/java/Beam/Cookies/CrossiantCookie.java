package Beam.Cookies;

import Beam.Animation.Animate;

public class CrossiantCookie extends Cookie {
    private boolean skillReady = true;
    private boolean isUsingSkill = false;
    private final int coolDown = 1000; // this is in miliseconds unit, becareful test

    public CrossiantCookie() {
        super(3, "CrossiantCookie", 140, "fakayouki");
        setImgURL("crossiant_sheet");
        skillcoodown = 3;
        setScore(13700);
    }

    @Override
    public Animate createCookie() {
        return super.createCookie();
    }

    @Override
    public void useSkill() {
        if(!skillReady) return;
        Thread countDownSkill = new Thread(() -> {
            try {
                setUsingSkill(true);
                setSkillReady(false);
                Thread.sleep(coolDown);
                setUsingSkill(false);
                setSkillReady(true);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        countDownSkill.start();
    }

    public void setSkillReady(boolean skillReady) {
        this.skillReady = skillReady;
    }

    public boolean getSkillReady() {
        return skillReady;
    }

    public void setUsingSkill(boolean usingSkill) {
        isUsingSkill = usingSkill;
    }

    public boolean isUsingSkill() {
        return isUsingSkill;
    }
}
