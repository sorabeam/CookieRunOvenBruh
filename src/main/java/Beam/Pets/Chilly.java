package Beam.Pets;

import Beam.Asset;
import Pors.ObjectInGame.Items.ChillyBoost;
import Pors.ObjectInGame.Items.ItemView;

import java.util.ArrayList;
import java.util.Arrays;

public class Chilly extends Pet {
    public Chilly() {
        super(2, "Chilly", "Produce Speed Boost" + "\n" +
                                            "Every 30 Seconds");

        setView(Asset.createImageView("Chilly",0,480));
        setViewImage(Asset.getImage("Chilly"));
        setBackGroundImage(Asset.getImage("Selecting_Chilly"));
        setButtonImage(Asset.getImage("UnSelect_Chilly"));
        setCooldownTime(20000);
        setSkillReady(true);
        setUsingSkill(false);
        setSpeed(500);

        setSpawnItemList(
                new ArrayList<>(Arrays.asList(
                        () -> new ItemView(new ChillyBoost(), 0, 0)
                ))
        );
    }

    @Override
    public void useSkill() {
        if(!isSkillReady() || isUsingSkill()) return;
        Thread skillCooldownThread = new Thread(() -> {
            try {
                setUsingSkill(true);
                setSkillReady(false);
                Thread.sleep(getCooldownTime());
                setSkillReady(true);
                setUsingSkill(false);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        skillCooldownThread.start();
    }
}
