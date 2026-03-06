package Cookies;

import Main.Cookies.BobaCookie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BobaCookieTest {

    @Test
    void testConstructor() {
        BobaCookie cookie = new BobaCookie();

        assertEquals(1, cookie.get_Id());
        assertEquals("Boba", cookie.get_Name());
        assertEquals(150, cookie.getMaxHp());
        assertEquals(23500, cookie.get_Score());
        assertTrue(cookie.isHasCooldown());
    }

    @Test
    void testCooldownProgressHalf() {
        BobaCookie cookie = new BobaCookie();

        cookie.setCooldownTimer(5);
        cookie.setSkillCooldown(10);

        assertEquals(0.5, cookie.getCooldownProgress());
    }

    @Test
    void testCooldownProgressMax() {
        BobaCookie cookie = new BobaCookie();

        cookie.setCooldownTimer(20);
        cookie.setSkillCooldown(10);

        assertEquals(1.0, cookie.getCooldownProgress());
    }

}