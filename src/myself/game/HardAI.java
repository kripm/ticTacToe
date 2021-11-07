package myself.game;

public class HardAI implements AI {
    private char mark;
    private char permanentMark;
    private static final int MAX_DEPTH = 6;
    private char[] board = Board.gameBoard;

    public void move() {
        boolean isMax;
        int moveInt = 0;
        int bestScore;
        int alpha;
        int beta;

        if (permanentMark == 'X') {
            isMax = true;
            bestScore = Integer.MIN_VALUE;
            beta = Integer.MAX_VALUE;
            alpha = Integer.MIN_VALUE;
        } else {
            isMax = false;
            bestScore = Integer.MAX_VALUE;
            beta = Integer.MIN_VALUE;
            alpha = Integer.MAX_VALUE;
        }

        for (int i = 0; i < 9; i++) {
            if (board[i] == ' ') {
                board[i] = mark;
                mark = swap(mark);
                int currentScore = minimax(Board.gameBoard, MAX_DEPTH, alpha, beta, !isMax);
                mark = permanentMark;
                board[i] = ' ';
                if ((isMax && currentScore > bestScore) || (!isMax && currentScore < bestScore)) {
                    moveInt = i;
                    bestScore = currentScore;
                }
            }
        }

        Board.place(moveInt, permanentMark);
    }

    int minimax(char[] board, int depth, int alpha, int beta, boolean isMaximising) {
        int boardVal = evaluateBoard(board, depth);

        if (Math.abs(boardVal) > 0 || depth == 0 || !anyAvailableMove(board)) {
            return boardVal;
        }

        if (isMaximising) {
            int highestVal = Integer.MIN_VALUE;
            for (int i = 0; i < 9; i++) {
                if (board[i] == ' ') {
                    board[i] = mark;
                    mark = swap(mark);
                    highestVal = Math.max(highestVal, minimax(board, depth - 1, alpha, beta, false));
                    mark = swap(mark);
                    board[i] = ' ';
                    alpha = highestVal;
                    if (beta <= alpha) {
                        break;
                    }
                }
            }
            return highestVal;
        } else {
            int lowestVal = Integer.MAX_VALUE;
            for (int i = 0; i < 9; i++) {
                if (board[i] == ' ') {
                    board[i] = mark;
                    mark = swap(mark);
                    lowestVal = Math.min(lowestVal, minimax(board, depth - 1, alpha, beta, true));
                    mark = swap(mark);
                    board[i] = ' ';
                    beta = lowestVal;
                    if (beta <= alpha) {
                        break;
                    }

                }
            }
            return lowestVal;
        }
    }

    public void isX(boolean answer) {
        if (answer) {
            this.mark = 'X';
            this.permanentMark = 'X';
        } else {
            this.mark = 'O';
            this.permanentMark = 'O';
        }
    }

    char swap(char a) {
        if (a == 'X') {
            return 'O';
        } else {
            return 'X';
        }
    }

    int evaluateBoard(char[] board, int depth) {
        int index = 0;

        for (int rowOrCol = 0; rowOrCol < 3; rowOrCol++) {
            if ((board[index] == 'X' && board[index + 1] == 'X' && board[index + 2] == 'X')
                    || (board[rowOrCol] == 'X' && board[rowOrCol + 3] == 'X' && board[rowOrCol + 6] == 'X')) {
                return 10 + depth;
            } else if ((board[index] == 'O' && board[index + 1] == 'O' && board[index + 2] == 'O')
                    || (board[rowOrCol] == 'O' && board[rowOrCol + 3] == 'O' && board[rowOrCol + 6] == 'O')) {
                return -10 - depth;
            }
            index += 3;
        }

        if (board[0] == 'X' && board[4] == 'X' && board[8] == 'X') {
            return 10 + depth;
        } else if (board[0] == 'O' && board[4] == 'O' && board[8] == 'O') {
            return -10 - depth;
        } else if (board[2] == 'X' && board[4] == 'X' && board[6] == 'X') {
            return 10 + depth;
        } else if (board[2] == 'O' && board[4] == 'O' && board[6] == 'O') {
            return -10 - depth;
        }
        return 0;
    }

    boolean anyAvailableMove(char[] board) {
        int counter = 0;
        for (int i = 0; i < 9; i++) {
            if (board[i] == ' ') {
                counter++;
            }
        }
        return counter > 0;
    }
}
