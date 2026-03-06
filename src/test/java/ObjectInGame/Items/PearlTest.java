package ObjectInGame.Items;

import Main.ObjectInGame.Items.Pearl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PearlTest {

    @Test
    void testInitialPosition() {
        Pearl pearl = new Pearl(100, 200);

        assertEquals(100, pearl.getLayoutX());
        assertEquals(200, pearl.getLayoutY());
    }

    @Test
    void testSize() {
        Pearl pearl = new Pearl(0, 0);

        assertEquals(40, pearl.getFitWidth());
        assertEquals(40, pearl.getFitHeight());
    }

    @Test
    void testUpdateMovement() {
        Pearl pearl = new Pearl(0, 0);

        pearl.update(1); // 1 second

        assertEquals(1000, pearl.getLayoutX());
    }
}