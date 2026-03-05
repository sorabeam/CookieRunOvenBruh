package Pors.ObjectInGame.Obstacle;

import Beam.Cookies.Cookie;
import Pors.ObjectInGame.Interactable;

public class BaseObstacle implements Interactable {
    private String name;
    private int damage;

    public BaseObstacle(String name)
    {
        setName(name);
        setDamage(40);
    }

    @Override
    public void interact(Cookie cookie) {
        cookie.takeDamage(getDamage());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
