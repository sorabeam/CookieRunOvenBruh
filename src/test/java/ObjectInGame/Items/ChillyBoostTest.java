package ObjectInGame.Items;

import Main.Cookies.Cookie;
import Main.ObjectInGame.Items.ChillyBoost;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChillyBoostTest {

    @Test
    void testName() {
        ChillyBoost boost = new ChillyBoost();
        assertEquals("ChillyBoost", boost.getName());
    }

    @Test
    void testInteractSetsInvincible() {
        ChillyBoost boost = new ChillyBoost();
        TestCookie cookie = new TestCookie();

        boost.interact(cookie);

        assertTrue(cookie.invincibleCalled);
    }

    @Test
    void testInteractSetsSpeeding() throws InterruptedException {
        ChillyBoost boost = new ChillyBoost();
        TestCookie cookie = new TestCookie();

        boost.interact(cookie);

        Thread.sleep(50); // รอ thread เริ่มทำงาน

        assertTrue(cookie.speedingCalled);
    }
}


/* ---------------- Test Cookie ---------------- */

class TestCookie extends Cookie {

    public boolean invincibleCalled = false;
    public boolean speedingCalled = false;

    public TestCookie() {
        super(0, "test", 100, "test");
    }

    @Override
    public void useSkill() {
    }

    @Override
    public void setInvincible(double duration) {
        super.setInvincible(duration);
        invincibleCalled = true;
    }

    @Override
    public void setSpeeding(boolean speeding) {
        super.setSpeeding(speeding);
        if (speeding) {
            speedingCalled = true;
        }
    }
}