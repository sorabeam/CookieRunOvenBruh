package ObjectInGame.Items;

import Main.Cookies.Cookie;
import Main.GameLogic.GameLogic;
import Main.ObjectInGame.Items.Tomato;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TomatoTest {

    static class TestCookie extends Cookie {

        public TestCookie() {
            super(0,"Test",100,"Test Cookie");
        }

        @Override
        public void useSkill() {}
    }

    @Test
    void testName() {
        Tomato tomato = new Tomato();
        assertEquals("Tomato", tomato.getName());
    }

    @Test
    void testInteractHealAndScore() {

        Tomato tomato = new Tomato();
        TestCookie cookie = new TestCookie();

        cookie.setHp(50);

        int beforeScore = GameLogic.getScore();

        tomato.interact(cookie);

        assertEquals(70, cookie.get_Hp()); // heal 20
        assertEquals(beforeScore + 100, GameLogic.getScore());
    }
}