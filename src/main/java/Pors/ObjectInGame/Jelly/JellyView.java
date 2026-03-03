package Pors.ObjectInGame.Jelly;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class JellyView extends ImageView {

    private BaseJelly jelly;
    private double vx;
    private double vy;

    public JellyView(BaseJelly jelly, double vx, double vy) {
        this.jelly = jelly;
        this.vx = vx;
        this.vy = vy;

        setImage(new Image("/Image/Jelly/" + jelly.getName() + ".png"));
        if(Objects.equals(jelly.getName(), "Jelly1"))
        {
            setFitWidth(50);
            setFitHeight(50);
        }
        else
        {
            setFitWidth(60);
            setFitHeight(60);
        }
    }

    public void update(double deltaTime) {
        setTranslateX(getTranslateX() + vx * deltaTime);
        setTranslateY(getTranslateY() + vy * deltaTime);
    }

    public int getScore() {
        return jelly.getScore();
    }

    public BaseJelly getJelly() {
        return jelly;
    }
}