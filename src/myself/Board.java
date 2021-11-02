package myself;

class Board {
    private static final char[][] gameBoard = new char[3][3];
    private static int turn = 1;
    static GameState gameState = GameState.UNFINISHED;

    
    static void start() {
        turn = 1;
        createNew();
        current();
    }

    private static void createNew() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = (' ');
            }
        }
    }

    private static void current() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == ' ') {
                    System.out.print("  ");
                } else {
                    System.out.print(gameBoard[i][j] + " ");
                }
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

    static void place(int X, int Y, char mark) {
        if (turn == 1) {
            gameBoard[X][Y] = mark;
            turn--;
        } else if (turn == 0) {
            gameBoard[X][Y] = mark;
            turn++;
        }
        current();
        gameState = checkWinOrDraw();
        gameState.check(gameState);
    }

    static char getMarkAt(int i, int j) {
        return gameBoard[i][j];
    }
    
    static void setTurn(int number) {
        turn = number;
    }

    static boolean checkPossibleMove(int X, int Y) {
        return gameBoard[X][Y] == ' ';
    }

    static GameState checkWinOrDraw() {
        boolean isNotFull = false;

        for (char[] character : gameBoard) {
            for (char character1 : character) {
                if (character1 == ' ') {
                    isNotFull = true;
                    break;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            int j = 0;
            if (gameBoard[i][j] == 'X' & gameBoard[i][j + 1] == 'X' & gameBoard[i][j + 2] == 'X') {
                return GameState.X_WIN;
            } else if (gameBoard[j][i] == 'X' & gameBoard[j + 1][i] == 'X' & gameBoard[j + 2][i] == 'X') {
                return GameState.X_WIN;
            } else if (gameBoard[i][j] == 'O' & gameBoard[i][j + 1] == 'O' & gameBoard[i][j + 2] == 'O') {
                return GameState.O_WIN;
            } else if (gameBoard[j][i] == 'O' & gameBoard[j + 1][i] == 'O' & gameBoard[j + 2][i] == 'O') {
                return GameState.O_WIN;
            }
        }
        if (gameBoard[0][0] == 'X' & gameBoard[1][1] == 'X' & gameBoard[2][2] == 'X') {
            return GameState.X_WIN;
        } else if (gameBoard[0][2] == 'X' & gameBoard[1][1] == 'X' & gameBoard[2][0] == 'X') {
            return GameState.X_WIN;
        } else if (gameBoard[0][0] == 'O' & gameBoard[1][1] == 'O' & gameBoard[2][2] == 'O') {
            return GameState.O_WIN;
        } else if (gameBoard[0][2] == 'O' & gameBoard[1][1] == 'O' & gameBoard[2][0] == 'O') {
            return GameState.O_WIN;
        } else if (isNotFull){
            return GameState.UNFINISHED;
        }
        return GameState.DRAW;
    }
}
