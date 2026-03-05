package Main.Button;

import Main.CharacterData;
import Main.Cookies.Cookie;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CharacterButton extends BaseButton {

    private String name;
    private String description;
    private String record;
    private Image image;
    private Cookie cookie;

    public CharacterButton(ImageView imageView, String name, String description, String record, Image image, Cookie cookie) {
        super(imageView);

        this.name = name;
        this.description = description;
        this.record = record;
        this.image = image;
        this.cookie = cookie;
    }

    @Override
    public void handleClick() {
        super.handleClick();
        CharacterData.setCurrent_Cookie(cookie);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getRecord() {
        return record;
    }

    public Image getImage() {
        return image;
    }

    public Cookie getCookie() {
        return cookie;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRecord(String rarity) {
        this.record = rarity;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setCookie(Cookie cookie) {
        this.cookie = cookie;
    }
}
