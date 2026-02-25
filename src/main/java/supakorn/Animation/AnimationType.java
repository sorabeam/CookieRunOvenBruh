package supakorn.Animation;

public enum AnimationType {
    IDLE(0),
    RUN(1),
    JUMP(2),
    DOUBLE_JUMP(3),
    DIE(4),
    SLIDE(5),
    TAKE_DAMAGE(6),
    SKILL(7);

    private final int row;
    AnimationType(int row) {
        this.row = row;
    }

    public int getRow() {
        return row;
    }
}