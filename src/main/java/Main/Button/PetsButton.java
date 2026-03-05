package Main.Button;

import Main.Pets.Pet;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import Main.Image.OutlineTextImage;

public class PetsButton extends BaseButton{

    ImageView img;
    Image petImage, backGround;
    String name, description;
    Pet pet;
    public PetsButton(Pet pet, int txtSize, double MarginBtm) {
        super(new ImageView(pet.getButtonImage()));

        img = new ImageView(pet.getButtonImage());
        img.setFitWidth(230);
        img.setPreserveRatio(true);
        petImage = pet.getView().getImage();
        backGround = pet.getBackGroundImage();
        name = pet.getName();
        description = pet.getDescription();

        img.setFitWidth(270);

        super.setGraphic(img);

        OutlineTextImage txt = setText(name,txtSize,MarginBtm);
        FavoriteButton fav = BuildFav();
        StackPane newImg = new StackPane(fav,img,txt);
        super.setGraphic(newImg);

        this.pet = pet;
    }

    private OutlineTextImage setText(String text, int txtSize, double MarginBtm){

        OutlineTextImage txt = new OutlineTextImage(text,'M',txtSize);
        StackPane.setAlignment(txt,Pos.BOTTOM_CENTER);
        StackPane.setMargin(txt,new Insets(0,0,MarginBtm,0));

        return txt;
    }

    private FavoriteButton BuildFav(){

        FavoriteButton fav = new FavoriteButton();
        fav.setHeight(50);

        StackPane.setAlignment(fav,Pos.BOTTOM_LEFT);
        StackPane.setMargin(fav , new Insets(0,0,18,40));

        return fav;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public Image getPetImage() {
        return petImage;
    }

    public void setPetImage(Image petImage) {
        this.petImage = petImage;
    }

    public Image getBackGround() {
        return backGround;
    }

    public void setBackGround(Image backGround) {
        this.backGround = backGround;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
