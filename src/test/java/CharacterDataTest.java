import Main.CharacterData;
import Main.Cookies.Cookie;
import Main.Pets.Pet;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterDataTest {

    @BeforeAll
    static void initJavaFX() {
        new JFXPanel();
    }

    @BeforeEach
    void resetDefaults() {
        CharacterData.setCurrent_Cookie(CharacterData.BOBA_COOKIE);
        CharacterData.setCurrent_Pet(CharacterData.SALAD);
    }

    @Test
    void testDefaultCookie() {
        assertEquals(CharacterData.BOBA_COOKIE, CharacterData.getCurrent_Cookie());
    }

    @Test
    void testDefaultPet() {
        assertEquals(CharacterData.SALAD, CharacterData.getCurrent_Pet());
    }

    @Test
    void testSetCurrentCookie() {
        CharacterData.setCurrent_Cookie(CharacterData.CROSSIANT_COOKIE);

        assertEquals(CharacterData.CROSSIANT_COOKIE,
                CharacterData.getCurrent_Cookie());
    }

    @Test
    void testSetCurrentPet() {
        CharacterData.setCurrent_Pet(CharacterData.MOJI);

        assertEquals(CharacterData.MOJI,
                CharacterData.getCurrent_Pet());
    }

    @Test
    void testSwitchCharacter() {

        CharacterData.setCurrent_Cookie(CharacterData.TOMYUM_COOKIE);
        CharacterData.setCurrent_Pet(CharacterData.CHILLY);

        Cookie cookie = CharacterData.getCurrent_Cookie();
        Pet pet = CharacterData.getCurrent_Pet();

        assertEquals(CharacterData.TOMYUM_COOKIE, cookie);
        assertEquals(CharacterData.CHILLY, pet);
    }
}