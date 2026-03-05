package Main.ObjectInGame.Items;

import Main.Cookies.Cookie;
import Main.GameLogic.GameLogic;

public class Vegetable extends BaseItem{
    public Vegetable() {
        super("Vegetable");
    }

    public void interact(Cookie player) {
        GameLogic.addScore(300);
    }
}
