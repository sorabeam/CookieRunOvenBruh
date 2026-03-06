package ObjectInGame.Items;

import Main.ObjectInGame.Items.BaseItem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BaseItemTest {

    static class TestItem extends BaseItem {
        public TestItem(String name) {
            super(name);
        }

        @Override
        public void interact(Main.Cookies.Cookie player) {
            // do nothing
        }
    }

    @Test
    void testConstructor() {
        TestItem item = new TestItem("Apple");

        assertEquals("Apple", item.getName());
    }

    @Test
    void testSetName() {
        TestItem item = new TestItem("Apple");

        item.setName("Banana");

        assertEquals("Banana", item.getName());
    }
}