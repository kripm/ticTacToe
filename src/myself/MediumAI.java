package myself;

import java.util.Random;

public class MediumAI extends AI {
    static Random rn = new Random();
    private char mark;

    void move() {
        boolean moveComplete = false;
        do {
            if (checkThreat() != null) {
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

    int[] checkThreat() {
        for (int i = 0; i < 3; i++) {
            if (Board.getMarkAt(i, 0) == Main.playerOne.getMark()
                    & Board.getMarkAt(i, 1) == Main.playerOne.getMark()) {
                return new int[]{i, 2};
            } else if (Board.getMarkAt(i, 1) == Main.playerOne.getMark()
                    & Board.getMarkAt(i, 2) == Main.playerOne.getMark()) {
                return new int[]{i, 0};
            } else if (Board.getMarkAt(0, i) == Main.playerOne.getMark()
                    & Board.getMarkAt(1, i) == Main.playerOne.getMark()) {
                return new int[]{2, i};
            } else if (Board.getMarkAt(1, i) == Main.playerOne.getMark()
                    & Board.getMarkAt(2, i) == Main.playerOne.getMark()) {
                return new int[]{0, i};
            }
        }
        return null;
    }

    public char getMark() {
        return mark;
    }

    public void setMark(char mark) {
        this.mark = mark;
    }
}
