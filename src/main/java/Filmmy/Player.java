package Filmmy;

import javafx.scene.image.Image;
import supakorn.Animation.Animate;
import supakorn.Animation.AnimationType;

public abstract class Player extends Animate {

    private double velocity;
    private int jumpCount;

    private boolean onGround;
    private boolean isSliding;
    private boolean isDoubleJumping;

    private double skillTimer;

    // tuning
    private final double gravity = 0.4;
    private final double jumpSpeed = -13;
    private final double maxFallSpeed = 12;

    int id;
    int hp;
    int score = 0;

    String Bid;
    String Sid;
    String name;
    String desc;

    public Player(Image image,
                  int idle, int run, int jumpUp, int jumpDown, int doubleJump,
                  int die, int slide, int takeDamage, int skill,
                  int frameWidth, int frameHeight,
                  int id, String name, int hp, String desc) {

        super(image, idle, run, jumpUp, jumpDown, doubleJump,
                die, slide, takeDamage, skill,
                frameWidth, frameHeight);

        this.id = id;
        this.hp = hp;

        Bid = "B" + id;
        Sid = "S" + id;

        this.name = name;
        this.desc = desc;
    }

    public void update(double dt, double groundY) {

        boolean usingSkill = skillTimer > 0;

        if (skillTimer > 0) {

            skillTimer -= dt;

            if (skillTimer <= 0) {
                skillTimer = 0;
            }
        }

        double scale = dt * 60;

        // ---------- Physics ----------
        velocity += gravity * scale;
        velocity = Math.min(velocity, maxFallSpeed);

        setLayoutY(getLayoutY() + velocity * scale);

        double feet = getLayoutY() + getBoundsInParent().getHeight();

        // ---------- Ground Check ----------
        if (feet > groundY) {

            setLayoutY(groundY - getBoundsInParent().getHeight());
            velocity = 0;

            if (!onGround) {
                jumpCount = 0;
            }

            onGround = true;
            isDoubleJumping = false;

            if (!usingSkill) {

                if (!isSliding) {
                    changeAnimationState(AnimationType.RUN);
                } else {
                    changeAnimationState(AnimationType.SLIDE);
                }
            }

        } else {

            onGround = false;

            if (!isSliding && !isDoubleJumping && !usingSkill) {

                if (velocity < 0) {
                    changeAnimationState(AnimationType.JUMP_UP);
                } else {
                    changeAnimationState(AnimationType.JUMP_DOWN);
                }
            }
        }

        onUpdate(dt);
    }

    public void jump() {

        if (jumpCount >= getMaxJump()) return;

        if (jumpCount == 0) {
            changeAnimationState(AnimationType.JUMP_UP);
        } else {
            changeAnimationState(AnimationType.DOUBLE_JUMP);
            isDoubleJumping = true;
        }

        velocity = jumpSpeed;
        jumpCount++;
        onGround = false;
    }

    public void slide(boolean sliding) {

        if (isSliding == sliding) return;

        isSliding = sliding;

        if (!isPerformingSkill()) {

            if (sliding) {
                changeAnimationState(AnimationType.SLIDE);
            } else if (onGround) {
                changeAnimationState(AnimationType.RUN);
            }
        }
    }

    // ---------- Skill Priority ----------
    private boolean isPerformingSkill() {
        return getAnimationState() == AnimationType.SKILL;
    }

    protected void playSkill(double duration) {

        skillTimer = duration;

        changeAnimationState(AnimationType.SKILL);
    }

    // ---------- Jump Config ----------
    protected int getMaxJump() {
        return 2;
    }

    // ---------- Hook Method ----------
    protected void onUpdate(double dt) {
        // default → do nothing
    }

    // ---------- Getters ----------
    public int get_Id() { return id; }
    public int get_Hp() { return hp; }
    public String get_Bid() { return Bid; }
    public String get_Sid() { return Sid; }
    public String get_Name() { return name; }
    public String get_Desc() { return desc; }
    public int get_Score() { return score; }

    // ---------- Stats ----------
    public void setScore(int score) {
        this.score = score;
    }

    public void takeDamage(int damage) {
        hp -= damage;
    }

    public void heal(int healUnit) {
        hp += healUnit;
    }
}