package ObjectInGame;

import Main.Cookies.Cookie;
import Main.ObjectInGame.Spawner;
import javafx.scene.layout.Pane;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpawnerTest {

    private Pane pane;
    private Cookie cookie;
    private Spawner spawner;

    @BeforeEach
    void setup() {
        pane = new Pane();

        cookie = new Cookie(1, "Test", 100, "Test Cookie") {
            @Override
            public void useSkill() {}
        };

        spawner = new Spawner(pane, 800, 600, cookie);
    }

    @Test
    void testDefaultSpeed() {
        assertEquals(Spawner.getDefaultSpeed(), Spawner.getSpeed());
    }

    @Test
    void testSetSpeed() {
        Spawner.setSpeed(-500);
        assertEquals(-500, Spawner.getSpeed());
    }

    @Test
    void testResetSpeed() {
        Spawner.setSpeed(-100);
        Spawner.resetSpeed();
        assertEquals(Spawner.getDefaultSpeed(), Spawner.getSpeed());
    }

    @Test
    void testIngredientRainSpawnCount() {
        int before = pane.getChildren().size();

        spawner.spawnIngredientRain();

        int after = pane.getChildren().size();

        assertEquals(before + 20, after);
    }
}