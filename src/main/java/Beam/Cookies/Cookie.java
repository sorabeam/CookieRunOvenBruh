package Beam.Cookies;

import Beam.Animation.Animate;
import Beam.Animation.AnimationType;
import Beam.Asset;
import Beam.Media.MediaPlayer;
import GameLogic.GameLogic;
import GameLogic.GameState;
import Pors.ObjectInGame.Spawner;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Cookie {

    protected Animate cookie;
    protected String imgURL;

    protected boolean invincible = false;
    protected double invincibleTimer = 0;
    protected double invincibleDuration = 0;

    protected Pane gameLayer;
    protected Rectangle hitBox;

    private DoubleProperty hitboxRatio = new SimpleDoubleProperty(0.7);
    private final double slideHitboxRatio = 0.3;

    private double velocity;
    private int jumpCount;

    private boolean onGround;

    protected boolean hasCooldown = false;

    protected double cooldownTimer;
    protected double skillCooldown;
    protected int skillCounter;

    private boolean isMagnetic;
    private boolean isSpeeding;

    protected double damageTimer = 0;

    private boolean isDead = false;
    private double deathTimer = 0;

    int id;
    int maxHp;
    int hp;
    int score = 0;
    double skillTimer=0;

    String boxImageId;
    String skillImageId;
    String name;
    String description;

    Image profileImg;

    public Cookie(int id,String name,int hp, String description) {

        this.id = id;
        this.hp = hp;
        this.maxHp = hp;
        boxImageId = "B" + id;
        skillImageId = "S" + id;
        this.name = name;
        this.description = description;

    }

    public int get_Id() { return id; }
    public int get_Hp() { return hp; }
    public String get_Bid() { return boxImageId; }
    public String get_Sid() { return skillImageId; }
    public String get_Name() { return name; }
    public String get_Desc() { return description; }
    public int get_Score() {return score;}

    public void setScore(int score) {
        this.score = score;
    }

    public abstract void useSkill();

    public void takeDamage(int damage){
        if(isDead) return;
        hp -= damage;
        GameLogic.getHpBar().updateHpBar(GameLogic.getCurrentGameScene().getDeltatime());
        System.out.println("Cookie take " + damage + " damage");

        System.out.println(hp);
        MediaPlayer.getInstance().playSFX("Hit");

        cookie.changeAnimationState(AnimationType.TAKE_DAMAGE);
        damageTimer = 0.5;
        setInvincible(1);


        if(hp <= 0){
            die();
        }
    }

    public void takeDamageByTime(){
        hp -= 2;
        GameLogic.getHpBar().updateHpBar(GameLogic.getCurrentGameScene().getDeltatime());

        if(hp <= 0){
            die();
        }
    }

    public void setHp(int hp) {
        this.hp = Math.min(maxHp,hp);
    }

    public void heal(int healunit){

        GameLogic.getHpBar().updateHpBar(GameLogic.getCurrentGameScene().getDeltatime());
        hp = Math.min(maxHp,hp + healunit);;
        System.out.println("Cookie get " + healunit + " heathPoint");
    }

    public void die(){
        if(isDead) return;

        isDead = true;
        deathTimer = 3;

        cookie.changeAnimationState(AnimationType.DIE);

        velocity = -5;
        GameLogic.getCurrentGameScene().stopEnvironment();
    }

    protected void playSkill(double duration) {

        skillTimer = duration;
        cookie.changeAnimationState(AnimationType.SKILL);

    }

    public Animate createCookie(){

        jumpCount=2;

        cookie = new Animate(
                Asset.getImage(imgURL),
                6,4,1,1,
                5,4,1,1,
                5,
                400,400);

        hitBox = new Rectangle();
        hitBox.widthProperty().bind(cookie.fitWidthProperty().multiply(0.4));
        hitBox.heightProperty().bind(
                cookie.fitHeightProperty().multiply(hitboxRatio)
        );

        //hitBox.setStroke(Color.RED);
        hitBox.setFill(Color.TRANSPARENT);

        hitBox.layoutXProperty().bind(cookie.layoutXProperty().add(cookie.fitWidthProperty().multiply(0.2)).add(15));
        hitBox.layoutYProperty().bind(
                cookie.layoutYProperty().add(
                        cookie.fitHeightProperty().subtract(hitBox.heightProperty())
                                .subtract(20)
                )
        );

        return cookie;
    }

    public boolean isHasCooldown() {
        return hasCooldown;
    }

    public void setHasCooldown(boolean hasCooldown) {
        this.hasCooldown = hasCooldown;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public Image getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(Image profileImg) {
        this.profileImg = profileImg;
    }

    public void update(double deltaTime){

        if(isDead){

            deathTimer -= deltaTime;

            if(deathTimer <= 0){
                GameLogic.setGameState(GameState.GAMEOVER);
            }

            return;
        }

        boolean usingSkill = skillTimer > 0;

        if (skillTimer > 0) {

            skillTimer -= deltaTime;

            if (skillTimer <= 0) {
                skillTimer = 0;
            }
        }

        double scale = deltaTime * 60;

        if (damageTimer > 0) {
            damageTimer -= deltaTime;
        }

        // tuning
        double gravity = 0.4;
        velocity += gravity * scale;
        double maxFallSpeed = 12;
        velocity = Math.min(velocity, maxFallSpeed);

        cookie.setLayoutY(cookie.getLayoutY() + velocity * scale);

        if (!onGround && velocity > 0 && !cookie.getAnimationState().equals(AnimationType.DOUBLE_JUMP)) {

            if (!cookie.getAnimationState().equals(AnimationType.JUMP_DOWN)) {
                cookie.changeAnimationState(AnimationType.JUMP_DOWN);
            }
        }

        double feet = cookie.getLayoutY() + cookie.getBoundsInParent().getHeight();

        double groundY = gameLayer.getHeight() - 150;

        if (feet > groundY) {

            cookie.setLayoutY(groundY - cookie.getBoundsInParent().getHeight());
            velocity = 0;

            jumpCount = 0;
            onGround = true;

            if (!usingSkill && damageTimer <= 0) {
                if (cookie.getAnimationState().equals(AnimationType.SLIDE)) {
                    cookie.changeAnimationState(AnimationType.SLIDE);
                } else {
                    cookie.changeAnimationState(AnimationType.RUN);
                }
            }
        }

        if(invincible){
            invincibleTimer += deltaTime;

            if((int)(invincibleTimer * 10) % 2 == 0){
                cookie.setOpacity(0.3);
            } else {
                cookie.setOpacity(0.7);
            }

            if(invincibleTimer >= invincibleDuration){
                invincible = false;
                cookie.setOpacity(1);
            }
        }
    }

    public void jump() {

        if(isDead) return;

        if (jumpCount >= getMaxJump()) return;

        if (jumpCount == 0) {
            cookie.changeAnimationState(AnimationType.JUMP_UP);
        } else {
            cookie.changeAnimationState(AnimationType.DOUBLE_JUMP);
        }

        MediaPlayer.getInstance().playSFX("JUMP");
        setHitbox();
        velocity = -13;
        jumpCount++;
        onGround = false;
    }

    public void slide() {

        if(isDead) return;

        setHitbox();

        if ( isPerformingSkill() || !onGround || cookie.getAnimationState().equals(AnimationType.SLIDE)) { return; }

        MediaPlayer.getInstance().playSFX("SLIDE");
        cookie.changeAnimationState(AnimationType.SLIDE);
    }

    public void upFromSlide() {


        if ( isPerformingSkill() || !onGround) {
            setHitbox();
            return;
        }
        cookie.changeAnimationState(AnimationType.RUN);
        setHitbox();

    }

    public void setHitbox(){
        if (cookie.getAnimationState().equals(AnimationType.SLIDE)){
            hitboxRatio.set(slideHitboxRatio);
        }
        else {
            hitboxRatio.set(0.7);
        }
    }

    public void setInvincible(double duration){
        invincible = true;
        invincibleDuration = duration;
        invincibleTimer = 0;
    }

    public void reset() {
        setMagnetic(false);
        setSpeeding(false);
        Spawner.resetSpeed();
    }

    public double getCooldownTimer() {
        return cooldownTimer;
    }

    public void setCooldownTimer(double cooldownTimer) {
        this.cooldownTimer = cooldownTimer;
    }

    public double getSkillCooldown() {
        return skillCooldown;
    }

    public void setSkillCooldown(double skillCooldown) {
        this.skillCooldown = skillCooldown;
    }

    public int getSkillCounter() {
        return skillCounter;
    }

    public void setSkillCounter(int skillCounter) {
        this.skillCounter = skillCounter;
    }

    public boolean isInvincible(){
        return invincible;
    }

    private boolean isPerformingSkill() {
        return cookie.getAnimationState().equals(AnimationType.SKILL);
    }

    protected Pane getParentLayer() {
        return gameLayer;
    }
    public void setGameLayer(Pane layer) {
        this.gameLayer = layer;
    }
    protected int getMaxJump() {
        return 2;
    }
    public Rectangle getHitBox() {
        return hitBox;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public double getCooldownProgress(){
        return 0;
    }

    public Animate getCookie() {
        return cookie;
    }

    public void setCookie(Animate cookie) {
        this.cookie = cookie;
    }

    public boolean isOnGround() {
        return onGround;
    }

    public boolean isMagnetic() {
        return isMagnetic;
    }

    public void setMagnetic(boolean magnetic) {
        isMagnetic = magnetic;
    }

    public void setSpeeding(boolean speeding) {
        isSpeeding = speeding;
    }

    public boolean isSpeeding() {
        return isSpeeding;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }
}
