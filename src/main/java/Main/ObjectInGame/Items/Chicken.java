package Main.ObjectInGame.Items;

import Main.Cookies.Cookie;
import Main.GameLogic.GameLogic;

public class Chicken extends BaseItem {
    public Chicken() {
        super("Chicken");
    }

    public void interact(Cookie player) {
        GameLogic.addScore(500);
    }
}
