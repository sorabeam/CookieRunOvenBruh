package ObjectInGame.Items;

import Main.Cookies.Cookie;
import Main.ObjectInGame.Items.SpeedBoost;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpeedBoostTest {

    static class TestCookie extends Cookie {

        boolean invincibleCalled = false;
        boolean speedingCalled = false;

        public TestCookie() {
            super(0,"Test",100,"Test Cookie");
        }

        @Override
        public void useSkill() {}

        @Override
        public void setInvincible(double duration) {
            invincibleCalled = true;
        }

        @Override
        public void setSpeeding(boolean speeding) {
            if(speeding) speedingCalled = true;
        }
    }

    @Test
    void testName() {
        SpeedBoost boost = new SpeedBoost();
        assertEquals("ChillyBoost", boost.getName());
    }

    @Test
    void testSpeedStat() {
        SpeedBoost boost = new SpeedBoost();
        assertEquals(3, boost.getSpeedStat());
    }

    @Test
    void testInteractInvincible() {
        SpeedBoost boost = new SpeedBoost();
        TestCookie cookie = new TestCookie();

        boost.interact(cookie);

        assertTrue(cookie.invincibleCalled);
    }

    @Test
    void testInteractSpeeding() throws InterruptedException {
        SpeedBoost boost = new SpeedBoost();
        TestCookie cookie = new TestCookie();

        boost.interact(cookie);

        Thread.sleep(50); // รอ thread เริ่ม

        assertTrue(cookie.speedingCalled);
    }
}