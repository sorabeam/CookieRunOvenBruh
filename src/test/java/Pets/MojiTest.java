package Pets;

import Main.Pets.Moji;
import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MojiTest {

    @BeforeAll
    static void initFX() {
        new JFXPanel(); // start JavaFX runtime
    }

    @Test
    void testConstructorData() {

        Moji moji = new Moji();

        assertEquals(3, moji.getId());
        assertEquals("Moji", moji.getName());
        assertEquals(20000, moji.getCooldownTime());
        assertTrue(moji.isSkillReady());
        assertFalse(moji.isUsingSkill());
    }

    @Test
    void testSpawnItemListSize() {

        Moji moji = new Moji();

        assertEquals(1, moji.getSpawnItemList().size());
    }

    @Test
    void testSpawnItemIsMochi() {

        Moji moji = new Moji();

        assertNotNull(moji.getSpawnItemList());
        assertNotNull(moji.getSpawnItemList().get(0));
    }

    @Test
    void testUseSkillChangesState() throws InterruptedException {

        Moji moji = new Moji();

        moji.useSkill();

        Thread.sleep(50);

        assertTrue(moji.isUsingSkill());
        assertFalse(moji.isSkillReady());
    }
}