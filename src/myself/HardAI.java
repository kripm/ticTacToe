package myself;

public class HardAI extends AI {
    private char mark;
    private char permanentMark;
    private char otherMark;
    int moveInt = 0;
    boolean isMax;

    void move() {
        double bestScore = 0;
        char[] cloned = Board.getGameBoard();

        if (permanentMark == 'X') {
            isMax = true;
            bestScore = Double.NEGATIVE_INFINITY;
        } else {
            isMax = false;
            bestScore = Double.POSITIVE_INFINITY;
        }

        for (int i = 0; i < 9; i++) {
            if (cloned[i] == ' ') {
                cloned[i] = mark;
                mark = swap(mark);
                double currentScore = minimax(cloned, 0, !isMax);
                mark = permanentMark;
                cloned[i] = ' ';
                if ((isMax && currentScore > bestScore) || (!isMax && currentScore < bestScore)) {
                    bestScore = currentScore;
                    moveInt = i;
                }
            }
        }

        Board.place(moveInt, permanentMark);
    }

    double minimax(char[] board, double depth, boolean isMaximising) {

        if (checkWin('X', board)) {
            return (double) emptyIndexes(board) + 1;
        } else if (checkWin('O', board)) {
            return -1 * (double) (emptyIndexes(board) + 1);
        } else if (checkDraw(board)) {
            return 0;
        }

        if (isMaximising) {
            double bestScore = Double.NEGATIVE_INFINITY;
            for (int i = 0; i < 9; i++) {
                if (board[i] == ' ') {
                    board[i] = mark;
                    mark = swap(mark);
                    double score = minimax(board, depth + 1, false);
                    board[i] = ' ';
                    if (score > bestScore) {
                        bestScore = score;
                    }
                }
            }
            return bestScore;
        } else {
            double bestScore = Double.POSITIVE_INFINITY;
            for (int i = 0; i < 9; i++) {
                if (board[i] == ' ') {
                    board[i] = mark;
                    mark = swap(mark);
                    double score = minimax(board, depth + 1, true);
                    board[i] = ' ';
                    if (score < bestScore) {
                        bestScore = score;
                    }
                }
            }
            return bestScore;
        }
    }

    void isX(boolean answer) {
        if (answer) {
            this.mark = 'X';
            this.permanentMark = 'X';
            this.otherMark = 'O';
        } else {
            this.mark = 'O';
            this.permanentMark = 'O';
            this.otherMark = 'X';
        }
    }

    char swap(char a) {
        if (a == 'X') {
            return 'O';
        } else {
            return 'X';
        }
    }

    boolean swap(boolean a) {
        return !a;
    }

    boolean checkWin(char mark, char[] board) {
        int index = 0;

        for (int rowOrCol = 0; rowOrCol < 3; rowOrCol++) {
            if ((board[index] == mark && board[index + 1] == mark && board[index + 2] == mark)
                    || (board[rowOrCol] == mark && board[rowOrCol + 3] == mark && board[rowOrCol + 6] == mark)) {
                return true;
            }
            index += 3;
        }

        if (board[0] == mark && board[4] == mark && board[8] == mark) {
            return true;
        } else
            return board[2] == mark && board[4] == mark && board[6] == mark;

    }

    boolean checkDraw(char[] board) {
        boolean isFull = true;

        for (char character : board) {
            if (character == ' ') {
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    int emptyIndexes(char[] board) {
        int counter = 0;
        for (int i = 0; i < 9; i++) {
            if (board[i] == ' ') {
                counter++;
            }
        }
        return counter;
    }

}
