package Pors.ObjectInGame.Items;

import Beam.Cookies.Cookie;
import Got.GameLogic.GameLogic;

public class Tomato extends BaseItem {
    public Tomato() {
        super("Tomato");
    }

    public void interact(Cookie playert) {
        GameLogic.addScore(500);
    }
}
