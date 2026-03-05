package Main.Button;

import Main.GameLogic.GameLogic;
import Main.GameLogic.GameState;
import javafx.scene.image.ImageView;

import static Main.GameLogic.GameLogic.getStage;

public class NavigationButton extends BaseButton{


    private final GameState switchState;

    public NavigationButton(ImageView Img, GameState switchState) {
        super(Img);
        this.switchState = switchState;
    }

    @Override
    public void handleClick() {
        super.handleClick();

        if(switchState==null) return;

        getStage().setResizable(true);
        GameLogic.setGameState(switchState);
        System.out.println(switchState);
    }

    public GameState getSwitchState() {
        return switchState;
    }


}
