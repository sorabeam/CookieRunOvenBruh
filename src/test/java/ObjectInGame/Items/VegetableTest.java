package ObjectInGame.Items;

import Main.Cookies.Cookie;
import Main.GameLogic.GameLogic;
import Main.ObjectInGame.Items.Vegetable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VegetableTest {

    static class TestCookie extends Cookie {

        public TestCookie() {
            super(0,"Test",100,"Test Cookie");
        }

        @Override
        public void useSkill() {}
    }

    @Test
    void testName() {
        Vegetable veg = new Vegetable();
        assertEquals("Vegetable", veg.getName());
    }

    @Test
    void testInteractAddsScore() {

        Vegetable veg = new Vegetable();
        TestCookie cookie = new TestCookie();

        int before = GameLogic.getScore();

        veg.interact(cookie);

        int after = GameLogic.getScore();

        assertEquals(before + 300, after);
    }
}