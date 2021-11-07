package myself.game;

class Board {
    protected static final char[] gameBoard = new char[9];
    private static int turn = 1;
    static GameState gameState = GameState.UNFINISHED;

    private Board() {
        throw new IllegalStateException("Utility class");
      }

    static void start() {
        turn = 1;
        createNew();
        current();
    }

    private static void createNew() {
        for (int i = 0; i < 9; i++) {
            gameBoard[i] = (' ');
        }
    }

    private static void current() {
        System.out.println("---------");
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                if (gameBoard[counter] == ' ') {
                    System.out.print("  ");
                } else {
                    System.out.print(gameBoard[counter] + " ");
                }
                counter++;
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    static void play(Player playerOne, AI ai) { // b.
        if (turn == 1) {
            playerOne.move();
        } else if (turn == 0) {
            ai.move();
        }
    }

    static void play(Player playerOne, Player playerTwo) {
        if (turn == 1) {
            playerOne.move();
        } else if (turn == 0) {
            playerTwo.move();
        }
    }

    static void play(AI ai, AI aii) {
        if (turn == 1) {
            ai.move();
        } else if (turn == 0) {
            aii.move();
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
        current();
        if (checkWin('X')) {
            gameState = GameState.X_WIN;
        } else if (checkWin('O')) {
            gameState = GameState.O_WIN;
        } else if (checkDraw()) {
            gameState = GameState.DRAW;
        }
        gameState.check(gameState);
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

    static void setTurn(int number) {
        turn = number;
    }

    static char getMarkAt(int i) {
        return gameBoard[i];
    }

    static void setMarkAt(int i, char mark) {
        gameBoard[i] = mark;
    }

    static char[] getGameBoard() {
        return gameBoard;
    }
}
