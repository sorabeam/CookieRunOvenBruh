package ObjectInGame.Items;

import Main.Cookies.Cookie;
import Main.ObjectInGame.Items.Croissant;
import Main.ObjectInGame.Items.CroissantType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CroissantTest {

    static class TestCookie extends Cookie {

        int healed = 0;

        public TestCookie() {
            super(1,"Test",100,"Test");
        }

        @Override
        public void useSkill() {}

        @Override
        public void heal(int healunit) {
            healed = healunit;
        }
    }

    @Test
    void testOriginalTypeName() {
        Croissant croissant = new Croissant(CroissantType.ORIGINAL,0);

        assertEquals("CroissantOriginal", croissant.getName());
    }

    @Test
    void testButterTypeName() {
        Croissant croissant = new Croissant(CroissantType.BUTTER,0);

        assertEquals("CroissantButter", croissant.getName());
    }

    @Test
    void testStrawberryTypeName() {
        Croissant croissant = new Croissant(CroissantType.STRAWBERRY,0);

        assertEquals("CroissantStrawberry", croissant.getName());
    }

    @Test
    void testStrawberryHeal() {
        Croissant croissant = new Croissant(CroissantType.STRAWBERRY,0);
        TestCookie cookie = new TestCookie();

        croissant.interact(cookie);

        assertEquals(20,cookie.healed);
    }

}