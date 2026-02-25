package supakorn.Animation;

public enum AnimationType {
    IDLE(0),
    RUN(1),
    JUMP_UP(2),
    JUMP_DOWN(3),
    DOUBLE_JUMP(4),
    DIE(5),
    SLIDE(6),
    TAKE_DAMAGE(7),
    SKILL(8);

    private final int row;
    AnimationType(int row) {
        this.row = row;
    }

    public int getRow() {
        return row;
    }
}