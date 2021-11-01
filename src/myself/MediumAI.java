package myself;

//import java.util.Arrays;
import java.util.Random;

public class MediumAI extends AI {
    static Random rn = new Random();
    private char mark;
    private char enemyMark;

    void move() {
        boolean moveComplete = false;
        do {
            if (checkThreat() != null) {
                //System.out.println("Threat at "+ Arrays.toString(checkThreat()));
                Board.place(checkThreat()[0], checkThreat()[1], mark);
                moveComplete = true;
            } else {
                int X = rn.nextInt(3);
                int Y = rn.nextInt(3);
                if (Board.checkPossibleMove(X, Y)) {
                    Board.place(X, Y, mark);
                    moveComplete = true;
                }
            }
        } while (!moveComplete);
    }

    int[] checkThreat() { // very.. convoluted. i know.
        for (int i = 0; i < 3; i++) {
            if (Board.getMarkAt(i, 0) == enemyMark
                    & Board.getMarkAt(i, 1) == enemyMark & Board.getMarkAt(i, 2) == ' ') {
                return new int[]{i, 2};
            } else if (Board.getMarkAt(i, 1) == enemyMark
                    & Board.getMarkAt(i, 2) == enemyMark & Board.getMarkAt(i, 0) == ' ') {
                return new int[]{i, 0};
            } else if (Board.getMarkAt(i, 0) == enemyMark
                    & Board.getMarkAt(i, 2) == enemyMark & Board.getMarkAt(i, 1) == ' ') {
                return new int[]{i, 1};
            } else if (Board.getMarkAt(0, i) == enemyMark
                    & Board.getMarkAt(1, i) == enemyMark & Board.getMarkAt(2, i) == ' ') {
                return new int[]{2, i};
            } else if (Board.getMarkAt(1, i) == enemyMark
                    & Board.getMarkAt(2, i) == enemyMark & Board.getMarkAt(0, i) == ' ') {
                return new int[]{0, i};
            } else if (Board.getMarkAt(0, i) == enemyMark
                    & Board.getMarkAt(2, i) == enemyMark & Board.getMarkAt(1, i) == ' ') {
                return new int[]{1, i};
            }

            if (Board.getMarkAt(0, 0) == enemyMark
                    & Board.getMarkAt(1, 1) == enemyMark & Board.getMarkAt(2, 2) == ' ') {
                return new int[]{2, 2};
            } else if (Board.getMarkAt(1, 1) == enemyMark
                    & Board.getMarkAt(2, 2) == enemyMark & Board.getMarkAt(0, 0) == ' ') {
                return new int[]{0, 0};
            } else if (Board.getMarkAt(0, 0) == enemyMark
                    & Board.getMarkAt(2, 2) == enemyMark & Board.getMarkAt(1, 1) == ' ') {
                return new int[]{1, 1};
            } else if (Board.getMarkAt(0, 2) == enemyMark
                    & Board.getMarkAt(1, 1) == enemyMark & Board.getMarkAt(2, 0) == ' ') {
                return new int[]{2, 0};
            } else if (Board.getMarkAt(2, 0) == enemyMark
                    & Board.getMarkAt(1, 1) == enemyMark & Board.getMarkAt(0, 2) == ' ') {
                return new int[]{0, 2};
            } else if (Board.getMarkAt(0, 2) == enemyMark
                    & Board.getMarkAt(2, 0) == enemyMark & Board.getMarkAt(1, 1) == ' ') {
                return new int[]{1, 1};
            }
        }
        return null;
    }

    char getMark() {
        return mark;
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
