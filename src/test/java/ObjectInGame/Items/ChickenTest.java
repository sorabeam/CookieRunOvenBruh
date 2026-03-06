package ObjectInGame.Items;

import Main.ObjectInGame.Items.Chicken;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ChickenTest {

    @Test
    void testName() {
        Chicken chicken = new Chicken();

        assertEquals("Chicken", chicken.getName());
    }
}