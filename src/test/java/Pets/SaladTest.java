package Pets;

import Main.Pets.Salad;
import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaladTest {

    @BeforeAll
    static void initJavaFX() {
        new JFXPanel(); // start JavaFX runtime
    }

    @Test
    void testConstructorBasicData() {

        Salad salad = new Salad();

        assertEquals(3, salad.getId());
        assertEquals("Salad", salad.getName());
        assertEquals(5000, salad.getCooldownTime());
        assertTrue(salad.isSkillReady());
        assertFalse(salad.isUsingSkill());
    }

    @Test
    void testSpawnItemListSize() {

        Salad salad = new Salad();

        assertEquals(3, salad.getSpawnItemList().size());
    }

    @Test
    void testProbabilityValues() {

        Salad salad = new Salad();

        assertEquals(3, salad.getProbability().size());

        double sum = salad.getProbability()
                .stream()
                .mapToDouble(Double::doubleValue)
                .sum();

        assertEquals(1.0, sum, 0.0001);
    }

    @Test
    void testUseSkillChangesState() throws InterruptedException {

        Salad salad = new Salad();

        salad.useSkill();

        Thread.sleep(50);

        assertTrue(salad.isUsingSkill());
        assertFalse(salad.isSkillReady());
    }
}