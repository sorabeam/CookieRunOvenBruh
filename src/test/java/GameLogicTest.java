import static org.junit.jupiter.api.Assertions.*;

import Main.GameLogic.GameLogic;
import Main.GameLogic.GameState;
import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameLogicTest {

    @BeforeEach
    void resetScore() {
        GameLogic.setScore(0);
    }

    @Test
    void testSetScore() {
        GameLogic.setScore(100);
        assertEquals(100, GameLogic.getScore());
    }

    @Test
    void testAddScore() {
        GameLogic.setScore(0);
        GameLogic.addScore(50);

        assertEquals(50, GameLogic.getScore());
    }

    @Test
    void testAddScoreNegativeIgnored() {
        GameLogic.setScore(100);
        GameLogic.addScore(-20);

        assertEquals(100, GameLogic.getScore());
    }

    @Test
    void testMapCannotBeLessThanOne() {
        GameLogic.setMap(-5);

        assertEquals(1, GameLogic.getMap());
    }

    @Test
    void testSetMap() {
        GameLogic.setMap(3);

        assertEquals(3, GameLogic.getMap());
    }

    @Test
    void testMusicVolume() {
        GameLogic.setMusicVolume(80);

        assertEquals(80, GameLogic.getMusicVolume());
    }

    @Test
    void testSFXVolume() {
        GameLogic.setSFXVolume(40);

        assertEquals(40, GameLogic.getSFXVolume());
    }

    @Test
    void testGameStateChange() {
        GameLogic.setGameState(GameState.IN_GAME);

        assertEquals(GameState.IN_GAME, GameLogic.getGameState());
    }
}