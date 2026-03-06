package Pets;

import Main.Pets.SamplePet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SamplePetTest {

    @Test
    void testConstructorSetsBasicData() {

        SamplePet pet = new SamplePet(
                4,
                "Lock",
                "Locked Pet",
                "UnSelect_Lock"
        );

        assertEquals(4, pet.getId());
        assertEquals("Lock", pet.getName());
        assertEquals("Locked Pet", pet.getDescription());
    }

    @Test
    void testImagesAreAssigned() {

        SamplePet pet = new SamplePet(
                1,
                "TestPet",
                "test",
                "UnSelect_Lock"
        );

        assertNotNull(pet.getView());
        assertNotNull(pet.getViewImage());
        assertNotNull(pet.getBackGroundImage());
        assertNotNull(pet.getButtonImage());
    }

    @Test
    void testBGidGenerated() {

        SamplePet pet = new SamplePet(
                7,
                "Pet",
                "desc",
                "UnSelect_Lock"
        );

        assertEquals("BG7", pet.getBGid());
    }
}