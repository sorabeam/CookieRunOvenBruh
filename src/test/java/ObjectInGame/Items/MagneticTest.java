package ObjectInGame.Items;

import Main.Cookies.Cookie;
import Main.ObjectInGame.Items.Magnetic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagneticTest {

    static class TestCookie extends Cookie {

        boolean magneticCalled = false;

        public TestCookie() {
            super(1,"Test",100,"Test Cookie");
        }

        @Override
        public void useSkill() {}

        @Override
        public void setMagnetic(boolean magnetic) {
            super.setMagnetic(magnetic);
            if(magnetic){
                magneticCalled = true;
            }
        }
    }

    @Test
    void testName() {
        Magnetic magnetic = new Magnetic();
        assertEquals("Magnetic", magnetic.getName());
    }

    @Test
    void testInteractSetsMagnetic() throws InterruptedException {
        Magnetic magnetic = new Magnetic();
        magnetic.setActiveTime(50); // ลดเวลาจะได้ไม่ต้องรอนาน

        TestCookie cookie = new TestCookie();

        magnetic.interact(cookie);

        Thread.sleep(10); // รอ thread เริ่มทำงาน

        assertTrue(cookie.magneticCalled);
    }

    @Test
    void testGetActiveTime() {
        Magnetic magnetic = new Magnetic();
        magnetic.setActiveTime(5000);

        assertEquals(5000, magnetic.getActiveTime());
    }
}