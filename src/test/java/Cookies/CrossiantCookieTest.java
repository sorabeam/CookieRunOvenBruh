package Cookies;

import Main.Cookies.CrossiantCookie;
import Main.ObjectInGame.Items.CroissantType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrossiantCookieTest {

    @Test
    void testJellyCounterIncrease() {

        CrossiantCookie cookie = new CrossiantCookie();

        cookie.onJellyCollected();

        assertEquals(1, cookie.getSkillCounter());
    }

    @Test
    void testCroissantReadyAfter30Jellies() {

        CrossiantCookie cookie = new CrossiantCookie();

        for(int i=0;i<30;i++){
            cookie.onJellyCollected();
        }

        assertTrue(cookie.isCroissantReady());
        assertEquals(0, cookie.getSkillCounter());
    }

    @Test
    void testCroissantCycle() {

        CrossiantCookie cookie = new CrossiantCookie();

        assertEquals(CroissantType.ORIGINAL, cookie.consumeCroissant());
        assertEquals(CroissantType.BUTTER, cookie.consumeCroissant());
        assertEquals(CroissantType.STRAWBERRY, cookie.consumeCroissant());
        assertEquals(CroissantType.ORIGINAL, cookie.consumeCroissant());
    }
}