package myself;

import java.util.Arrays;

public class HardAI extends AI {
    private char mark;
    private char enemyMark;

    void move() {
        int move;

        if (mark == 'X') {
            move = bestMoveForX();
        } else {
            move = bestMoveForO();
        }

        Board.place(move, mark);
    }

    int move = 0;
    int bestMoveForX() {
        double bestScore = Double.NEGATIVE_INFINITY;

        for (int i = 0; i < 9; i++) {
            if (Board.getMarkAt(i) == ' ') {
                Board.setMarkAt(i, mark);
                double score = minimax(Board.getGameBoard(), 0, true);
                Board.getGameBoard()[i] = ' ';
                if (score > bestScore) {
                    bestScore = score;
                    move = i;
                }
            }
        }
        //System.out.println(move);
        return move;
    }

    int bestMoveForO() {
        double bestScore = Double.POSITIVE_INFINITY;

        for (int i = 0; i < 9; i++) {
            if (Board.getMarkAt(i) == ' ') {
                Board.setMarkAt(i, mark);
                System.out.println("g");
                System.out.println(Arrays.toString(Board.getGameBoard()));
                double score = minimax(Board.getGameBoard(), 0, false);
                Board.getGameBoard()[i] = ' ';
                if (score < bestScore) {
                    bestScore = score;
                    move = i;
                }
            }
        }
        System.out.println(move);
        return move;
    }

    double score = 0;
    double minimax(char[] board, double depth, boolean isMaximising) {

        if (Board.checkWin('X')) {
            score = Board.emptyIndexes() + 1;
            return score;
        } else if (Board.checkWin('O')) {
            score = -1 * (Board.emptyIndexes() + 1);
            return score;
        } else if (Board.emptyIndexes() == 0) {
            score = 0;
            return score;
        }

        if (isMaximising) {
            double bestScore = Double.NEGATIVE_INFINITY;
            for (int i = 0; i < 9; i++) {
                if (board[i] == ' ') {
                    board[i] = mark;
                    score = minimax(board, depth + 1, false);
                    board[i] = ' ';
                    if (score > bestScore) {
                        //System.out.println(score);
                        bestScore = score;
                    }
                }
            }
            return bestScore;
        } else {
            double bestScore = Double.POSITIVE_INFINITY;
            for (int i = 0; i < 9; i++) {
                if (board[i] == ' ') {
                    board[i] = enemyMark;
                    score = minimax(board, depth + 1, true);
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
            this.enemyMark = 'O';
        } else {
            this.mark = 'O';
            this.enemyMark = 'X';
        }
    }
}
