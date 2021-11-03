package myself;

public class HardAI extends AI {
    private char mark;
    private char permanentMark;
    private char otherMark;
    int moveInt = 0;
    boolean isMax;

    void move() {
        moveInt = bestMove();
        Board.place(moveInt, permanentMark);
    }

    int bestMove() {
        double bestScore;

        if (mark == 'X') {
            isMax = true;
            bestScore =  Double.NEGATIVE_INFINITY;
        } else {
            isMax = false;
            bestScore = Double.POSITIVE_INFINITY;
        }

        for (int i = 0; i < 9; i++) {
            if (Board.getMarkAt(i) == ' ') {
                Board.setMarkAt(i, mark);
                double currentScore = minimax(Board.getGameBoard(), 0, isMax);
                Board.setMarkAt(i, ' ');
                if ((isMax && currentScore > bestScore) || (!isMax && currentScore < bestScore)) {
                    bestScore = currentScore;
                    moveInt = i;
                } 
            }
        }

        return moveInt;
    }


    double score = 0;
    double minimax(char[] board, double depth, boolean isMaximising) {
        if (Board.checkWin('X')) {
            //score = (double) Board.emptyIndexes() + 1;
            return 10 - depth;
        } else if (Board.checkWin('O')) {
            //score = -1 * (double) (Board.emptyIndexes() + 1);
            return -10 + depth;
        } else if (Board.checkDraw()) {
            score = 0;
            return score;
        }

        if (isMaximising) {
            double bestScore = Double.NEGATIVE_INFINITY;
            for (int i = 0; i < 9; i++) {
                if (Board.getMarkAt(i) == ' ') {
                    Board.setMarkAt(i, mark);
                    mark = swap(mark);
                    score = minimax(board, depth + 1, false);
                    Board.setMarkAt(i, ' ');
                    if (score > bestScore) {
                        bestScore = score;
                    }
                }
            }
            return bestScore;
        } else {
            double bestScore = Double.POSITIVE_INFINITY;
            for (int i = 0; i < 9; i++) {
                if (Board.getMarkAt(i) == ' ') {
                    Board.setMarkAt(i, otherMark); 
                    otherMark = swap(otherMark);
                    score = minimax(board, depth + 1, true);
                    Board.setMarkAt(i, ' ');
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
}
