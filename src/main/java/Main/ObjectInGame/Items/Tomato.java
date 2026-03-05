package Main.ObjectInGame.Items;

import Main.Cookies.Cookie;
import Main.GameLogic.GameLogic;

public class Tomato extends BaseItem {
    public Tomato() {
        super("Tomato");
    }

    public void interact(Cookie player) {
        player.heal(20);
        GameLogic.addScore(100);
    }
}
