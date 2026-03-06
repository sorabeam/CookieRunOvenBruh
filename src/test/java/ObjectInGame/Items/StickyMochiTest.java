package ObjectInGame.Items;

import Main.Cookies.Cookie;
import Main.GameLogic.GameLogic;
import Main.ObjectInGame.Items.StickyMochi;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StickyMochiTest {

    static class TestCookie extends Cookie {

        public TestCookie() {
            super(0,"Test",100,"Test Cookie");
        }

        @Override
        public void useSkill() {}
    }

    @Test
    void testName() {
        StickyMochi mochi = new StickyMochi();
        assertEquals("StickyMochi", mochi.getName());
    }

    @Test
    void testInteractHealAndScore() {

        StickyMochi mochi = new StickyMochi();
        TestCookie cookie = new TestCookie();

        cookie.setHp(50);

        int beforeScore = GameLogic.getScore();

        mochi.interact(cookie);

        assertEquals(70, cookie.get_Hp()); // heal 20
        assertEquals(beforeScore + 1000, GameLogic.getScore());
    }
}