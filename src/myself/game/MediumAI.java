package myself.game;

import java.util.Random;

public class MediumAI implements AI {
    static Random rn = new Random();
    private char mark;
    private char enemyMark;

    public void move() {
        boolean moveComplete = false;
        do {
            if (checkThreat() != -1) {
                Board.place(checkThreat(), mark);
                moveComplete = true;
            } else {
                int square = rn.nextInt(9);
                if (Board.checkPossibleMove(square)) {
                    Board.place(square, mark);
                    moveComplete = true;
                }
            }
        } while (!moveComplete);
    }

    public void isX(boolean answer) {
        if (answer) {
            this.mark = 'X';
            this.enemyMark = 'O';
        } else {
            this.mark = 'O';
            this.enemyMark = 'X';
        }
    }

    int checkThreat() { // very.. convoluted. i know.
        int index = 0;
        for (int rowOrCol = 0; rowOrCol < 3; rowOrCol++) {
            if (Board.getMarkAt(index) == enemyMark && Board.getMarkAt(index + 1) == enemyMark
                    && Board.getMarkAt(index + 2) == ' ') {
                return index + 2;
            } else if (Board.getMarkAt(index + 1) == enemyMark && Board.getMarkAt(index + 2) == enemyMark
                    && Board.getMarkAt(index) == ' ') {
                return index;
            } else if (Board.getMarkAt(index) == enemyMark && Board.getMarkAt(index + 2) == enemyMark
                    && Board.getMarkAt(index + 1) == ' ') {
                return ++index;
            } else if (Board.getMarkAt(rowOrCol) == enemyMark && Board.getMarkAt(rowOrCol + 3) == enemyMark
                    && Board.getMarkAt(rowOrCol + 6) == ' ') {
                return rowOrCol + 6;
            } else if (Board.getMarkAt(rowOrCol) == enemyMark && Board.getMarkAt(rowOrCol + 6) == enemyMark
                    && Board.getMarkAt(rowOrCol + 3) == ' ') {
                return rowOrCol + 3;
            } else if (Board.getMarkAt(rowOrCol + 3) == enemyMark && Board.getMarkAt(rowOrCol + 6) == enemyMark
                    && Board.getMarkAt(rowOrCol) == ' ') {
                return rowOrCol;
            }
            index += 3;
        }

        if (Board.getMarkAt(0) == enemyMark && Board.getMarkAt(4) == enemyMark && Board.getMarkAt(8) == ' ') {
            return 8;
        } else if (Board.getMarkAt(4) == enemyMark && Board.getMarkAt(8) == enemyMark && Board.getMarkAt(0) == ' ') {
            return 0;
        } else if (Board.getMarkAt(0) == enemyMark && Board.getMarkAt(8) == enemyMark && Board.getMarkAt(4) == ' ') {
            return 4;
        } else if (Board.getMarkAt(2) == enemyMark && Board.getMarkAt(4) == enemyMark && Board.getMarkAt(6) == ' ') {
            return 6;
        } else if (Board.getMarkAt(4) == enemyMark && Board.getMarkAt(6) == enemyMark && Board.getMarkAt(2) == ' ') {
            return 2;
        } else if (Board.getMarkAt(2) == enemyMark && Board.getMarkAt(6) == enemyMark && Board.getMarkAt(4) == ' ') {
            return 4;
        }
        return -1;
    }
}
