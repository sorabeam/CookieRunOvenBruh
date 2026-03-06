package ObjectInGame.Jelly;

import Main.ObjectInGame.Jelly.BaseJelly;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseJellyTest {

    @Test
    void testJelly2Score() {
        BaseJelly jelly = new BaseJelly("Jelly2");
        assertEquals(200, jelly.getScore());
    }

    @Test
    void testNormalJellyScore() {
        BaseJelly jelly = new BaseJelly("Jelly1");
        assertEquals(100, jelly.getScore());
    }

    @Test
    void testSetName() {
        BaseJelly jelly = new BaseJelly("Jelly1");
        jelly.setName("NewJelly");

        assertEquals("NewJelly", jelly.getName());
    }

    @Test
    void testSetScore() {
        BaseJelly jelly = new BaseJelly("Jelly1");
        jelly.setScore(500);

        assertEquals(500, jelly.getScore());
    }
}