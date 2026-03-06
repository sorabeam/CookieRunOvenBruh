package ObjectInGame.Items;

import Main.Cookies.Cookie;
import Main.ObjectInGame.Items.HealingPotion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HealingPotionTest {

    static class TestCookie extends Cookie {

        int healedAmount = 0;

        public TestCookie() {
            super(1,"Test",100,"Test Cookie");
        }

        @Override
        public void useSkill() {}

        @Override
        public void heal(int healunit) {
            healedAmount = healunit;
        }
    }

    @Test
    void testName() {
        HealingPotion potion = new HealingPotion();
        assertEquals("HealingPotion", potion.getName());
    }

    @Test
    void testDefaultHealingStat() {
        HealingPotion potion = new HealingPotion();
        assertEquals(20, potion.getHealingStat());
    }

    @Test
    void testInteractHealsCookie() {
        HealingPotion potion = new HealingPotion();
        TestCookie cookie = new TestCookie();

        potion.interact(cookie);

        assertEquals(20, cookie.healedAmount);
    }

    @Test
    void testSetHealingStat() {
        HealingPotion potion = new HealingPotion();
        potion.setHealingStat(50);

        assertEquals(50, potion.getHealingStat());
    }
}