package Pets;

import Main.Pets.Pet;
import Main.ObjectInGame.Items.ItemView;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    private Pet pet;

    // dummy pet สำหรับ test
    static class TestPet extends Pet {

        public TestPet() {
            super(1, "TestPet", "test");
        }

        @Override
        public void useSkill() {
            // empty
        }
    }

    @BeforeEach
    void setup() {
        pet = new TestPet();

        ImageView view = new ImageView();
        view.setLayoutX(0);
        view.setLayoutY(0);

        pet.setView(view);
        pet.setTargetPos(100, 0);
        pet.setSpeed(100);
    }

    @Test
    void testMovementUpdate() {

        pet.update(1.0);

        assertTrue(pet.getView().getLayoutX() > 0);
    }

    @Test
    void testHasArrived() {

        pet.getView().setLayoutX(100);
        pet.getView().setLayoutY(0);

        assertTrue(pet.hasArrived());
    }

    @Test
    void testSkillState() {

        pet.setSkillReady(true);
        pet.setUsingSkill(true);

        assertTrue(pet.isSkillReady());
        assertTrue(pet.isUsingSkill());
    }

    @Test
    void testIndexRotation() {

        ArrayList<Supplier<ItemView>> list = new ArrayList<>();

        list.add(() -> null);
        list.add(() -> null);

        pet.setSpawnItemList(list);

        pet.updateIndex();
        int first = pet.getSpawnItemList().size();

        pet.updateIndex();

        assertEquals(2, first);
    }

    @Test
    void testSpeedSetter() {

        pet.setSpeed(200);

        assertEquals(200, pet.getSpeed());
    }
}