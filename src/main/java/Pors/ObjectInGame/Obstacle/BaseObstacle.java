package Pors.ObjectInGame.Obstacle;

import Beam.Cookies.Cookie;
import Pors.ObjectInGame.Interactable;

public class BaseObstacle implements Interactable {
    private String name;
    private int damage;

    public BaseObstacle(String name, int damage)
    {
        setName(name);
        setDamage(damage);
    }

    @Override
    public void interact(Cookie player) {
        if(player.isInvincible()){
            return;
        }
        //player.takeDamage(damage);
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
