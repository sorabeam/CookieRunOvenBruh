package GameLogic;

public class GameLogic {
    private static int score;
    private static int bestScore;
    private static GameState gameState;
    //score

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        bestScore = Math.max(score, bestScore);
        GameLogic.score = score;
    }

    public static int getBestScore() {
        return GameLogic.bestScore;
    }

    public static void setBestScore(int bestScore) {
        GameLogic.bestScore = bestScore;
    }

    public static void addScore(int val) {
        if(gameState!=GameState.INGAME) return;
        score += val;
        bestScore = Math.max(score, bestScore);
    }

    //game state

    public static GameState getGameState() {
        return gameState;
    }

    public static void setGameState(GameState gameState) {
        GameLogic.gameState = gameState;
    }

    public static void startGame() {
        score = 0;
        gameState = GameState.GAMEOVER;
    }

}
