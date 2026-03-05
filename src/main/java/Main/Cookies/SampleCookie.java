package Main.Cookies;

import Main.Animation.Animate;

public class SampleCookie extends Cookie{

    public SampleCookie(int id, String name, int hp, String description) {
        super(id, name, hp, description);
    }

    @Override
    public void useSkill() {

    }

    @Override
    public Animate createCookie() {
        return null;
    }
}
