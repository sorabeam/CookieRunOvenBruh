package Beam.Cookies;

import Beam.Animation.Animate;

public class CrossiantCookie extends Cookie {
    private boolean skillReady = true;
    private boolean isUsingSkill = false;
    private final int coolDown = 7000; // this is in miliseconds unit, becareful
    public CrossiantCookie() {
        super(2, "CrossiantCookie", 140, "");

        setImgURL("crossiant_sheet");
        skillcoodown = 10;
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
                setSkillReady(false);
                Thread.sleep(coolDown);
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
