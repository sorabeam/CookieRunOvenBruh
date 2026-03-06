package Pets;

import Main.Pets.Chilly;
import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChillyTest {

    @BeforeAll
    static void initFX() {
        new JFXPanel(); // start JavaFX runtime
    }

    @Test
    void testConstructorData() {

        Chilly chilly = new Chilly();

        assertEquals(2, chilly.getId());
        assertEquals("Chilly", chilly.getName());
        assertEquals(20000, chilly.getCooldownTime());

        assertTrue(chilly.isSkillReady());
        assertFalse(chilly.isUsingSkill());
    }

    @Test
    void testSpawnItemListSize() {

        Chilly chilly = new Chilly();

        assertEquals(1, chilly.getSpawnItemList().size());
    }

    @Test
    void testSpawnItemSupplierNotNull() {

        Chilly chilly = new Chilly();

        assertNotNull(chilly.getSpawnItemList().getFirst());
    }

    @Test
    void testUseSkillChangesState() throws InterruptedException {

        Chilly chilly = new Chilly();

        chilly.useSkill();

        Thread.sleep(50);

        assertTrue(chilly.isUsingSkill());
        assertFalse(chilly.isSkillReady());
    }
}