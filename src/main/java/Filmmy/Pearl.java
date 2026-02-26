package Filmmy;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import supakorn.Asset;

public class Pearl extends ImageView {

    private double speed = 1000;

    public Pearl(double x, double y) {

        super(Asset.getImage("Pearl"));

        setFitWidth(40);
        setFitHeight(40);

        setLayoutX(x);
        setLayoutY(y);
    }

    public void update(double dt) {
        setLayoutX(getLayoutX() + speed * dt);
    }
}