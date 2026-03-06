package ObjectInGame.Obstacle;

import Main.Cookies.Cookie;
import Main.ObjectInGame.Obstacle.BaseObstacle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseObstacleTest {

    static class TestCookie extends Cookie {

        public TestCookie() {
            super(1,"Test",100,"Test Cookie");
        }

        @Override
        public void useSkill() {}
    }

    @Test
    void testInteractShouldDamageCookie() {
        TestCookie cookie = new TestCookie();
        cookie.setHp(100);

        BaseObstacle obstacle = new BaseObstacle("Spike");
        obstacle.setDamage(40);

        obstacle.interact(cookie);

        assertEquals(60, cookie.get_Hp());
    }

    @Test
    void testGetName() {
        BaseObstacle obstacle = new BaseObstacle("Spike");
        assertEquals("Spike", obstacle.getName());
    }

    @Test
    void testSetDamage() {
        BaseObstacle obstacle = new BaseObstacle("Spike");
        obstacle.setDamage(20);

        assertEquals(20, obstacle.getDamage());
    }
}