package supakorn.Animation;

import javafx.animation.AnimationTimer;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Animate extends ImageView implements Animatable{

    protected int currentRow = 0;
    protected int currentFrame = 0;
    protected long lastTime = 0;
    protected double accumulator = 0;

    private int maxFPRIdel;
    private int maxFPRRun;                             //
    private int maxFPRJump;
    private int maxFPRDoubleJump;
    private int maxFPRDie;
    private int maxFPRSlide;
    private int maxFPRTakeDamage;
    private int maxFPRSkill;

    private int maxFPR;// equal to

    private int frameWidth;                         //Test On 120px
    private int frameHeight;                        //Test On 139px
    private double frameDuration = 0.05;
    private int[] maxFPRType = new int[8];

    private ObjectProperty<AnimationType> state;

    public Animate(Image image,int idle,int run,int jump,int doubleJump,int die,int slide,int takeDamage,
                   int skill,int frameWidth,int frameHeight){

        super(image);

        this.maxFPRIdel = Math.max(0,idle);
        this.maxFPRRun = Math.max(0,run);
        this.maxFPRJump = Math.max(0,jump);
        this.maxFPRDoubleJump = Math.max(0,doubleJump);
        this.maxFPRDie = Math.max(0,die);
        this.maxFPRSlide = Math.max(0,slide);
        this.maxFPRTakeDamage = Math.max(0,takeDamage);
        this.maxFPRSkill = Math.max(0,skill);

        maxFPRType[0] = this.maxFPRIdel;
        maxFPRType[1] = this.maxFPRRun;
        maxFPRType[2] = this.maxFPRJump;
        maxFPRType[3] = this.maxFPRDoubleJump;
        maxFPRType[4] = this.maxFPRDie;
        maxFPRType[5] = this.maxFPRSlide;
        maxFPRType[6] = this.maxFPRTakeDamage;
        maxFPRType[7] = this.maxFPRSkill;

        this.maxFPR = this.maxFPRIdel;

        this.frameWidth = Math.max(0,frameWidth);
        this.frameHeight = Math.max(0,frameHeight);

        state = new SimpleObjectProperty<>(AnimationType.IDLE);

        state.addListener((obs,
              oldValue, newValue) -> {
            currentRow = newValue.getRow();
            currentFrame = 0;
            maxFPR = maxFPRType[newValue.getRow()];
        });

        DrawAnimation();
    }

    public void update(double deltaTime) {

        accumulator += deltaTime;

        if (accumulator >= frameDuration) {
            accumulator -= frameDuration;   // ดีกว่า reset เป็น 0

            currentFrame++;

            if (currentFrame >= maxFPR) {
                currentFrame = 0;
            }

            DrawAnimation();
        }
    }

    @Override
    public void DrawAnimation() {

        setViewport(new Rectangle2D(currentFrame * frameWidth,
                currentRow * frameHeight,frameWidth, frameHeight));

    }

    public void changeAnimationState(AnimationType state) {
        this.state.set(state);

    }

    public AnimationType getAnimationState() {
        return state.get();
    }

    public void setFrameDuration(int fd){
        this.frameDuration = fd;
    }

}
