package Main.Image;

import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import Main.Asset;

public class OutlineTextImage extends StackPane {

    public static final Font FONT_CHANGO =
            Font.loadFont(Asset.class.getResourceAsStream("/Fonts/Chango-Regular.ttf"), 30);

    public static final Font FONT_MALI =
            Font.loadFont(Asset.class.getResourceAsStream("/Fonts/Mali-Italic.ttf"), 30);

    private final Text stroke = new Text();
    private final Text fill = new Text();

    public OutlineTextImage(String text, char F, int size) {

        Font textFont;
        if(F == 'M'){
            textFont = FONT_MALI;
        } else if(F == 'C'){
            textFont = FONT_CHANGO;
        } else{
            textFont = FONT_MALI;
        }

        stroke.setText(text);
        stroke.setFont(Font.font(textFont.getFamily(), size));
        stroke.setFill(Color.TRANSPARENT);
        stroke.setStroke(Color.BLACK);
        stroke.setStrokeWidth(6);

        fill.setText(text);
        fill.setFont(Font.font(textFont.getFamily(), size));
        fill.setFill(Color.WHITE);

        setMaxHeight(20);
        getChildren().addAll(stroke, fill);
    }

    public void setText(String text){
        stroke.setText(text);
        fill.setText(text);
    }

    public void setTextAlignment(TextAlignment textAlignment){
        stroke.setTextAlignment(textAlignment);
        fill.setTextAlignment(textAlignment);
    }

    public void setDropShadow(DropShadow d) {
        stroke.setEffect(d);
    }

    public void setColor(Color c){
        fill.setFill(c);
    }

}
