package myself.game;

public class Board {
    private static final char[] gameBoard = new char[9];
    private static int turn = 1;
    private static GameState gameState = GameState.UNFINISHED;

    private Board() {
        throw new IllegalStateException("Utility class");
    }

    public static void start() {
        turn = 1;
        gameState = GameState.UNFINISHED;
        createNew();
    }

    private static void createNew() {
        for (int i = 0; i < 9; i++) {
            gameBoard[i] = (' ');
        }
    }

    static void place(int square, char mark) {
        if (turn == 1) {
            gameBoard[square] = mark;
            turn--;
        } else if (turn == 0) {
            gameBoard[square] = mark;
            turn++;
        }

        if (checkWin('X')) {
            gameState = GameState.X_WIN;
        } else if (checkWin('O')) {
            gameState = GameState.O_WIN;
        } else if (checkDraw()) {
            gameState = GameState.DRAW;
        }
    }

    static boolean checkPossibleMove(int square) {
        return gameBoard[square] == ' ';
    }

    static boolean checkWin(char mark) {
        int index = 0;

        for (int rowOrCol = 0; rowOrCol < 3; rowOrCol++) {
            if ((gameBoard[index] == mark && gameBoard[index + 1] == mark && gameBoard[index + 2] == mark)
                    || (gameBoard[rowOrCol] == mark && gameBoard[rowOrCol + 3] == mark
                            && gameBoard[rowOrCol + 6] == mark)) {
                return true;
            }
            index += 3;
        }

        if (gameBoard[0] == mark && gameBoard[4] == mark && gameBoard[8] == mark) {
            return true;
        } else
            return gameBoard[2] == mark && gameBoard[4] == mark && gameBoard[6] == mark;
    }

    static boolean checkDraw() {
        boolean isFull = true;

        for (char character : gameBoard) {
            if (character == ' ') {
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public static int getTurn() {
        return turn;
    }

    static char getMarkAt(int i) {
        return gameBoard[i];
    }

    public static char[] getGameBoard() {
        return gameBoard;
    }

    public static GameState getGameState() {
        return gameState;
    }
}
