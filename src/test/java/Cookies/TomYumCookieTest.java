package Cookies;

import Main.Cookies.TomYumCookie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TomYumCookieTest {

    @Test
    void testInitialRainState() {
        TomYumCookie cookie = new TomYumCookie();
        assertFalse(cookie.isSkillReady());
    }

    @Test
    void testUseSkillMakesRainReady() {
        TomYumCookie cookie = new TomYumCookie();

        cookie.useSkill();

        assertTrue(cookie.isSkillReady());
    }

    @Test
    void testConsumeRain() {
        TomYumCookie cookie = new TomYumCookie();

        cookie.useSkill();
        cookie.consumeRain();

        assertFalse(cookie.isSkillReady());
    }

    @Test
    void testCooldownProgress() {
        TomYumCookie cookie = new TomYumCookie();

        cookie.setCooldownTimer(7.5);

        double progress = cookie.getCooldownProgress();

        assertEquals(0.5, progress, 0.01);
    }

    @Test
    void testUpdateSkillTriggersUseSkill() {
        TomYumCookie cookie = new TomYumCookie();

        cookie.updateSkill(15);

        assertTrue(cookie.isSkillReady());
    }
}