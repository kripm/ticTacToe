package myself;

public enum GameState {
    UNFINISHED,
    DRAW,
    O_WIN,
    X_WIN;

    void check (GameState gameState) {
        switch (gameState) {
            case X_WIN:
                System.out.println("X wins");
                break;
            case O_WIN:
                System.out.println("O wins");
                break;
            case DRAW:
                System.out.println("Draw");
                break;
        }
    }
}
