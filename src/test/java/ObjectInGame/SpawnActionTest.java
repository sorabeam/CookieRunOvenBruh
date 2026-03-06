package ObjectInGame;

import Main.ObjectInGame.SpawnAction;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpawnActionTest {

    @Test
    void testConstructor() {

        SpawnAction action = new SpawnAction(
                SpawnAction.Type.ITEM,
                500,
                "Coin",
                200
        );

        assertEquals(SpawnAction.Type.ITEM, action.type);
        assertEquals(500, action.delay);
        assertEquals("Coin", action.name);
        assertEquals(200, action.height);
    }

    @Test
    void testJellyFactory() {

        SpawnAction jelly = SpawnAction.jelly(300, 150, 2);

        assertEquals(SpawnAction.Type.JELLY, jelly.type);
        assertEquals(300, jelly.delay);
        assertEquals("Jelly2", jelly.name);
        assertEquals(150, jelly.height);
    }

    @Test
    void testObstacleFactory() {

        SpawnAction obs = SpawnAction.obstacle(400, 250, 1, 3);

        assertEquals(SpawnAction.Type.OBSTACLE, obs.type);
        assertEquals("Obs_1_3", obs.name);
        assertEquals(400, obs.delay);
        assertEquals(250, obs.height);
    }

    @Test
    void testItemFactory() {

        SpawnAction item = SpawnAction.item(200, 100, "SpeedBoost");

        assertEquals(SpawnAction.Type.ITEM, item.type);
        assertEquals("SpeedBoost", item.name);
        assertEquals(200, item.delay);
        assertEquals(100, item.height);
    }

    @Test
    void testJellyWaveSize() {

        List<SpawnAction> wave = SpawnAction.jellyWave(100, 1, 100, 200, 300);

        assertEquals(3, wave.size());
    }

    @Test
    void testJellyWaveFirstDelaySpecial() {

        List<SpawnAction> wave = SpawnAction.jellyWave(100, 1, 100, 200);

        assertEquals(1_000_000_000L, wave.get(0).delay);
        assertEquals(100, wave.get(1).delay);
    }

    @Test
    void testCombineMixedInputs() {

        SpawnAction a = SpawnAction.jelly(100, 200, 1);
        SpawnAction b = SpawnAction.item(50, 100, "Coin");

        List<SpawnAction> combined =
                SpawnAction.combine(a, List.of(b));

        assertEquals(2, combined.size());
        assertEquals(a, combined.get(0));
        assertEquals(b, combined.get(1));
    }
}