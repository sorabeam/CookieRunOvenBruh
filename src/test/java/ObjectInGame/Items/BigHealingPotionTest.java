package ObjectInGame.Items;

import Main.Cookies.Cookie;
import Main.ObjectInGame.Items.BigHealingPotion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BigHealingPotionTest {

    static class TestCookie extends Cookie {

        public TestCookie() {
            super(1,"Test",100,"Test Cookie");
        }

        @Override
        public void useSkill() {}
    }

    @Test
    void testDefaultHealingStat() {
        BigHealingPotion potion = new BigHealingPotion();

        assertEquals(50, potion.getHealingStat());
    }

    @Test
    void testSetHealingStat() {
        BigHealingPotion potion = new BigHealingPotion();

        potion.setHealingStat(80);

        assertEquals(80, potion.getHealingStat());
    }

    @Test
    void testInteractHeal() {
        BigHealingPotion potion = new BigHealingPotion();
        TestCookie cookie = new TestCookie();

        cookie.setHp(50);

        potion.interact(cookie);

        assertEquals(100, cookie.get_Hp()); // heal 50 แต่ maxHp = 100
    }
}